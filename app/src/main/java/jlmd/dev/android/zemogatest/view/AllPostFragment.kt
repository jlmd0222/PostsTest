package jlmd.dev.android.zemogatest.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.presenter.AllPresenter
import jlmd.dev.android.zemogatest.presenter.AllPresenterImp
import jlmd.dev.android.zemogatest.view.adapters.PostAdapter
import jlmd.dev.android.zemogatest.view.model.Post

class AllPostFragment : Fragment(), PostView, PostAdapter.OnPostListener {
    private var allPostPresenter: AllPresenter? = null
    private var recyclerPosts: RecyclerView? = null
    private var progressPosts: ProgressBar? = null
    private var postAdapter: PostAdapter? = null
    private val REQUEST_CODE: Int = 301

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_all_post, container, false)
        allPostPresenter = AllPresenterImp(this)
        //VIEW
        initComponentsView(view)
        getPosts()
        return view
    }

    private fun initComponentsView(view: View) {
        recyclerPosts = view.findViewById(R.id.recyclerPost)
        progressPosts = view.findViewById(R.id.progressPosts)
        recyclerPosts?.layoutManager = LinearLayoutManager(context)
    }

    override fun getPosts() {
        allPostPresenter?.getPosts()
    }

    override fun showPosts(posts: List<Post>?) {
        try {
            postAdapter = PostAdapter(posts, R.layout.card_post, this)
            recyclerPosts!!.adapter = postAdapter
            progressPosts?.visibility = View.GONE
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onPostClick(post: Post) {
        post.let { Log.i("CLICK Post: ", it.title) }
        val showPostIntent = Intent(context, PostDetailActivity::class.java)
        showPostIntent.putExtra("POST", post)
        startActivityForResult(showPostIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            getPosts()
        }
    }
}