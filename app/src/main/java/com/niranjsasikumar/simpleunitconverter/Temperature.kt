package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class Temperature : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)

        input1 = findViewById(R.id.input1_temperature)
        input2 = findViewById(R.id.input2_temperature)
        unit1 = findViewById(R.id.unit1_temperature)
        unit2 = findViewById(R.id.unit2_temperature)

        unit1.setSelection(0)
        unit2.setSelection(1)

        val mc = MathContext(100, RoundingMode.HALF_UP)
        conversions = HashMap()
        conversions["Celsius (°C)"] = BigDecimal("1")
        conversions["Fahrenheit (°F)"] = BigDecimal("-155").divide(BigDecimal("9"), mc)
        conversions["Kelvin (K)"] = BigDecimal("-272.15")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}