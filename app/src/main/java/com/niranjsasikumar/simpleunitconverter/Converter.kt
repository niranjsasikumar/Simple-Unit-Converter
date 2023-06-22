package com.niranjsasikumar.simpleunitconverter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.text.DecimalFormat

class Converter(val input1: EditText, val input2: EditText, private val unit1: Spinner, private val unit2: Spinner, private val conversions: HashMap<String, BigDecimal>) {
    private val inputWatcher1 : InputWatcher = InputWatcher(input2)
    private val inputWatcher2 : InputWatcher = InputWatcher(input1)

    private inner class InputWatcher(val output: EditText) : TextWatcher {
        lateinit var outputWatcher: InputWatcher
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            output.removeTextChangedListener(outputWatcher)
            if(s.toString() == "")
                output.setText("")
            else {
                try {
                    if(input1.id == R.id.input1_temperature)
                        convertTemperature(s.toString().toBigDecimal(), output)
                    else
                        convert(s.toString().toBigDecimal(), output)
                } catch (ex: Exception) {
                    output.setText("")
                }
            }
            output.addTextChangedListener(outputWatcher)
        }
    }

    private val unitListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {}
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            input2.removeTextChangedListener(inputWatcher2)
            if(input1.text.toString() == "")
                input2.setText("")
            else {
                try {
                    if(input1.id == R.id.input1_temperature)
                        convertTemperature(input1.text.toString().toBigDecimal(), input2)
                    else
                        convert(input1.text.toString().toBigDecimal(), input2)
                } catch (ex: Exception) {
                    input2.setText("")
                }
            }
            input2.addTextChangedListener(inputWatcher2)
        }
    }

    fun convert(num: BigDecimal, output: EditText) {
        val mc = MathContext(100, RoundingMode.HALF_UP)
        val df = DecimalFormat()
        df.maximumFractionDigits = 20
        df.minimumFractionDigits = 0
        df.groupingSize = 0
        if(output == input1)
            output.setText(df.format(num.multiply(conversions[unit2.selectedItem.toString()]!!).divide(conversions[unit1.selectedItem.toString()]!!, mc)))
        else
            output.setText(df.format(num.multiply(conversions[unit1.selectedItem.toString()]!!).divide(conversions[unit2.selectedItem.toString()]!!, mc)))
    }

    fun convertTemperature(num: BigDecimal, output: EditText) {
        val mc = MathContext(100, RoundingMode.HALF_UP)
        val df = DecimalFormat()
        df.maximumFractionDigits = 20
        df.minimumFractionDigits = 0
        df.groupingSize = 0

        val fromUnit : Spinner
        val toUnit : Spinner

        if(output == input1) {
            fromUnit = unit2
            toUnit = unit1
        }
        else {
            fromUnit = unit1
            toUnit = unit2
        }

        val result : BigDecimal = if(fromUnit.selectedItem.toString() == "Celsius (°C)" && toUnit.selectedItem.toString() == "Fahrenheit (°F)")
            num.multiply(BigDecimal("9")).divide(BigDecimal("5")).add(BigDecimal("32"), mc)
        else if(fromUnit.selectedItem.toString() == "Celsius (°C)" && toUnit.selectedItem.toString() == "Kelvin (K)")
            num.add(BigDecimal("273.15"), mc)
        else if(fromUnit.selectedItem.toString() == "Fahrenheit (°F)" && toUnit.selectedItem.toString() == "Celsius (°C)")
            num.subtract(BigDecimal("32")).multiply(BigDecimal("5")).divide(BigDecimal("9"), mc)
        else if(fromUnit.selectedItem.toString() == "Fahrenheit (°F)" && toUnit.selectedItem.toString() == "Kelvin (K)")
            num.subtract(BigDecimal("32")).multiply(BigDecimal("5")).divide(BigDecimal("9"), mc).add(BigDecimal("273.15"), mc)
        else if(fromUnit.selectedItem.toString() == "Kelvin (K)" && toUnit.selectedItem.toString() == "Celsius (°C)")
            num.subtract(BigDecimal("273.15"), mc)
        else if(fromUnit.selectedItem.toString() == "Kelvin (K)" && toUnit.selectedItem.toString() == "Fahrenheit (°F)")
            num.subtract(BigDecimal("273.15")).multiply(BigDecimal("9")).divide(BigDecimal("5")).add(BigDecimal("32"), mc)
        else
            num

        output.setText(df.format(result))
    }

    init {
        inputWatcher1.outputWatcher = inputWatcher2
        inputWatcher2.outputWatcher = inputWatcher1

        input1.addTextChangedListener(inputWatcher1)
        input2.addTextChangedListener(inputWatcher2)

        unit1.onItemSelectedListener = unitListener
        unit2.onItemSelectedListener = unitListener
    }
}