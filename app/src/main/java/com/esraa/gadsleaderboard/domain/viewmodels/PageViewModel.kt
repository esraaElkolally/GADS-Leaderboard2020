package com.esraa.gadsleaderboard.domain.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.esraa.gadsleaderboard.data.entities.LeadersModel
import com.esraa.gadsleaderboard.data.repositories.leaderRepo

class PageViewModel : ViewModel() {
    private lateinit var learningList: LiveData<List<LeadersModel>>
    private lateinit var skillIqList: LiveData<List<LeadersModel>>


    fun getlearningList(): LiveData<List<LeadersModel>> {
        learningList = leaderRepo.getLearnerListFromRemote()
        return learningList
    }

    fun getskillList(): LiveData<List<LeadersModel>> {
        skillIqList = leaderRepo.getSkillIqListFromRemote()
        return skillIqList
    }
}