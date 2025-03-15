package br.edu.utfpr.calculaimc_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById( R.id.etPeso )
        etAltura = findViewById( R.id.etAltura )
        tvResultado = findViewById( R.id.tvResultado )
        btCalcular = findViewById( R.id.btCalcular )
        btLimpar = findViewById( R.id.btLimpar )

        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }

    }

    private fun btLimparOnClick() {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.text = getString( R.string.zeros )
        etPeso.requestFocus()
    }

    private fun btCalcularOnClick() {

        if ( etPeso.text.toString().isEmpty() ) {
            etPeso.error = getString(R.string.error_peso)
            return
        }

        if ( etAltura.text.toString().isEmpty() ) {
            etAltura.error = getString(R.string.error_altua)
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        var imc : Double

        if ( Locale.getDefault().language.equals( "en" ) ) {
            imc = calculaIMC( peso, altura, Locale.getDefault().language )
            val nf = NumberFormat.getNumberInstance( Locale.US )
            val df = nf as DecimalFormat
            tvResultado.text= df.format( imc )
        } else {
            imc = calculaIMC( peso, altura, Locale.getDefault().language )
            val df = DecimalFormat( "0.0" )
            tvResultado.text= df.format( imc )
        }

    } //fim do btCalcularOnClick

    companion object {

        fun calculaIMC( peso : Double, altura: Double, locale : String ) : Double {

            if ( locale.equals( "en" ) ) {
                return 703 * ( peso / altura.pow( 2 ) )
            } else {
                return ( peso / altura.pow( 2 ) )
            }
        }
    }


} //fim da MainActivity

