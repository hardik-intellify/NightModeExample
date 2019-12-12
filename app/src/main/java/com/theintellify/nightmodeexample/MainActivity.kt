package com.theintellify.nightmodeexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var nighMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        if (nighMode) {
            setTheme(R.style.DarkTheme)
        }
        setContentView(R.layout.activity_main)

        if (nighMode) {
            switch1.isChecked = true
        }

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            run {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                redraw()
            }
        }
    }

    fun redraw(){
        startActivity(Intent(this@MainActivity, MainActivity::class.java))
        finish()
    }
}
