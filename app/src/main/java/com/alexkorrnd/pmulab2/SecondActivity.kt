package com.alexkorrnd.pmulab2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick

class SecondActivity: AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, message: String) =
                Intent(context, SecondActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }

        private const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

    private lateinit var tvMessage: TextView
    private lateinit var btnSharing: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvMessage = find(R.id.tvMessage)
        btnSharing = find(R.id.btnSharing)

        tvMessage.text = intent.getStringExtra(EXTRA_MESSAGE)
        btnSharing.onClick {
            sharing(tvMessage.text)
        }
    }

    private fun sharing(text: CharSequence) {
        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(sharingIntent, resources.getString(R.string.sharing_dialog)))
    }
}
