package jlmd.dev.android.zemogatest.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var fragmentList: MutableList<Fragment> = mutableListOf()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position];
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "ALL"
            1 -> return "FAVORITES"
        }
        return super.getPageTitle(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
    }
}