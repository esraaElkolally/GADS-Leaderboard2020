package com.esraa.gadsleaderboard.data.remote
import com.esraa.gadsleaderboard.data.entities.LeadersModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

  interface ConnectionAPIs {
    @GET(ConnectionConstants.LEARNER_LIST)
    fun getLearnLeadersList(): Flowable<List<LeadersModel>>

    @GET(ConnectionConstants.SKill_LIST)
    fun getSkillIQLeaderList(): Flowable<List<LeadersModel>>
}

fun getLearningLeadersList(): Flowable<List<LeadersModel>>{
    return leaderShipApiInstance().getLearnLeadersList()
}

fun getSkillIQLeaderList(): Flowable<List<LeadersModel>> {
    return leaderShipApiInstance().getSkillIQLeaderList()
}