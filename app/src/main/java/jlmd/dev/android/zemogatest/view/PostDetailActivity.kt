package jlmd.dev.android.zemogatest.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.model.User
import jlmd.dev.android.zemogatest.presenter.DetailPresenter
import jlmd.dev.android.zemogatest.presenter.DetailPresenterImp
import jlmd.dev.android.zemogatest.view.adapters.CommentAdapter
import jlmd.dev.android.zemogatest.view.model.Post


class PostDetailActivity : AppCompatActivity(), PostDetailView {
    private var postSelected: Post? = null
    private var recyclerComments: RecyclerView? = null
    private var detailPresenter: DetailPresenter? = null
    private var textViewName: TextView? = null
    private var textViewEmail: TextView? = null
    private var textViewPhone: TextView? = null
    private var textViewWeb: TextView? = null
    private var progressComments: ProgressBar? = null
    private var progressUser: ProgressBar? = null
    private var menuFavorite: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        setSupportActionBar(findViewById(R.id.toolbarDetail))

        // calling the action bar
        val actionBar = supportActionBar
        // showing the back button in action bar
        actionBar?.setDisplayShowTitleEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        postSelected = intent.getSerializableExtra("POST") as Post
        detailPresenter = DetailPresenterImp(this)

        initComponentsView()
        getComments()
        getUser()
    }

    private fun initComponentsView() {
        recyclerComments = findViewById(R.id.recyclerComments)
        recyclerComments?.layoutManager = LinearLayoutManager(this)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)
        textViewName = findViewById(R.id.textViewName)
        textViewEmail = findViewById(R.id.textViewEmail)
        textViewPhone = findViewById(R.id.textViewPhone)
        textViewWeb = findViewById(R.id.textViewWeb)
        progressComments = findViewById(R.id.progressComments)
        progressUser = findViewById(R.id.progressUser)

        textViewDescription.text = postSelected?.body
    }

    override fun getComments() {
        detailPresenter?.getComments(postSelected!!.id)
    }

    override fun getUser() {
        detailPresenter?.getUser(postSelected!!.userId)
    }

    override fun showComments(comments: List<Comment>?) {
        try {
            recyclerComments!!.adapter = CommentAdapter(comments, R.layout.card_comment)
            progressComments?.visibility = View.GONE
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun showUser(user: User?) {
        try {
            textViewName?.text = user?.name
            textViewEmail?.text = user?.email
            textViewPhone?.text = user?.phone
            textViewWeb?.text = user?.website
            progressUser?.visibility = View.GONE
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuFavorite = menu
        if (postSelected?.isFavorite == true){
            menuFavorite?.getItem(0)?.setIcon(R.drawable.ic_star)
        }else {
            menuFavorite?.getItem(0)?.setIcon(R.drawable.ic_star_border)
        }
        return super.onPrepareOptionsMenu(menuFavorite)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_isFavorite -> {
                if (postSelected?.isFavorite == true){
                    item.setIcon(R.drawable.ic_star_border)
                }else {
                    item.setIcon(R.drawable.ic_star)
                }
                postSelected?.let { setFavoritePost(it) }
                return true
            }
            R.id.action_delete -> {
                postSelected?.let { deletePost(it) }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setFavoritePost(post: Post) {
        post.isFavorite = !post.isFavorite
        detailPresenter?.updatePost(post)
    }

    override fun deletePost(post: Post) {
        detailPresenter?.deletePost(post)
    }

    override fun updateView() {
        Toast.makeText(this, "Deleted Post", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun finish() {
        setResult(RESULT_OK, Intent())
        super.finish()
    }
}