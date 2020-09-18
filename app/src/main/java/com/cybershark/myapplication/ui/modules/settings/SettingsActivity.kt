package com.cybershark.myapplication.ui.modules.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.multidex.BuildConfig
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.cybershark.myapplication.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setCustomAnims()
    }

    private fun setCustomAnims() = overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

    class SettingsFragment : PreferenceFragmentCompat() {

        private val settingsViewModel by viewModels<SettingsViewModel>()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            setData()
            setupListeners()
        }

        private fun setData() {
            setVersionCode()
            TODO("Not yet implemented")
        }

        private fun setVersionCode() {
            findPreference<Preference>("versionCode")?.summary = BuildConfig.VERSION_CODE.toFloat().toString()
        }

        private fun setupListeners() {
            setupThemeListener()
            TODO("Not yet implemented")
        }

        private fun setupThemeListener() {
            TODO("Not yet implemented")
        }

    }
}