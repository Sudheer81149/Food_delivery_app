package com.devdroid.wavesoffood

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.devdroid.wavesoffood.Model.UserModel
import com.devdroid.wavesoffood.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class login_activity : AppCompatActivity() {
    private var name: String? = null
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var googleSignInClient: GoogleSignInClient
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val googleSignInOptions: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_clint_Id)).requestEmail().build()
        auth = Firebase.auth
        database = Firebase.database.reference
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        binding.logInButton.setOnClickListener {
            email = binding.emailOfUser.text.toString().trim()
            password = binding.password.text.toString().trim()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                creatUserAccount(email, password)
            }
        }
        binding.googleButton.setOnClickListener {
            val sighInIntent = googleSignInClient.signInIntent
            launcer.launch(sighInIntent)
        }
        binding.donthavebutton.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }
    }

    private fun creatUserAccount(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                updateUi(user)
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(this, "Create User and login Successful", Toast.LENGTH_SHORT)
                            .show()
                        saveUserData()
                        updateUi(user)
                    } else {
                        Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                        Log.d("Account", "createAccount: failure", task.exception)
                    }
                }
            }
        }
    }

    private fun saveUserData() {
        email = binding.emailOfUser.text.toString().trim()
        password = binding.password.text.toString().trim()
        val user = UserModel(name, email, password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)
    }

    private fun updateUi(user: FirebaseUser?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private val launcer =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    val account: GoogleSignInAccount = task.result
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    auth.signInWithCredential(credential).addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Successfully register into application",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUi(authTask.result?.user)
                            finish()
                        } else {
                            Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    override fun onStart() {
        super.onStart()
        val currentUser=auth.currentUser
        if(currentUser!=null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}