package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class Speed : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speed)

        input1 = findViewById(R.id.input1_speed)
        input2 = findViewById(R.id.input2_speed)
        unit1 = findViewById(R.id.unit1_speed)
        unit2 = findViewById(R.id.unit2_speed)

        unit1.setSelection(1)
        unit2.setSelection(3)

        conversions = HashMap()
        conversions["Metre per second (m/s)"] = BigDecimal("3.6")
        conversions["Kilometre per hour (km/h)"] = BigDecimal("1")
        conversions["Foot per second (ft/s)"] = BigDecimal("1.09728")
        conversions["Miles per hour (mph)"] = BigDecimal("1.609344")
        conversions["Knot (kn, kt)"] = BigDecimal("1.852")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}