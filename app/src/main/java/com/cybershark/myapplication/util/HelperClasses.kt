package com.cybershark.myapplication.util

sealed class Status {
    object IDLE : Status()
    object LOADING : Status()
    object COMPLETED : Status()
    object ERROR : Status()
}