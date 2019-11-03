package es.rutas.prensa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadSplashLogo()
    }

    private fun loadSplashLogo() {
        Picasso.get().load("assets/logo_furgo.png").into(splashLogo)
    }
}
 