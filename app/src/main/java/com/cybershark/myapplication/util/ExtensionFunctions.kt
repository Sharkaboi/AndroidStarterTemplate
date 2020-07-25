package com.cybershark.myapplication.util

import android.util.Patterns

internal fun String.isValidPassword(): Boolean = (this.length >= 8 && !this.isBlank())
internal fun String.isEmailValid(): Boolean = (Patterns.EMAIL_ADDRESS.matcher(this).matches() && !this.isBlank())