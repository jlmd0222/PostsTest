package jlmd.dev.android.zemogatest.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.view.model.Post

class PostAdapter(private var posts : List<Post>?, private var resource: Int, var onPostListener: OnPostListener) : RecyclerView.Adapter<PostAdapter.CardPostHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardPostHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(resource, p0, false)
        return CardPostHolder(view, onPostListener)
    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardPostHolder, p1: Int) {
        val post = posts?.get(p1)
        p0.setDataCard(post)
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class CardPostHolder(v: View, postListener: OnPostListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var post: Post? = null
        private var textViewTitle: TextView = v.findViewById(R.id.textViewTitlePost)
        private var imageView: ImageView = v.findViewById(R.id.imageViewFavorite)
        private var postListenerLocal: OnPostListener = postListener

        init {
            v.setOnClickListener(this)
        }

        fun setDataCard(post: Post?){
            this.post = post
            textViewTitle.text = post?.title
            if(post?.isFavorite == true) {
                imageView.visibility = View.VISIBLE
            }else {
                imageView.visibility = View.GONE
            }
        }

        override fun onClick(v: View) {
            post?.let { postListenerLocal.onPostClick(it) }
        }
    }

    interface OnPostListener{
        fun onPostClick(post: Post)
    }
}