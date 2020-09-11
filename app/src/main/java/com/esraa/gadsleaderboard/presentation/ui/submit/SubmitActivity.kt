package com.esraa.gadsleaderboard.presentation.ui.submit
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.data.common.showConfirmationAlertDialog
import com.esraa.gadsleaderboard.data.common.showErrorAlertDialog
import com.esraa.gadsleaderboard.data.common.showErrorSnackBar
import com.esraa.gadsleaderboard.data.common.showSuccessAlertDialog
import com.esraa.gadsleaderboard.data.entities.ResultWrapper
import com.esraa.gadsleaderboard.databinding.ActivitySubmitBinding
import com.esraa.gadsleaderboard.domain.viewmodels.SubmitViewModel

class SubmitActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitBinding
    lateinit var submitViewModel: SubmitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit)
        submitViewModel = ViewModelProvider(this).get(SubmitViewModel::class.java)
        binding.viewModel = submitViewModel
        binding.lifecycleOwner = this

        submitViewModel.errorMessage.observe(this, {
            showErrorSnackBar(binding.root, it)
        })

        submitViewModel.status.observe(this, {
            if (it is ResultWrapper.Success) {
                submitViewModel.showSucessDialog.value = true
                showSuccessAlertDialog(this, submitViewModel)
            } else {
                submitViewModel.showFailDialog.value = true
                showErrorAlertDialog(this, submitViewModel)
            }
        })

        binding.backButton.setOnClickListener {
            finish()
        }
    }

    fun showConfirm(view: View) {
        if (submitViewModel.validInput()) {
            submitViewModel.showConfirmaDialog.value = true
            showConfirmationAlertDialog(this, submitViewModel)
        }
    }
}