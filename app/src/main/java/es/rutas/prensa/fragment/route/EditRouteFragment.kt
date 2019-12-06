package es.rutas.prensa.fragment.route

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import es.rutas.prensa.R
import es.rutas.prensa.databinding.FragmentEditRoute
import es.rutas.prensa.dto.RouteDto

class EditRouteFragment : DialogFragment() {
    private var route: RouteDto? = RouteDto(null, "", "")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreate(savedInstanceState)
        arguments?.let {
            route = it.getParcelable(ROUTE)
        }
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layoutBinding = DataBindingUtil.inflate<FragmentEditRoute>(inflater, R.layout.fragment_edit_route, null, false)
            layoutBinding.route = route
            builder.setView(layoutBinding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    // TODO implementar interfaz para interacciones del usuario

    companion object {
        const val ROUTE = "route"
        @JvmStatic
        fun newInstance(route: RouteDto?) =
            EditRouteFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ROUTE, route)
                }
            }
    }
}
