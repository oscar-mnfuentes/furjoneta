package es.rutas.prensa.activity

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import es.rutas.prensa.R
import es.rutas.prensa.dto.RouteDto
import es.rutas.prensa.fragment.RouteFragment

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RouteFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: RouteDto?) {
        if(item != null) {
            loadRouteFragment(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        loadRouteListFragment()
    }

    private fun loadRouteListFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(home_fragment_container.id, RouteFragment.newInstance(1), "RouteFragment")
        fragmentTransaction.commit()
    }

    private fun loadRouteFragment(route: RouteDto) {
        Log.d("ROUTE: ", route.toString())
    }
}
