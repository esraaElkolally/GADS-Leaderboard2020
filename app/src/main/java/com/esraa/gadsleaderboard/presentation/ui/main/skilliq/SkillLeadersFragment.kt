package com.esraa.gadsleaderboard.presentation.ui.main.skilliq

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.domain.viewmodels.PageViewModel
import com.esraa.gadsleaderboard.presentation.ui.adapters.MyLeaderRecyclerViewAdapter
import com.esraa.gadsleaderboard.data.entities.LearningListTypes

class SkillLeadersFragment : Fragment() {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var skillsAdapter: MyLeaderRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        skillsAdapter = MyLeaderRecyclerViewAdapter(LearningListTypes.skillIq)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                view.adapter = skillsAdapter
                pageViewModel.getskillList().observe(viewLifecycleOwner,
                    {
                        it?.let { skillsAdapter.setModelList(it) }
                    })
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillLeadersFragment()

    }
}