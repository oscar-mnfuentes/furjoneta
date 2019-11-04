package es.rutas.prensa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.squareup.picasso.Picasso
import es.rutas.prensa.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadSplashLogo()

        navigateToHome()
    }

    private fun loadSplashLogo() {
        Picasso.get().load("file:///android_asset/logo_furgo.png").into(splashLogo)

    }

    private fun navigateToHome() {
        val homeIntent = Intent(this, HomeActivity::class.java)

        Handler().postDelayed({
            startActivity(homeIntent)
        }, 2000)
    }
}
 