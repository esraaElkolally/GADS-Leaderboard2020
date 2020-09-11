package com.esraa.gadsleaderboard.data.common

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.domain.viewmodels.SubmitViewModel

fun ImageView.loadImage(path: String?) {
    if (!path.isNullOrEmpty()) {
        Glide.with(context)
            .load(path)
            .centerCrop()
            .override(SIZE_ORIGINAL)
            .into(this)
    }
}

fun Context.toast(
    context: Context = applicationContext,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, duration).show()
}

//fun checkVaildMail(model: Any):Boolean{
//    if (!Patterns.EMAIL_ADDRESS.matcher(model!!.email).matches()) {
//        errorMessage.value =
//            getApplication<Application>().resources.getString(R.string.invalid_email)
//
//        return false
//    }
//}
fun Context.copy(text: String?) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip: ClipData =
        ClipData.newPlainText(applicationContext.getString(R.string.app_name), text)
    clipboard.setPrimaryClip(clip)
}

