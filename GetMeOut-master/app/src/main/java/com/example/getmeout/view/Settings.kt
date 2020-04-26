package com.example.getmeout.view


import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.getmeout.R
import com.example.getmeout.view.SettingsDirections
import com.example.getmeout.databinding.FragmentSettingsBinding
import com.google.android.gms.location.*

/**
 * A simple [Fragment] subclass.
 */
class Settings : Fragment() {

    //    SAUL
    val PERMISSION_ID = 42
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    var locationString: String = ""
        get() = field
        set( value ){
            field = value
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSettingsBinding>(inflater,
            R.layout.fragment_settings,container,false)
        // Inflate the layout for this fragment


        // Button to navigate to the Edit Contacts page
        binding.selectContactsBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(SettingsDirections.actionSettingsToEditContacts())
        }

        // Button to navigate to the Edit Contacts button
        binding.editMessagesBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(SettingsDirections.actionSettingsToEditMessages())
        }

        //        Button is currently not active because location is being handled elsewhere
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this.activity!!)
//        binding.locationBtn.setOnClickListener{ getLastLocation() }

        return binding.root
    }

    // COMMENTED OUT AT THE MOMENT BECAUSE LOCATION IS BEING HANDLED AT Title.kt
//    @SuppressLint("MissingPermission")
//    private fun getLastLocation() {
//
//        if (checkPermissions()) {
//            if (isLocationEnabled()) {
//                requestNewLocationData()
//            } else {
//                Toast.makeText(this.context!!, "Turn on location", Toast.LENGTH_LONG).show()
//                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
//                startActivity(intent)
//            }
//        } else {
//            requestPermissions()
//        }
//
//    }

//    SAUL
//    @SuppressLint("MissingPermission")
//    private fun requestNewLocationData() {
//        var mLocationRequest = LocationRequest()
//        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        mLocationRequest.interval = 0
//        mLocationRequest.fastestInterval = 0
//        mLocationRequest.numUpdates = 1
//
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this.activity!!)
//        mFusedLocationClient.requestLocationUpdates(
//                mLocationRequest, mLocationCallback,
//                Looper.myLooper()
//        )
//    }

//    private val mLocationCallback = object : LocationCallback() {
//        var lastLocationString = ""
//
//        override fun onLocationResult(locationResult: LocationResult) {
//            var mLastLocation: Location = locationResult.lastLocation
//
////            locationString += "Latitude : " + mLastLocation.latitude.toString()
////            locationString += " Longitude: " + mLastLocation.longitude.toString()
////            println("onLocationResult: " + locationString)
//            lastLocationString += "Latitude : " + mLastLocation.latitude.toString()
//            lastLocationString += " Longitude: " + mLastLocation.longitude.toString()
//
//            this@Settings.locationString = lastLocationString
////           var titlePage = Title()
//////            titlePage.locationString = lastLocation
//            println( "onLocationResult: " + locationString)
//
//            val clipboard = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
//            val clip = ClipData.newPlainText("Location", locationString)
//            clipboard.setPrimaryClip(clip)
//
//        }
//    }
    //Check if location is enabled in the device
//    private fun isLocationEnabled(): Boolean {
//        var locationManager: LocationManager =
//                activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
//                LocationManager.NETWORK_PROVIDER
//        )
//    }
    //Check for location permissions have been allowed for the app
//    private fun checkPermissions(): Boolean {
//        if (ActivityCompat.checkSelfPermission(
//                        this.context!!,
//                        android.Manifest.permission.ACCESS_COARSE_LOCATION
//                ) == PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(
//                        this.context!!,
//                        android.Manifest.permission.ACCESS_FINE_LOCATION
//                ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            return true
//        }
//        return false
//    }
//    Request Location permissions
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(
//                this.activity!!,
//                arrayOf(
//                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
//                        android.Manifest.permission.ACCESS_FINE_LOCATION
//                ),
//                PERMISSION_ID
//        )
//    }

//    override fun onRequestPermissionsResult(
//            requestCode: Int,
//            permissions: Array<String>,
//            grantResults: IntArray
//    ) {
//        if (requestCode == PERMISSION_ID) {
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                getLastLocation()
//            }
//        }
//    }

}
