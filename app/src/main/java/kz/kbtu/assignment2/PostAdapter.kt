package kz.kbtu.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.kbtu.assignment2.model.Post

class PostAdapter(
    private val posts: List<Post>,
    private val listener: OnPostInteractionListener
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface OnPostInteractionListener {
        fun onUsernameClicked(username: String)
        fun onPostLiked(post: Post, position: Int)  // New function for like interaction
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profile_image)
        val postImage: ImageView = itemView.findViewById(R.id.post_image)
        val username: TextView = itemView.findViewById(R.id.username)
        val caption: TextView = itemView.findViewById(R.id.caption)
        val likes: TextView = itemView.findViewById(R.id.likes)
        val likeButton: ImageView = itemView.findViewById(R.id.like_button)  // Add like button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        // Set post details
        holder.profileImage.setImageResource(post.profileImage)
        holder.postImage.setImageResource(post.postImage)
        holder.username.text = post.username
        holder.caption.text = post.caption
        holder.likes.text = "${post.likes} likes"

        // Set the like button icon based on whether the post is liked or not
        if (post.liked) {
            holder.likeButton.setImageResource(R.drawable.ic_liked)  // Liked icon (filled heart)
        } else {
            holder.likeButton.setImageResource(R.drawable.ic_like)  // Unliked icon (heart outline)
        }

        // Handle username click to navigate to profile
        holder.username.setOnClickListener {
            listener.onUsernameClicked(post.username)
        }

        // Handle like button click to toggle the like status
        holder.likeButton.setOnClickListener {
            // Toggle the liked status
            post.liked = !post.liked
            if (post.liked) {
                post.likes += 1  // Increment likes
            } else {
                post.likes -= 1  // Decrement likes
            }
            // Notify the adapter to refresh the item at the current position
            notifyItemChanged(position)

            // Notify the listener about the like action (optional)
            listener.onPostLiked(post, position)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}




