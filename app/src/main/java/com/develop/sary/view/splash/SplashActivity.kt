package com.develop.sary.view.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.develop.sary.R
import com.develop.sary.utility.startNewActivity
import com.develop.sary.view.dashboard.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animatedSvgView.start()

        Handler(Looper.getMainLooper()).postDelayed({
            this.startNewActivity(MainActivity::class.java)
        }, 3000)

    }

}