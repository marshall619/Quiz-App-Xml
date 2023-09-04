package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.buttonstart.setOnClickListener{
            if (binding.usernametext.text.toString().isEmpty())
            {
                Toast.makeText(this,"لطفا نام کاربری را وارد کنید.",Toast.LENGTH_LONG).show()
            }else{
                val intent=Intent(this,qustions::class.java)
                intent.putExtra("username",binding.usernametext.text.toString())
                startActivity(intent)
            }
        }

    }
}