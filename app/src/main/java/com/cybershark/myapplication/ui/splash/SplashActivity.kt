package com.cybershark.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.cybershark.myapplication.R
import com.cybershark.myapplication.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeFromPrefs()
        openActivity()
    }

    private fun openActivity() {
        //start activity needed based on state
        startActivity(Intent(this, MainActivity::class.java))
        setCustomAnims()
    }

    private fun setCustomAnims() = overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    private fun setThemeFromPrefs() {
        //Int for theme. Default 0->Light, 1->Dark
        when (PreferenceManager.getDefaultSharedPreferences(this).getInt("ThemeOption", 0)) {
            0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}