package com.cybershark.myapplication.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar

internal fun String.isValidPassword(): Boolean = (this.length >= 8 && !this.isBlank())
internal fun String.isEmailValid(): Boolean = (Patterns.EMAIL_ADDRESS.matcher(this).matches() && !this.isBlank())


internal fun AppCompatActivity.shortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
internal fun Fragment.shortToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
internal fun Context.shortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
internal fun AppCompatActivity.longToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
internal fun Fragment.longToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()
internal fun Context.longToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

internal fun View.shortSnackBar(message: String, action: (Snackbar.() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    action?.let { snackbar.it() }
    snackbar.show()
}

internal fun View.longSnackBar(message: String, action: (Snackbar.() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let { snackbar.it() }
    snackbar.show()
}

internal fun View.indefiniteSnackBar(message: String, action: (Snackbar.() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
    action?.let { snackbar.it() }
    snackbar.show()
}

internal fun Snackbar.action(message: String, action: (View) -> Unit) {
    this.setAction(message, action)
}

internal inline fun <reified T : Activity> Activity.moveToAndFinish(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.apply(block)
    startActivity(intent)
    finish()
}

internal inline fun <reified T : Activity> Activity.moveToAndFinishAffinity(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.apply(block)
    startActivity(intent)
    finishAffinity()
}

internal fun View.makeVisible() {
    this.isVisible = true
}

internal fun View.makeGone() {
    this.isGone = true
}

internal fun <T> AppCompatActivity.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) { t ->
        action(t)
    }
}

internal fun <T> Fragment.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { t ->
        action(t)
    }
}

internal fun MutableLiveData<UIState>.setLoading(): MutableLiveData<UIState> {
    this.value = UIState.LOADING
    return this
}

internal fun MutableLiveData<UIState>.setSuccess(message: String): MutableLiveData<UIState> {
    this.value = UIState.COMPLETED(message)
    return this
}

internal fun MutableLiveData<UIState>.setError(message: String): MutableLiveData<UIState> {
    this.value = UIState.ERROR(message)
    return this
}

internal fun MutableLiveData<UIState>.getDefault(): MutableLiveData<UIState> {
    this.value = UIState.IDLE
    return this
}

internal fun emptyString(): String = ""