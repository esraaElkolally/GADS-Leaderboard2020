package com.esraa.gadsleaderboard.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.esraa.gadsleaderboard.data.entities.ResultWrapper
import com.esraa.gadsleaderboard.data.entities.UserDataModel
import com.esraa.gadsleaderboard.data.remote.submitData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response

val submitRepo: SubmitRepo by lazy {
    SubmitRepo()
}

class SubmitRepo {
//    fun submitUserData(userDataModel: UserDataModel, status: MutableLiveData<Boolean>) {
//         submitData(userDataModel).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).doOnComplete {
//                Log.e("jdhdh", "jddh")
//                status.postValue(true)
//            }
//            .doOnError {
//                Log.e("jdhdh", "erorr")
//                status.postValue(false)
//
//            }.onErrorComplete {
//                Log.e("jdhdh", it.message.toString())
//                status.postValue(false)
//                false
////                return it
//
////                retLog.e("jdhdh","erorr")
//
//            }
//
//    }

    fun submitUserData(userDataModel:UserDataModel, resultWrapper: MutableLiveData<ResultWrapper<Any>>) {

        submitData(
            userDataModel
        ).enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful)
                    resultWrapper.postValue(ResultWrapper.Success(null))
                else
                    resultWrapper.postValue(ResultWrapper.GenericError(response.code(), null))
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                resultWrapper.postValue(ResultWrapper.NetworkError)
            }
        })

    }
}