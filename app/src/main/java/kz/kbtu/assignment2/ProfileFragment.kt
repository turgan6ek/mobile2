package kz.kbtu.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.kbtu.assignment2.model.Post

class ProfileFragment : Fragment() {

    private lateinit var usernameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        usernameTextView = view.findViewById(R.id.profile_username)

        // Get the username from Safe Args
        val args = ProfileFragmentArgs.fromBundle(requireArguments())
        val username = args.username

        // Set the username in the TextView
        usernameTextView.text = username

        return view
    }

    // Mock posts data for the grid layout
    private fun mockPosts(): List<Post> {
        return listOf(
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Post 1", 120),
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Post 2", 100),
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Post 3", 90),
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Post 4", 75),
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_post_placeholder, "Post 5", 130)
        )
    }
}