package com.esraa.gadsleaderboard.data.common

import android.app.Activity
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.domain.viewmodels.SubmitViewModel
import com.google.android.material.snackbar.Snackbar

fun showConfirmationAlertDialog(context: Activity, viewModel: SubmitViewModel) {

    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
    val dialogView: View = context.layoutInflater.inflate(R.layout.layout_confirm_dialog, null)
    dialogBuilder.setView(dialogView)

    val closeButton: ImageButton = dialogView.findViewById(R.id.closeButton) as ImageButton

    val yesButton: Button = dialogView.findViewById(R.id.yesButton) as Button

    val alertDialog: AlertDialog = dialogBuilder.create()
    alertDialog.setCanceledOnTouchOutside(false)
    alertDialog.show()
    closeButton.setOnClickListener {
        viewModel.showConfirmaDialog.value = false
        alertDialog.dismiss()
    }

    yesButton.setOnClickListener {
        viewModel.submit()
        viewModel.showConfirmaDialog.value = false
        alertDialog.dismiss()
    }
}
 fun showErrorSnackBar(view: View, msg: String) {
    Snackbar.make(
        view,
        msg,
        Snackbar.LENGTH_LONG
    ).setBackgroundTint(Color.RED).show()
}
 fun showErrorAlertDialog(context: Activity, viewModel: SubmitViewModel) {
    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
    val dialogView: View = context.layoutInflater.inflate(R.layout.layout_error_dialog, null)
    dialogBuilder.setView(dialogView)
    val alertDialog = dialogBuilder.create()
    alertDialog.setCanceledOnTouchOutside(false)
    alertDialog.show()

    Handler(Looper.getMainLooper()).postDelayed({
        viewModel.showFailDialog.value = false
        alertDialog.dismiss()
    }, 3000)
}
 fun showSuccessAlertDialog(context: Activity, viewModel: SubmitViewModel) {
    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
    val dialogView: View = context.layoutInflater.inflate(R.layout.layout_success_dialog, null)
    dialogBuilder.setView(dialogView)
    val alertDialog = dialogBuilder.create()
    alertDialog.setCanceledOnTouchOutside(false)
    alertDialog.show()
    Handler(Looper.getMainLooper()).postDelayed({
        viewModel.showSucessDialog.value = false
        alertDialog.dismiss()
        context.finish()
    }, 3000)
}
