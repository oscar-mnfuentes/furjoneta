package es.rutas.prensa.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteDto(var id: String?, val name: String, var description: String?) : Parcelable