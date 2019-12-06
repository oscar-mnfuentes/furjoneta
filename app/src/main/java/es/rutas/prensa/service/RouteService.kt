package es.rutas.prensa.service

import android.content.Context
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import es.rutas.prensa.config.Constants
import es.rutas.prensa.dto.RouteDto
import org.json.JSONArray

class RouteService constructor(context: Context?) {
    private val volleyService: VolleyService = VolleyService.getInstance(context)
    private val gson = Gson()

    fun getRoutes(method: Int, response: (routes: ArrayList<RouteDto>) -> Unit, reject: (error: VolleyError) -> Unit) {
        val url = "${Constants.API_URL}/${Constants.ROUTE_FUNCTION}/route"
        val request = JsonArrayRequest(method, url, null,
            Response.Listener { jsonResult: JSONArray ->
                val result = gson.fromJson<ArrayList<RouteDto>>(jsonResult.toString(), object: TypeToken<ArrayList<RouteDto>>(){}.type)
                response(result)
            },
            Response.ErrorListener { error ->
                reject(error)
            })
        volleyService.addToRequestQueue(request)
    }
}