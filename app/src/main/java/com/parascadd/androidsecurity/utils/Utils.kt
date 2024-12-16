package com.parascadd.androidsecurity.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Debug
import android.widget.TextView

class Utils {
    fun isInstalledFromPlayStore(context: Context): Boolean {
        return try {
            val packageManager: PackageManager = context.packageManager
            val installerPackageName = packageManager.getInstallerPackageName(context.packageName)
            installerPackageName == "com.android.vending"
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    public fun isDeviceRooted(): Boolean {
        return  checkRootMethod()
    }
    public fun checkRootMethod(): Boolean {
        return Build.TAGS?.contains("test-keys") == true
    }
    public val isThreadCPUTimeExceeds: Boolean
        get() {

            val start = Debug.threadCpuTimeNanos()
            for (i in 0..999999) continue
            val stop = Debug.threadCpuTimeNanos()
            return stop - start >= 1_000_000 // 1 millisecond in nanoseconds
        }

    fun checkCpuTime(h3: TextView) {
        if (isThreadCPUTimeExceeds) {

            h3.text = "Thread CPU time exceeds 1 millisecond."

        } else {
            h3.text ="Thread CPU time is within the limit."
        }
    }
}