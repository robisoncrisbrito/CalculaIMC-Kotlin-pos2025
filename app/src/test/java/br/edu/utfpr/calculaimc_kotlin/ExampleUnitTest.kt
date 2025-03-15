package br.edu.utfpr.calculaimc_kotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val resultado = MainActivity.calculaIMC( 90.0, 1.9 , "pt" )
        assertTrue( "IMC Calculado corretamente: ",
            MainActivity.calculaIMC( 90.0, 1.9 , "pt" ) in 24.93 .. 24.94 )
    }
}