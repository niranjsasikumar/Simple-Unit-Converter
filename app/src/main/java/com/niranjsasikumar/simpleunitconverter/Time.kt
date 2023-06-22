package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class Time : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        input1 = findViewById(R.id.input1_time)
        input2 = findViewById(R.id.input2_time)
        unit1 = findViewById(R.id.unit1_time)
        unit2 = findViewById(R.id.unit2_time)

        unit1.setSelection(2)
        unit2.setSelection(1)

        conversions = HashMap()
        conversions["Millisecond (ms)"] = BigDecimal("0.001")
        conversions["Second (s)"] = BigDecimal("1")
        conversions["Minute"] = BigDecimal("60")
        conversions["Hour (h)"] = BigDecimal("3600")
        conversions["Day"] = BigDecimal("86400")
        conversions["Week"] = BigDecimal("604800")
        conversions["Month"] = BigDecimal("2628000")
        conversions["Year"] = BigDecimal("31536000")
        conversions["Decade"] = BigDecimal("315360000")
        conversions["Century"] = BigDecimal("3153600000")
        conversions["Millennium"] = BigDecimal("31536000000")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}