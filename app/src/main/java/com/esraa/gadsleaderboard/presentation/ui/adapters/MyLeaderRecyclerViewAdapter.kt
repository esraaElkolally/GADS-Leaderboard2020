package com.esraa.gadsleaderboard.presentation.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.esraa.gadsleaderboard.data.common.loadImage
import com.esraa.gadsleaderboard.data.entities.LeadersModel
import com.esraa.gadsleaderboard.databinding.ItemSkillLearnerBinding
import com.esraa.gadsleaderboard.data.entities.LearningListTypes

class MyLeaderRecyclerViewAdapter(
    private val types: LearningListTypes
) : RecyclerView.Adapter<MyLeaderRecyclerViewAdapter.ViewHolder>() {
    private var values: List<LeadersModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSkillLearnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, types)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        values?.get(position)?.let {
            holder.onBind(it)
        }

    }

    override fun getItemCount(): Int = values?.size ?: 0
    fun setModelList(modelList: List<LeadersModel>) {
        this.values = modelList
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemSkillLearnerBinding,
        private val type: LearningListTypes
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LeadersModel) {
            binding.model = item
            binding.type = type
            binding.imageView.loadImage(item.badgeUrl)
            binding.executePendingBindings()
        }
    }
}