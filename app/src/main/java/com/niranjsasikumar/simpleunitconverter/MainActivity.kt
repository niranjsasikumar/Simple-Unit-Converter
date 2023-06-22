package com.niranjsasikumar.simpleunitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goTo (view: View) {
        when(view.id) {
            R.id.button_area -> startActivity(Intent(this, Area::class.java))
            R.id.button_storage -> startActivity(Intent(this, DataStorage::class.java))
            R.id.button_length -> startActivity(Intent(this, Length::class.java))
            R.id.button_mass -> startActivity(Intent(this, Mass::class.java))
            R.id.button_speed -> startActivity(Intent(this, Speed::class.java))
            R.id.button_temperature -> startActivity(Intent(this, Temperature::class.java))
            R.id.button_time -> startActivity(Intent(this, Time::class.java))
            R.id.button_volume -> startActivity(Intent(this, Volume::class.java))
        }
    }
}