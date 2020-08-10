package br.com.monteoliva.testegithub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.monteoliva.testegithub.R
import br.com.monteoliva.testegithub.view.main.MainActivity

class SplashScreen : AppCompatActivity(R.layout.activity_splash_screen) {
    private val seconds: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        load()
    }

    private fun load() {
        Handler().postDelayed({
            val intent: Intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.lefttoright, R.anim.stable)
        }, seconds)
    }
}