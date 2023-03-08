package com.xami.permission.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.xami.permission.kami.PermissionsUtil

class MainActivity : AppCompatActivity() {
    var permissionsUtil: PermissionsUtil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionsUtil = PermissionsUtil.getInstance(this@MainActivity, this.activityResultRegistry)
        lifecycle.addObserver(permissionsUtil!!)
        val btnPermission:Button=findViewById(R.id.btnPermission)
        btnPermission.setOnClickListener {
            requestSMSPermission()
        }

    }

    private fun requestSMSPermission() {
       permissionsUtil?.let { permission ->
                permission.requestPermission(
                   PermissionMsg = "App Required Permission to continue",
                  permission =   arrayOf(
                        android.Manifest.permission.READ_SMS,
                        android.Manifest.permission.RECEIVE_SMS
                    ),
                    showDialog = true,
                    callBack = object : PermissionsUtil.PermissionsListenerCallback {
                        override fun onPermissionGranted() {
                            Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
                            /* Perform action on Permission Granted*/
                        }
                        override fun onPermissionCancel() {
                            Toast.makeText(this@MainActivity, "Permission Cancel", Toast.LENGTH_SHORT).show()
                          /* Perform action on Permission Cancel*/
                        }
                    })
            }

    }
}