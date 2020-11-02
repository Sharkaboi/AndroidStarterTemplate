package com.cybershark.myapplication.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.cybershark.myapplication.R
import com.cybershark.myapplication.ui.main.MainActivity
import com.cybershark.myapplication.util.moveToAndFinishAffinity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeFromPrefs()
        openActivity()
    }

    private fun openActivity() {
        //start activity needed based on state
        moveToAndFinishAffinity<MainActivity>()
        setCustomAnims()
    }

    private fun setCustomAnims() = overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    private fun setThemeFromPrefs() {
        //Int for theme. Default 0->Light, 1->Dark
        when (sharedPrefs.getInt("ThemeOption", 0)) {
            0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}