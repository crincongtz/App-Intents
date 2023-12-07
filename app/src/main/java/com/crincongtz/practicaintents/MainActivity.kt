package com.crincongtz.practicaintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendText(view: View) {
        val text = "Este es un texto a enviar"

        val sendTextIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        if (sendTextIntent.resolveActivity(packageManager) != null) {
            startActivity(sendTextIntent)
        }
    }

    fun sendEmail(view: View) {
        Log.d("CursoKoltin", "sendEmail()")
        val adresses = arrayOf("arincon@dwtraining.mx")
        val subject = "I am the Subject"

        val sendEmailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, adresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }

        if (sendEmailIntent.resolveActivity(packageManager) != null) {
            Log.w("CursoKoltin", "sendEmail()")
            startActivity(sendEmailIntent)
        }
    }

    fun sendWhatsApp(view: View) {
        Log.d("CursoKoltin", "sendWhatsApp()")
        val message = "mensaje de Whatsapp"

        val sendWhatsAppIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
            setPackage("com.whatsapp")
        }

        if (sendWhatsAppIntent.resolveActivity(packageManager) != null) {
            startActivity(sendWhatsAppIntent)
        }
    }

    fun openMaps(view: View) {
        val uriString = "geo:37.7749,-122.4194"

        val mapIntentUri = Uri.parse(uriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }

    fun openWebPage(view: View) {
        val url = "https://www.google.com.mx/"
        val webPage = Uri.parse(url)
        val webPageIntent = Intent(Intent.ACTION_VIEW, webPage)
        if (webPageIntent.resolveActivity(packageManager) != null) {
            startActivity(webPageIntent)
        }
    }
}