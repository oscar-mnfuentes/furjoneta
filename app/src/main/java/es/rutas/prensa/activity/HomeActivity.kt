package es.rutas.prensa.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.rutas.prensa.R
import es.rutas.prensa.dto.RouteDto
import es.rutas.prensa.fragment.route.RouteFragment

import kotlinx.android.synthetic.main.activity_routes.*

class HomeActivity : AppCompatActivity(), RouteFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: RouteDto?) {
        if(item != null) {
            loadRoutePoints(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routes)
        setSupportActionBar(route_toolbar)

        loadRouteListFragment()
    }

    private fun loadRouteListFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_fragment_container, RouteFragment.newInstance(), "RouteFragment")
        fragmentTransaction.commit()
    }

    private fun loadRoutePoints(route: RouteDto) {
        val intent = Intent(this, RoutePointsActivity::class.java)
        intent.putExtra("route", route)
        startActivity(intent)
    }
}
