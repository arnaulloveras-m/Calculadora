package com.marcr.calculadora_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.marcr.calculadora_intent.databinding.ActivityMain2Binding
import com.marcr.calculadora_intent.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val number1 = intent.getStringExtra("number1")?.toInt() ?: 0
        val number2 = intent.getStringExtra("number2")?.toInt() ?: 0

        binding.textView.text = number1.toString()
        binding.textView2.text = number2.toString()

        binding.button2.setOnClickListener {
            val result = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("result", result.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}