package com.example.a20191228_01_apipractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    var mContext = this

    abstract fun setupEvents()
    abstract fun setValues()
}