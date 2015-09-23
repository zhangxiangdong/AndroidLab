package me.zhang.lab.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Environment;

import java.io.File;

/**
 * Created by Zhang on 9/21/2015 9:50 下午.
 */
public class HardwareUtils {

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public static File getOutputFileDir(Context context) {
        if (isExternalStorageWritable()) {
            return context.getExternalCacheDir();
        }
        return context.getFilesDir();
    }

    /**
     * 1. Detecting camera hardware
     *
     * Check is this device has a camera.
     */
    public static boolean checkCameraHardware(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    /**
     * 2. Accessing cameras
     *
     * A safe way to get an instance of the Camera object.
     *
     * Caution:
     *  Always check for exceptions when using Camera.open().
     *  Failing to check for exceptions if the camera is in use or
     *  does not exist will cause your application to be shut down by the system.
     */
    public static Camera getCameraInstance() {
        Camera camera = null;
        try {
            camera = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or dose not exist)
            e.printStackTrace();
        }
        return camera; // returns null if camera is unavailable
    }

    /**
     * 3. Checking camera features
     *
     *  Camera.getParameters()
     *  Camera.getCameraInfo()
     */

}
