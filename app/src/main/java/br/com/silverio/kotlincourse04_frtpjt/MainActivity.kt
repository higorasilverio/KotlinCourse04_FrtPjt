package br.com.silverio.kotlincourse04_frtpjt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if (validaCampos == true) calcularMelhorPreco(precoAlcool, precoGasolina)
        else Toast.makeText(applicationContext,"Preencha os campos primeiro!", Toast.LENGTH_SHORT).show()

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados: Boolean = true

        if ( precoAlcool == null || precoAlcool.equals("") ) camposValidados = false
        else if ( precoGasolina == null || precoGasolina.equals("") ) camposValidados = false

        return camposValidados

    }


    fun calcularMelhorPreco (precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if ( resultadoPreco >= 0.7 ) text_resultado.setText("Melhor usar gasolina!")
        else text_resultado.setText("Melhor usar álcool!")

    }

}
