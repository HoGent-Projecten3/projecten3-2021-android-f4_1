package example.javatpoint.com.kotlintablayoutexample


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.faithandroid.shoppingCenter.BodyFragment
import com.example.faithandroid.shoppingCenter.EyeFragment
import com.example.faithandroid.shoppingCenter.HairFragment
import com.example.faithandroid.shoppingCenter.SkinFragment

class ShoppingCenterTabAdapter(private val myContext: Context?, fm: FragmentManager?, internal var totalTabs: Int) : FragmentStatePagerAdapter(fm!!, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HairFragment()
            1 -> return EyeFragment()
            2 -> return BodyFragment()
            3 -> return SkinFragment()
        }
        return HairFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Haar"
            1 -> "Ogen"
            2 -> "Lichaam"
            3 -> "Huidskleur"
            else -> null
        }
    }
}