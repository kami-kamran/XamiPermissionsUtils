package com.xami.permission.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xami.permission.kami.PermissionsUtil

class MainActivity : AppCompatActivity() {
    var permissionsUtil: PermissionsUtil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionsUtil = PermissionsUtil.getInstance(this@MainActivity, this.activityResultRegistry)
        lifecycle.addObserver(permissionsUtil!!)
        requestSMSPermission()
    }

    private fun requestSMSPermission() {
       permissionsUtil?.let { permission ->
                permission.requestPermission(
                   PermissionMsg = "App required Required Permission to continue",
                  permission =   arrayOf(
                        android.Manifest.permission.READ_SMS,
                        android.Manifest.permission.RECEIVE_SMS
                    ),
                    showDialog = false,
                    callBack = object : PermissionsUtil.PermissionsListenerCallback {
                        override fun onPermissionGranted() {
                            /* Perform action on Permission Granted*/
                        }
                        override fun onPermissionCancel() {
                          /* Perform action on Permission Cancel*/
                        }
                    })
            }

    }
}