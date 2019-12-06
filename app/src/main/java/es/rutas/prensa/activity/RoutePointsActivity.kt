package es.rutas.prensa.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import es.rutas.prensa.R
import es.rutas.prensa.fragment.routePointsList.RoutePointListFragment
import es.rutas.prensa.fragment.routePointsMap.RoutePointsMapFragment
import kotlinx.android.synthetic.main.activity_route_points.*

class RoutePointsActivity : AppCompatActivity() {

    private val controller: NavController by lazy {
        route_points_nav_host_fragment.findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_points)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setupWithNavController(controller)
        route_points_toolbar.title = resources.getString(R.string.route_points_list_option_title)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(route_points_nav_host_fragment.id, RoutePointListFragment.newInstance())
        transaction.commit()
    }

    private val listener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        var navigated = true
        route_points_toolbar.title = menuItem.title
        val fragment = when (menuItem.itemId) {
            R.id.route_points_list_option ->
            RoutePointListFragment.newInstance()

            R.id.route_points_map_options ->
            RoutePointsMapFragment.newInstance()

            else -> null
        }

        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(route_points_nav_host_fragment.id, fragment)
            transaction.commit()
        }else {
            navigated = false
        }
        navigated
    }

    override fun onResume() {
        super.onResume()
        nav_view.setOnNavigationItemSelectedListener(listener)
    }
}
