package com.niranjsasikumar.simpleunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal

class DataStorage : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var unit1: Spinner
    private lateinit var unit2: Spinner
    private lateinit var conversions : HashMap<String, BigDecimal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        input1 = findViewById(R.id.input1_storage)
        input2 = findViewById(R.id.input2_storage)
        unit1 = findViewById(R.id.unit1_storage)
        unit2 = findViewById(R.id.unit2_storage)

        unit1.setSelection(4)
        unit2.setSelection(3)

        conversions = HashMap()
        conversions["Bit"] = BigDecimal("0.0001220703125")
        conversions["Byte (B)"] = BigDecimal("0.0009765625")
        conversions["Kilobyte (KB)"] = BigDecimal("1")
        conversions["Megabyte (MB)"] = BigDecimal("1024")
        conversions["Gigabyte (GB)"] = BigDecimal("1048576")
        conversions["Terabyte (TB)"] = BigDecimal("1073741824")

        val converter = Converter(input1, input2, unit1, unit2, conversions)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}