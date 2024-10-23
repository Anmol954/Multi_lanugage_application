package com.example.practice

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var ageEditText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nam)
        genderEditText = findViewById(R.id.gen)
        ageEditText = findViewById(R.id.ag)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.en -> {
                setAppLocale("en")
                Toast.makeText(this, getString(R.string.language_changed), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.hi -> {
                setAppLocale("hi")
                Toast.makeText(this, getString(R.string.language_changed), Toast.LENGTH_SHORT).show()
                true
            }
//
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setAppLocale(localeCode: String) {
        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        nameEditText.hint = getString(R.string.name)
        genderEditText.hint = getString(R.string.gender)
        ageEditText.hint = getString(R.string.age)

        recreate()
    }
}
