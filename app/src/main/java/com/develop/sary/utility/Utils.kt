package com.develop.sary.utility

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.develop.sary.R
import com.develop.sary.app.App
import com.develop.sary.network.Resource
import com.develop.sary.view.dashboard.fragments.home.HomeFragment
import com.google.android.material.snackbar.Snackbar

fun <A : Activity> Activity.startNewActivity(activity: Class<A>) {
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
        overridePendingTransition(R.anim.fadein,R.anim.fade_out);
    }
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}

fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackbar.setBackgroundTint(
        ContextCompat.getColor(
            App.applicationContext(),
            R.color.light_gray
        )
    );

    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}

fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError -> requireView().snackbar(
            "من فضلك تأكد من الإتصال بالانترنت",
            retry
        )
        failure.errorCode == 401 -> {
            if (this is HomeFragment) {
                requireView().snackbar("Unauthorized")
            } else {
                // (this as BaseFragment<*, *, *>).logout()
            }
        }
        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackbar(error)
        }
    }
}

