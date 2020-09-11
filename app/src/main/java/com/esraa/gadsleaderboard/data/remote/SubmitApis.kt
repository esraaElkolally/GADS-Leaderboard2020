package com.esraa.gadsleaderboard.data.remote

import com.esraa.gadsleaderboard.data.entities.UserDataModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SubmitApis {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submit(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String,
    ): Call<Void>

}

fun submitData(
    model: UserDataModel
):Call <Void> {
    return submitApiInstance().submit(model.email, model.firstName, model.lastName,model.projectLink)
}