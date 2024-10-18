package kz.kbtu.assignment2

import kz.kbtu.assignment2.model.Post
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFeedFragment : Fragment(), PostAdapter.OnPostInteractionListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val posts = mutableListOf<Post>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_feed, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        postAdapter = PostAdapter(posts, this)
        recyclerView.adapter = postAdapter

        // Load posts (mock data)
        loadMockPosts()

        return view
    }

    private fun loadMockPosts() {
        posts.add(Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Caption 1", 100))
        posts.add(Post("user2", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Caption 2", 150))
        postAdapter.notifyDataSetChanged()
    }

    // Handle username click
    override fun onUsernameClicked(username: String) {
        // Navigate to profile
        // Example: val action = HomeFeedFragmentDirections.actionNavHomeToNavProfile(username)
        // findNavController().navigate(action)
    }

    // Handle post like action
    override fun onPostLiked(post: Post, position: Int) {
        // Optional: Handle post like action (e.g., save like state, analytics)
    }
}


