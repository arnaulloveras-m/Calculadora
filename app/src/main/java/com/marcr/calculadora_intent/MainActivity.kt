package com.marcr.calculadora_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.marcr.calculadora_intent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val REQUEST_CODE = 1
        val intent = Intent(this, MainActivity2::class.java)

        binding.button.setOnClickListener {
            val number1 = binding.editTextText.text.toString()
            val number2 = binding.editTextText2.text.toString()

            if (number1.isNotBlank() && number2.isNotBlank()) {
                intent.putExtra("number1", number1)
                intent.putExtra("number2", number2)
                startActivityForResult(intent, REQUEST_CODE)
            } else {
                Toast.makeText(this, "Emplena correctament els camps", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val result = data?.getStringExtra("result")
            Toast.makeText(this, "Resultado: $result", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Error en el procediment", Toast.LENGTH_SHORT).show()
        }
    }
}