package kz.kbtu.assignment2

import kz.kbtu.assignment2.model.User

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class SearchFragment : Fragment() {

    private lateinit var searchInput: TextInputEditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        // Initialize views
        searchInput = view.findViewById(R.id.search_input)
        recyclerView = view.findViewById(R.id.search_results_recycler_view)

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        searchAdapter = UserAdapter(mockUsers())
        recyclerView.adapter = searchAdapter

        return view
    }

    // Mock user data
    private fun mockUsers(): List<User> {
        return listOf(
            User("user1", R.drawable.ic_profile_placeholder, "Bio of user1"),
            User("user2", R.drawable.ic_profile_placeholder, "Bio of user2"),
            User("user3", R.drawable.ic_profile_placeholder, "Bio of user3"),
            User("user4", R.drawable.ic_profile_placeholder, "Bio of user4"),
            User("user5", R.drawable.ic_profile_placeholder, "Bio of user5")
        )
    }
}
