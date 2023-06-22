package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class Volume : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        input1 = findViewById(R.id.input1_volume)
        input2 = findViewById(R.id.input2_volume)
        unit1 = findViewById(R.id.unit1_volume)
        unit2 = findViewById(R.id.unit2_volume)

        unit1.setSelection(3)
        unit2.setSelection(13)

        conversions = HashMap()
        conversions["Cubic centimetre (cm³, cc)"] = BigDecimal("0.000001")
        conversions["Cubic metre (m³)"] = BigDecimal("1")
        conversions["Millilitre (mL)"] = BigDecimal("0.000001")
        conversions["Litre (L)"] = BigDecimal("0.001")
        conversions["Cubic inch (in³, cu in)"] = BigDecimal("0.000016387064")
        conversions["Cubic foot (ft³, cu ft)"] = BigDecimal("0.028316846592")
        conversions["US Teaspoon (tsp)"] = BigDecimal("0.00000492892159375")
        conversions["US Tablespoon (tbsp)"] = BigDecimal("0.00001478676478125")
        conversions["US fluid ounce (fl oz)"] = BigDecimal("0.0000295735295625")
        conversions["US cup (c)"] = BigDecimal("0.0002365882365")
        conversions["US legal cup"] = BigDecimal("0.00024")
        conversions["US liquid pint (pt)"] = BigDecimal("0.000473176473")
        conversions["US liquid quart (qt)"] = BigDecimal("0.000946352946")
        conversions["US liquid gallon (gal)"] = BigDecimal("0.003785411784")
        conversions["Imperial fluid ounce (fl oz)"] = BigDecimal("0.0000284130625")
        conversions["Imperial pint (pt)"] = BigDecimal("0.00056826125")
        conversions["Imperial quart (qt)"] = BigDecimal("0.0011365225")
        conversions["Imperial gallon (gal)"] = BigDecimal("0.00454609")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}