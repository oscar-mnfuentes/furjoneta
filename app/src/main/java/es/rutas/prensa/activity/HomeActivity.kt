package es.rutas.prensa.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import es.rutas.prensa.R
import es.rutas.prensa.dto.RouteDto
import es.rutas.prensa.fragment.RouteFragment

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RouteFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: RouteDto?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        loadRouteFragment()
    }

    private fun loadRouteFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(home_fragment_container.id, RouteFragment.newInstance(1), "RouteFragment")
        fragmentTransaction.commit()
    }

}
