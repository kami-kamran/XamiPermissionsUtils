# XamiPermissionsUtils
A Permission Helper class to Request Permission Launcher with Kotlin in Android. A Utils Helper for the run time permissions for request permission launchers. and get its call back granted or not

1) Add this SDK in your App gradle
### SDK ####
 ### implementation 'com.github.kami-kamran:XamiPermissionsUtils:0.0.1' ###

 #### How to use inside Activity ####

        
        var permissionsUtil: PermissionsUtil? = null
   
 permissionsUtil = PermissionsUtil.getInstance(this@MainActivity, this.activityResultRegistry)
 
        lifecycle.addObserver(permissionsUtil!!)
        
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
    
    ##How to Use inside Fragment
    
      private fun requestPermission() {
            (activity as MainActivity).permissionsUtil?.let { permission ->
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
        
