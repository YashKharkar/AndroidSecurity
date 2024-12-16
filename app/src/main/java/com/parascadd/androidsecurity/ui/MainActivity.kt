package com.parascadd.androidsecurity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.widget.TextView
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import com.parascadd.androidsecurity.R
import com.parascadd.androidsecurity.common.BiometricAuthListener
import com.parascadd.androidsecurity.common.BiometricUtils

class MainActivity : AppCompatActivity(), BiometricAuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BiometricUtils.isBiometricReady(this)) {
            BiometricUtils.showBiometricPrompt(
                activity = this,
                listener = this,
                cryptoObject = null,
            )
        } else {
            Toast.makeText(this, "No biometric feature perform on this device", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onBiometricAuthenticateError(error: Int, errMsg: String) {
        when (error) {
            BiometricPrompt.ERROR_USER_CANCELED -> finish()
            BiometricPrompt.ERROR_NEGATIVE_BUTTON -> {
//                startActivity(Intent(this,LoginActivity::class.java))
//                finish()
            }
        }
    }

    override fun onBiometricAuthenticateSuccess(result: BiometricPrompt.AuthenticationResult) {
        navigateToActivity()
    }

    private fun navigateToActivity() {
//        startActivity(Intent(this, AuthActivity::class.java))
//        finish()
    }
}

class  CpuTimeValidator{


}

