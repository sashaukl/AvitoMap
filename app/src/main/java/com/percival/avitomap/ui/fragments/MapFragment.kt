package com.percival.avitomap.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.percival.avitomap.R
import com.percival.avitomap.ui.viewmodels.SharedViewModel
import java.util.Random


class MapFragment : Fragment(), OnMapReadyCallback {

    lateinit var mMapView: MapView
    private lateinit var mMap: GoogleMap

    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.fragment_map, container, false)
        mMapView = v.findViewById<View>(R.id.mapView) as MapView
        mMapView.onCreate(savedInstanceState)
        mMapView.onResume() // needed to get the map to display immediately
        try {
            MapsInitializer.initialize(activity!!.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mMapView.getMapAsync(this)
        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        var lat : Double? = null
        var lng : Double? = null
        sharedViewModel.activeServices.value?.forEach { service ->
            val color = Random().nextInt(360)
            sharedViewModel.pinMap.value?.get(service)?.forEach { pin ->
                if (lat == null || lng == null){
                    lat = pin.lat
                    lng = pin.lng
                }
                mMap.addMarker( MarkerOptions()
                    .position(LatLng(pin.lat, pin.lng))
                    .title(service)
                    .icon(
                        BitmapDescriptorFactory
                        .defaultMarker(color.toFloat())
                    )
                )
            }
        }
        if (lat != null  && lng != null){
            val cameraPosition = CameraPosition.Builder()
                .target(LatLng(lat!!, lng!!)).zoom(12f).build()
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }

}