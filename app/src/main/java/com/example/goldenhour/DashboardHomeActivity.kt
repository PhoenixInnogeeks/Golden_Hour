package com.example.goldenhour

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationRequest
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.goldenhour.databinding.ActivityDashboardHomeBinding
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class DashboardHomeActivity : AppCompatActivity() ,OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    LocationListener,GoogleMap.OnMapLongClickListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDashboardHomeBinding

    private val mMap: GoogleMap? = null
    private val client: GoogleApiClient? = null
    private val locationRequest: LocationRequest? = null
    private val lastLocation: Location? = null
    private val currentLocationMarker: Marker? = null
    val REQUEST_LOCATION_CODE = 99


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDashboardHome.toolbar)

        binding.appBarDashboardHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            com.example.goldenhour.DashboardHomeActivity.REQUEST_LOCATION_CODE -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {

                    // permission was granted, yay!
                    if (ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        if (client == null) {
                            buildGoogleApiClient()
                        }
                        mMap!!.isMyLocationEnabled = true
                    }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dashboard_home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }

    override fun onConnected(p0: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }

    override fun onMapLongClick(p0: LatLng) {
        TODO("Not yet implemented")
    }
}