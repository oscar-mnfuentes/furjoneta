package es.rutas.prensa.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import es.rutas.prensa.R
import es.rutas.prensa.databinding.RouteItemBinding
import es.rutas.prensa.dto.RouteDto


import es.rutas.prensa.fragment.route.RouteFragment.OnListFragmentInteractionListener


class RouteRecyclerViewAdapter(
    private var mValues: ArrayList<RouteDto>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<RouteRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as RouteDto
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: RouteItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_route, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!mValues.isNullOrEmpty()) {
            val item = mValues[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(private val mView: RouteItemBinding) : RecyclerView.ViewHolder(mView.root) {
        fun bind(item: RouteDto) {
            mView.route = item
            mView.root.tag = item
            mView.root.setOnClickListener(mOnClickListener)
        }
    }

    fun updateRoutes(routes: ArrayList<RouteDto>) {
        mValues = routes
        notifyDataSetChanged()
    }
}
