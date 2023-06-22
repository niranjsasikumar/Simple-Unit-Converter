package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class Area : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        input1 = findViewById(R.id.input1_area)
        input2 = findViewById(R.id.input2_area)
        unit1 = findViewById(R.id.unit1_area)
        unit2 = findViewById(R.id.unit2_area)

        unit1.setSelection(1)
        unit2.setSelection(5)

        conversions = HashMap()
        conversions["Square centimetre (cm²)"] = BigDecimal("0.0001")
        conversions["Square metre (m²)"] = BigDecimal("1")
        conversions["Square kilometre (km²)"] = BigDecimal("1000000")
        conversions["Hectare (ha)"] = BigDecimal("10000")
        conversions["Square inch (sq in)"] = BigDecimal("0.00064516")
        conversions["Square foot (sq ft)"] = BigDecimal("0.09290304")
        conversions["Square yard (sq yd)"] = BigDecimal("0.83612736")
        conversions["Square mile (sq mi)"] = BigDecimal("2589988.11")
        conversions["Acre (ac)"] = BigDecimal("4046.8564224")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}