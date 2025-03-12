package com.example.android_60



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.get
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var gasolinaInput: TextInputLayout
    private lateinit var gasolinaEditInput: TextInputEditText
    private lateinit var alcoolInput: TextInputLayout
    private lateinit var alcoolEditInput: TextInputEditText
    private lateinit var resultado: Button
    private lateinit var resultadoDetalhado: Button
    private lateinit var textResultado: TextView
    private lateinit var aviso: TextView
    private lateinit var rendimento: TextView

    private fun config(){
        gasolinaInput = findViewById(R.id.text_gasolina)
        gasolinaEditInput = findViewById(R.id.edit_gasolina)

        alcoolInput = findViewById(R.id.text_alcool)
        alcoolEditInput = findViewById(R.id.edit_alcool)

        resultado = findViewById(R.id.btn_resultado)
        textResultado = findViewById(R.id.text_resultado)




    }
    private fun verificar(pGasolina: String, pAlcool: String): Boolean{

        gasolinaEditInput.error = null
        alcoolEditInput.error = null

        if(pGasolina.isEmpty()){
            gasolinaEditInput.error ="Digite o preço da gasolina."
            return false
        }else if(pAlcool.isEmpty()){
            alcoolEditInput.error = "Digite o preço do álcool"
            return false
        }
        return true
    }
    private fun calcularPreco(){
        val precoGasolina = gasolinaEditInput.text.toString()
        val precoAlcool = alcoolEditInput.text.toString()

        val validacao = verificar(precoGasolina, precoAlcool)
        if(validacao){

            val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()
            if(resultado >= 0.73){
                textResultado.text = "É melhor utilizar gasolina!"
            }else{
                textResultado.text = "É melhor utilizar  álcool!"
            }




        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        config()
        resultado.setOnClickListener(){
            calcularPreco()


        }




    }
}
