package es.rutas.prensa.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import es.rutas.prensa.R
import es.rutas.prensa.fragment.RouteFragment

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        homeAddRoute.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        loadRouteFragment()
    }

    private fun loadRouteFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(RouteFragment.newInstance(1), "RouteFragment")
        fragmentTransaction.commit()
    }

}
