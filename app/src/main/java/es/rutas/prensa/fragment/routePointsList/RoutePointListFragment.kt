package es.rutas.prensa.fragment.routePointsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import es.rutas.prensa.R
import es.rutas.prensa.fragment.routePointsMap.RoutePointsMapFragment

class RoutePointListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_route_points_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RoutePointListFragment()
    }
}