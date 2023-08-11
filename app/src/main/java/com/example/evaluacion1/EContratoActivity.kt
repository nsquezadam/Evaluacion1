package com.example.evaluacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_econtrato)

        val volver = findViewById<Button>(R.id.btnVolver)
        volver.setOnClickListener{
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        val sueldo = findViewById<EditText>(R.id.boxSueldo)
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.textView7)
        var  liquido:Double? =null
        calcular.setOnClickListener {
            if(sueldo.text.isNotEmpty()){
                liquido = sueldo.text.toString().toDouble() - (sueldo.text.toString().toDouble() * 20/100 )
                resultado.text = "El sueldo Liquido es ${liquido} con retencion del 20%"

            }else{
                Toast.makeText(this,"El campo no puede estar vacio",Toast.LENGTH_SHORT).show()
            }


        }

    }

}