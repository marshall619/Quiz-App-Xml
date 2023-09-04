package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQustionsBinding

class qustions : AppCompatActivity() {
    lateinit var binding: ActivityQustionsBinding
    lateinit var qustionlist:ArrayList<Quiz>
    var currendq = 0
    var selectedop = 0
    var correctans = 0
    var wrongans = 0
    var shownullans = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQustionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        qustionlist = Constans.getqustions()

        loadqustions()
        val username2 = getIntent().getStringExtra("username")
        binding.usershow.text = username2

    }

    fun loadqustions(){

        val qustion = qustionlist[currendq]
        binding.qustionrej.text = qustion.qustion
        binding.imageView.setImageResource(qustion.image)
        binding.option1.text = qustion.ans1
        binding.option2.text = qustion.ans2
        binding.option3.text = qustion.ans3
        binding.option4.text = qustion.ans4
        binding.progressBar.progress = currendq + 1
        binding.progress.text = "${currendq+1} / ${binding.progressBar.max}"

    }

    fun clickOnOptions(view: View){
        setDefaultoptions()
        var textviewop = view as TextView

        when(textviewop.tag.toString())
        {
            "op1"->{
                selectedop = 1
            }
            "op2"->{
                selectedop = 2
            }
            "op3"->{
                selectedop = 3
            }
            "op4"->{
                selectedop = 4
            }
        }

        textviewop.typeface = Typeface.DEFAULT_BOLD
        textviewop.background = ContextCompat.getDrawable(this, R.drawable.text_darow_selected)
        textviewop.setTextColor(Color.parseColor("#000000"))
    }

    fun setDefaultoptions(){
        var arrytext = ArrayList<TextView>()
        binding.button.setText("ثبت جواب")
        arrytext.add(binding.option1)
        arrytext.add(binding.option2)
        arrytext.add(binding.option3)
        arrytext.add(binding.option4)
        for (textView in arrytext) {
            textView.typeface = Typeface.DEFAULT
            textView.background = ContextCompat.getDrawable(this, R.drawable.text_darow)
            textView.setTextColor(Color.parseColor("#7a8089"))
        }

    }

    fun clickOnAns(view: View){
        checklastqustion()
        if(selectedop == 0 && currendq < 7){
            if (binding.button.text != "سوال بعدی" )shownullans = 0

            if (shownullans == 0)
            {
               setbackground(qustionlist[currendq].Cans , R.drawable.text_darow_correct)
                shownullans++
                wrongans++
                binding.button.setText("سوال بعدی")
                return
            }
            currendq++
            setDefaultoptions()
            loadqustions()

        }else if(selectedop == qustionlist[currendq].Cans){

           correctans++
           setbackground(selectedop , R.drawable.text_darow_correct)
           binding.button.setText("سوال بعدی")
           selectedop = 0

        }else {
           wrongans++
           setbackground(selectedop , R.drawable.text_darow_wrong)
           setbackground(qustionlist[currendq].Cans , R.drawable.text_darow_correct)
           binding.button.setText("سوال بعدی")
           selectedop = 0

        }

    }

    fun checklastqustion(){
        if (currendq == qustionlist.size - 1){

            binding.button.visibility = View.GONE
            binding.buttonresult.visibility = View.VISIBLE
            binding.buttonresult.setOnClickListener{
                val username = getIntent().getStringExtra("username")
                val intent= Intent(this,Result::class.java)
                intent.putExtra("wrongans",wrongans)
                intent.putExtra("correctans",correctans)
                intent.putExtra("username1",username)
                startActivity(intent)

            }
        }
    }

    fun setbackground(optionnum:Int,drawable:Int){
        when(optionnum){
            1->{
                binding.option1.background = ContextCompat.getDrawable(this,drawable)
            }
            2->{
                binding.option2.background = ContextCompat.getDrawable(this,drawable)
            }
            3->{
                binding.option3.background = ContextCompat.getDrawable(this,drawable)
            }
            4->{
                binding.option4.background = ContextCompat.getDrawable(this,drawable)
            }

        }
    }
}