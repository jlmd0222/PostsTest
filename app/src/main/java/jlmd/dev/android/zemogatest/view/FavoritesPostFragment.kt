package jlmd.dev.android.zemogatest.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.presenter.FavoritePresenter
import jlmd.dev.android.zemogatest.presenter.FavoritePresenterImp
import jlmd.dev.android.zemogatest.view.adapters.PostAdapter
import jlmd.dev.android.zemogatest.view.model.Post

class FavoritesPostFragment : Fragment(), PostFavoriteView, PostAdapter.OnPostListener {
    private var recyclerFavoritePosts: RecyclerView? = null
    private var postAdapter: PostAdapter? = null
    private var favoritePresenter: FavoritePresenter? = null
    private val REQUEST_CODE: Int = 301

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_favorites_post, container, false)
        favoritePresenter = FavoritePresenterImp(this)
        //VIEW
        initComponentsView(view)
        getFavoritePosts()
        return view
    }

    private fun initComponentsView(view: View) {
        recyclerFavoritePosts = view.findViewById(R.id.recyclerFavoritePost)
        recyclerFavoritePosts?.layoutManager = LinearLayoutManager(context)
    }

    override fun getFavoritePosts() {
        favoritePresenter?.getFavoritePosts()
    }

    override fun showFavoritePosts(posts: List<Post>?) {
        try {
            postAdapter = PostAdapter(posts, R.layout.card_post, this)
            recyclerFavoritePosts!!.adapter = postAdapter
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
            getFavoritePosts()
        }
    }
}