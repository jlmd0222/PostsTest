package jlmd.dev.android.zemogatest.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.zemogatest.R
import jlmd.dev.android.zemogatest.data.model.Comment

class CommentAdapter(var comments: List<Comment>?, var resource: Int) : RecyclerView.Adapter<CommentAdapter.CardCommentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCommentHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CardCommentHolder(view)
    }

    override fun onBindViewHolder(holder: CardCommentHolder, position: Int) {
        val comment = comments?.get(position)
        holder.setDataCard(comment)
    }

    override fun getItemCount(): Int {
        return comments?.size ?: 0
    }

    class CardCommentHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var comment: Comment? = null
        private var tvTitle: TextView = v.findViewById(R.id.textViewTitlePost)

        fun setDataCard(comment: Comment?){
            this.comment = comment
            tvTitle.text = comment?.body
        }
    }
}