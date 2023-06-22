package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class Length : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)

        input1 = findViewById(R.id.input1_length)
        input2 = findViewById(R.id.input2_length)
        unit1 = findViewById(R.id.unit1_length)
        unit2 = findViewById(R.id.unit2_length)

        unit1.setSelection(4)
        unit2.setSelection(7)

        conversions = HashMap()
        conversions["Nanometre (nm)"] = BigDecimal("0.000000001")
        conversions["Micrometre (μm)"] = BigDecimal("0.000001")
        conversions["Millimetre (mm)"] = BigDecimal("0.001")
        conversions["Centimetre (cm)"] = BigDecimal("0.01")
        conversions["Metre (m)"] = BigDecimal("1")
        conversions["Kilometre (km)"] = BigDecimal("1000")
        conversions["Inch (in)"] = BigDecimal("0.0254")
        conversions["Foot (ft)"] = BigDecimal("0.3048")
        conversions["Yard (yd)"] = BigDecimal("0.9144")
        conversions["Mile (mi)"] = BigDecimal("1609.344")
        conversions["Nautical mile (M, NM, nmi)"] = BigDecimal("1852")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}