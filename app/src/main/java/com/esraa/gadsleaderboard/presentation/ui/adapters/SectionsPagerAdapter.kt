package com.esraa.gadsleaderboard.presentation.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.presentation.ui.main.learner.LearningLeadersFragment
import com.esraa.gadsleaderboard.presentation.ui.main.skilliq.SkillLeadersFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_learner,
    R.string.tab_skill
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return LearningLeadersFragment.newInstance()
            1 -> return SkillLeadersFragment.newInstance()
        }
        return Fragment()
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }
    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}