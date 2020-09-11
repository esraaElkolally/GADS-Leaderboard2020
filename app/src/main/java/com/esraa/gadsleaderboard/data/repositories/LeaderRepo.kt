package com.esraa.gadsleaderboard.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.esraa.gadsleaderboard.data.entities.LeadersModel
import com.esraa.gadsleaderboard.data.remote.getLearningLeadersList
import com.esraa.gadsleaderboard.data.remote.getSkillIQLeaderList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

val leaderRepo: LeaderRepo by lazy {
    LeaderRepo()
}
class LeaderRepo {
    fun getLearnerListFromRemote(): LiveData<List<LeadersModel>> {
        val response = getLearningLeadersList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).onErrorComplete()
        return LiveDataReactiveStreams.fromPublisher(response)
    }

    fun getSkillIqListFromRemote(): LiveData<List<LeadersModel>> {
        val response = getSkillIQLeaderList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).onErrorComplete()
        return LiveDataReactiveStreams.fromPublisher(response)
    }
}