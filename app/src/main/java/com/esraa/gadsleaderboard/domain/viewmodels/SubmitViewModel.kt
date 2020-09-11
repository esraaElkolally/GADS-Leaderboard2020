package com.esraa.gadsleaderboard.domain.viewmodels

import android.app.Application
import android.util.Patterns
import android.webkit.URLUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.data.entities.ResultWrapper
import com.esraa.gadsleaderboard.data.entities.UserDataModel
import com.esraa.gadsleaderboard.data.repositories.submitRepo

class SubmitViewModel(application: Application) : AndroidViewModel(application) {

    var errorMessage: MutableLiveData<String> = MutableLiveData()
    var userDataModel: MutableLiveData<UserDataModel> = MutableLiveData(UserDataModel())
    var showConfirmaDialog: MutableLiveData<Boolean> = MutableLiveData()
    var showSucessDialog: MutableLiveData<Boolean> = MutableLiveData()
    var showFailDialog: MutableLiveData<Boolean> = MutableLiveData()
    var status: MutableLiveData<ResultWrapper<Any>> = MutableLiveData()
    fun submit() {
        userDataModel.value?.let {
            submitRepo.submitUserData(it,status)
        }
    }

    fun validInput(): Boolean {
        val submitModel = userDataModel.value

        return isAllEmpty(submitModel) && checkValidMail(submitModel!!.email) && checkProLink(
            submitModel.projectLink
        )


    }

    private fun isAllEmpty(submitModel: UserDataModel?): Boolean {
        if (submitModel != null && submitModel.firstName.isNotBlank() &&
            submitModel.lastName.isNotBlank() &&
            submitModel.email.isNotBlank() &&
            submitModel.projectLink.isNotBlank()
        ) {
            return true
        } else {
            errorMessage.value =
                getApplication<Application>().resources.getString(R.string.all_fields_required)
            return false

        }
    }

    private fun checkValidMail(mail: String): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            errorMessage.value =
                getApplication<Application>().resources.getString(R.string.invalid_email)

            return false
        }
        return true
    }

    private fun checkProLink(link: String?): Boolean {
        if (!URLUtil.isValidUrl(link)) {
            errorMessage.value =
                getApplication<Application>().resources.getString(R.string.invalid_link)

            return false
        }
        return true
    }
}