package jlmd.dev.android.zemogatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.presenter.MainPresenterImp
import jlmd.dev.android.zemogatest.view.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity(), PostMainView {
    private var mainPresenter: MainPresenterImp? = null
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenterImp(this)
        viewPager = findViewById(R.id.viewPager)
        setUpViewPager()

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager, true)

        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                viewPager?.adapter?.notifyDataSetChanged()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    private fun setUpViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(AllPostFragment())
        viewPagerAdapter.addFragment(FavoritesPostFragment())
        viewPager?.adapter = viewPagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_delete_all -> {
                deleteAllPost()
                return true
            }
            R.id.action_reload -> {
                getPosts()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun deleteAllPost() {
        mainPresenter?.deleteAllPosts()
    }

    override fun getPosts() {
        mainPresenter?.getPosts()
    }

    override fun updateView() {
        Toast.makeText(this, "Updated View", Toast.LENGTH_SHORT).show()
        viewPager?.adapter?.notifyDataSetChanged();
    }
}