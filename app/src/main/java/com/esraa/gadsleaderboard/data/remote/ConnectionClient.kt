package com.esraa.gadsleaderboard.data.remote
import com.esraa.gadsleaderboard.data.remote.ConnectionConstants.BASE_URL
import com.esraa.gadsleaderboard.data.remote.ConnectionConstants.GOOGLE_SHEET_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


fun leaderShipApiInstance(): ConnectionAPIs {
    return retrofitInstance.create(ConnectionAPIs::class.java)
}
fun submitApiInstance(): SubmitApis {
    return googleSheetRetrofit.create(SubmitApis::class.java)
}
private val googleSheetRetrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(GOOGLE_SHEET_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}
private val retrofitInstance: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}
private val interceptor = HttpLoggingInterceptor()
private val client by lazy {
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()
}
