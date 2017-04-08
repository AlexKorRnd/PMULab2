package com.alexkorrnd.pmulab2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick

class FirstActivity: AppCompatActivity() {

    private lateinit var etText: EditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        etText = find(R.id.etText)
        btnSend = find(R.id.btnSend)

        btnSend.onClick {
            startActivity(SecondActivity.getIntent(this, etText.text.toString()))
            finish()
        }
    }
}