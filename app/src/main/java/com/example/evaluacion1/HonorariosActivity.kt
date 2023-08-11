package com.example.evaluacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import android.content.Intent
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacion1.ui.theme.Evaluacion1Theme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType

class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            honorariosPantallaUI()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun honorariosPantallaUI() {

    var sueldoBruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto= LocalContext.current

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculo de de pagos para trabajadores a honorarios")
        Spacer(modifier = Modifier.height(30.dp))
        TextField(value = sueldoBruto,
                  onValueChange ={sueldoBruto = it},
                  label = { Text(text = "Sueldo Bruto")},
                  keyboardOptions = KeyboardOptions(
                      keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val sueldoBru = sueldoBruto.toDouble()
            val sueldoLiquido = calculo(sueldoBru)
            resultado  = "El sueldo liquido corresponde ${sueldoLiquido} con retencion del 13% "
        }) {
            Text(text = "Calcular")
           }
        Spacer(modifier = Modifier.height(15.dp))
        Text(resultado)
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "Volver")
        }

    }


}
fun calculo(sueldo :Double):Double{
    return sueldo -(sueldo * 13/100 )

}




