package com.esraa.gadsleaderboard.presentation.ui.main.learner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.domain.viewmodels.PageViewModel
import com.esraa.gadsleaderboard.data.entities.LearningListTypes
import com.esraa.gadsleaderboard.presentation.ui.adapters.MyLeaderRecyclerViewAdapter

class LearningLeadersFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var learnerAdapter: MyLeaderRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        learnerAdapter = MyLeaderRecyclerViewAdapter(LearningListTypes.learner)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        initView(root)
        return root
    }

    private fun initView(view: View) {
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                view.adapter=learnerAdapter
                pageViewModel.getlearningList().observe(viewLifecycleOwner, {
                       it?.let {
                           learnerAdapter.setModelList(it )  }
                    })
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(): LearningLeadersFragment {
            return LearningLeadersFragment()
        }
    }


}