package com.example.a08_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.a08_ex1.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val cesae = LatLng(41.158436, -8.650169)
        val casaMusica = LatLng(41.155166046, -8.625164166)
        val estadio = LatLng(41.161758, -8.583933)
        val bolhao = LatLng(41.1497, -8.6059)

        mMap.addMarker(MarkerOptions().position(cesae).title("CESAE Digital"))
        mMap.addMarker(MarkerOptions().position(casaMusica).title("Casa da Música"))
        mMap.addMarker(MarkerOptions().position(estadio).title("Estádio do Dragão"))
        mMap.addMarker(MarkerOptions().position(bolhao).title("Mercado do Bolhão"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cesae))

        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
    }
}