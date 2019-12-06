package es.rutas.prensa.fragment.route


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import es.rutas.prensa.R
import es.rutas.prensa.adapter.RouteRecyclerViewAdapter
import es.rutas.prensa.dto.RouteDto
import es.rutas.prensa.service.RouteService
import kotlinx.android.synthetic.main.fragment_route_list.view.*

class RouteFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null

    private val routes = ArrayList<RouteDto>()

    private var editRouteDialog: EditRouteFragment? = null

    private val routeService: RouteService by lazy {
        RouteService(context!!)
    }

    private val adapter: RouteRecyclerViewAdapter by lazy {
        RouteRecyclerViewAdapter(routes, listener)
    }

    override fun onResume() {
        super.onResume()
        createEditDialogInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragment_route_list, container, false)
        view.route_list.adapter = adapter
        view.route_list.layoutManager = LinearLayoutManager(context)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRoutes()
        setAddRouteButtonClickListener()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: RouteDto?)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RouteFragment()
    }

    private fun loadRoutes() {
        this.routeService.getRoutes(Request.Method.GET, { response ->
            routes.clear()
            routes.addAll(response)
            adapter.updateRoutes(routes)
        }, {
            Log.e("ERROR GETTING ROUTES", it.message ?: "")
        })
    }

    private fun createEditDialogInstance() {
        editRouteDialog = EditRouteFragment.newInstance(null)
    }

    private fun setAddRouteButtonClickListener() {
        view?.add_route_button?.setOnClickListener {
            activity?.let {
                editRouteDialog?.show(it.supportFragmentManager, "EditRouteDialog")
            }
        }
    }
}
