package com.cybershark.myapplication.util

import android.content.Context
import android.util.Patterns
import android.widget.Toast

internal fun String.isValidPassword(): Boolean = (this.length >= 8 && !this.isBlank())
internal fun String.isEmailValid(): Boolean = (Patterns.EMAIL_ADDRESS.matcher(this).matches() && !this.isBlank())

internal fun Context.shortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
internal fun Context.longToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()