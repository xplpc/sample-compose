package com.xplpc.runner.android.app

import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import com.xplpc.android.BuildConfig
import com.xplpc.runner.android.custom.Mapping
import com.xplpc.util.Log

class Application : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        Log.d("[Application : onCreate]")

        instance = this

        initializeStrictMode()
        initializeXPLPC()
    }

    private fun initializeXPLPC() {
        Log.d("[Application : initializeXPLPC]")

        // initialize local mappings
        Mapping.initialize()
    }

    private fun initializeStrictMode() {
        Log.d("[Application : initializeStrictMode] Initializing strict mode...")

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )

            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .build()
            )
        }
    }

    override fun onTerminate() {
        Log.d("[Application : onTerminate] App terminated")
        super.onTerminate()
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}
