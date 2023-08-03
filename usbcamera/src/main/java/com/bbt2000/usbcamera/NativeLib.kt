package com.bbt2000.usbcamera

class NativeLib {

    /**
     * A native method that is implemented by the 'usbcamera' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'usbcamera' library on application startup.
        init {
            System.loadLibrary("usbcamera")
        }
    }
}