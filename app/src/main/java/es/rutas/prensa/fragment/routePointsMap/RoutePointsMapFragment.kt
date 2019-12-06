package es.rutas.prensa.fragment.routePointsMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import es.rutas.prensa.R
import kotlinx.android.synthetic.main.fragment_route_points_map.view.*

class RoutePointsMapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_route_points_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.route_points_map.onCreate(savedInstanceState)
        view.route_points_map.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        if(p0 != null) {
            map = p0
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RoutePointsMapFragment()
    }

    override fun onStart() {
        super.onStart()
        view?.route_points_map?.onStart()
    }

    override fun onPause() {
        super.onPause()
        view?.route_points_map?.onPause()
    }

    override fun onResume() {
        super.onResume()
        view?.route_points_map?.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        view?.route_points_map?.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        view?.route_points_map?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        view?.route_points_map?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        view?.route_points_map?.onDestroy()
    }
}