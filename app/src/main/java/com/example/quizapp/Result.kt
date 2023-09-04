package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.databinding.ActivityQustionsBinding
import com.example.quizapp.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    var correctans = 0
    var wrongans = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

             binding = ActivityResultBinding.inflate(layoutInflater)
             setContentView(binding.root)

           val username1 = getIntent().getStringExtra("username1")
               wrongans = getIntent().getIntExtra("wrongans",0)
               correctans = getIntent().getIntExtra("correctans",0)

        binding.correct.text = correctans.toString()
        binding.wrong.text = wrongans.toString()
        binding.username.text = username1
        binding.wrong.setTextColor(Color.parseColor("#ff1744"))
        binding.correct.setTextColor(Color.parseColor("#76ff03"))
        // Task 1................
        setcolors(wrongans,correctans)
        // Task 2......................
        calculatewrongs(wrongans,correctans)
        // Task 3.......
        if (correctans == 7)
        {
            binding.username.visibility = View.GONE
            binding.wrong.visibility = View.GONE
            binding.correct.visibility = View.GONE
        }
        // Task 4.......
        val c_persent = (correctans * 100)/7
        val w_persent = 100 - c_persent
        binding.correctper.text = c_persent.toString() + "%"
        binding.wrongper.text = w_persent.toString() + "%"
        binding.wrongper.setTextColor(Color.parseColor("#ff1744"))
        binding.correctper.setTextColor(Color.parseColor("#76ff03"))
    }

    fun setcolors(wrong:Int,correct:Int){
        if (wrong > correct)
        {
         binding.username.setTextColor(Color.parseColor("#ff1744"))
        }else binding.username.setTextColor(Color.parseColor("#76ff03"))
    }

    fun calculatewrongs(wrong:Int,correct:Int){
        val ans = wrong/3
        val correct1 = correct - ans
        binding.correct.text = correct1.toString()
    }
}