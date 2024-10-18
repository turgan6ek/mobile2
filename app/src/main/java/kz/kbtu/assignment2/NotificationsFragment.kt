package kz.kbtu.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.kbtu.assignment2.model.Notification

class NotificationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationsAdapter: NotificationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.notifications_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Set up adapter with mock notifications
        notificationsAdapter = NotificationsAdapter(mockNotifications())
        recyclerView.adapter = notificationsAdapter

        return view
    }

    // Mock notifications data
    private fun mockNotifications(): List<Notification> {
        return listOf(
            Notification("user1 liked your post", "10 minutes ago", R.drawable.ic_like),
            Notification("user2 commented on your post", "30 minutes ago", R.drawable.ic_comment),
            Notification("user3 started following you", "1 hour ago", R.drawable.ic_follow),
            Notification("user4 liked your post", "2 hours ago", R.drawable.ic_like),
            Notification("user5 commented on your post", "3 hours ago", R.drawable.ic_comment)
        )
    }
}
