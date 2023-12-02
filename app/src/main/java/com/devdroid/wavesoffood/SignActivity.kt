package com.devdroid.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.util.Log
import android.widget.Toast
import com.devdroid.wavesoffood.Model.UserModel
import com.devdroid.wavesoffood.databinding.ActivityLoginBinding
import com.devdroid.wavesoffood.databinding.ActivitySignBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var name:String
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var database:DatabaseReference
    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = Firebase.auth
        database =Firebase.database.reference
        binding.createAccount.setOnClickListener {
            email = binding.emailOfUser.text.toString().trim()
            password = binding.passwordOfUser.text.toString().trim()
            name = binding.name.text.toString().trim()
            if(email.isBlank() || password.isBlank() || name.isBlank()){
                Toast.makeText(this,"please fill all details",Toast.LENGTH_SHORT).show()
            }else{
                createAccount(email,password)
            }

        }
        binding.alreadyhaveaccount.setOnClickListener {
            val intent=Intent(this,login_activity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {task ->
        if(task.isSuccessful){
            Toast.makeText(this,"Account Create Successful",Toast.LENGTH_SHORT).show()
            saveUserData()
            val intent=Intent(this,login_activity::class.java)
            startActivity(intent)
            finish()
        }
            else{
            Toast.makeText(this,"Account Creation Failed",Toast.LENGTH_SHORT).show()
            Log.d("Account", "createAccount: failure",task.exception)
        }

        }
    }

    private fun saveUserData() {
        email = binding.emailOfUser.text.toString().trim()
        password = binding.passwordOfUser.text.toString().trim()
        name = binding.name.text.toString().trim()
        val user= UserModel(name,email,password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)
    }
}