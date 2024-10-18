package kz.kbtu.assignment2

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class AddPostFragment : Fragment() {

    private lateinit var postImageView: ImageView
    private lateinit var captionEditText: EditText
    private lateinit var uploadButton: Button
    private var selectedImageUri: Uri? = null

    // Register activity for image picking
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedImageUri = uri
        postImageView.setImageURI(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_post, container, false)

        postImageView = view.findViewById(R.id.post_image_view)
        captionEditText = view.findViewById(R.id.caption_edit_text)
        uploadButton = view.findViewById(R.id.upload_button)

        postImageView.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        uploadButton.setOnClickListener {
            uploadPost()
        }

        return view
    }

    private fun uploadPost() {
        val caption = captionEditText.text.toString()

        if (selectedImageUri == null) {
            Snackbar.make(requireView(), "Please select an image", Snackbar.LENGTH_SHORT).show()
        } else if (caption.isBlank()) {
            Snackbar.make(requireView(), "Please enter a caption", Snackbar.LENGTH_SHORT).show()
        } else {
            // Simulate post upload
            Snackbar.make(requireView(), "Post uploaded successfully!", Snackbar.LENGTH_SHORT).show()
            // Reset the form
            postImageView.setImageResource(R.drawable.ic_add_image_placeholder)
            captionEditText.text.clear()
        }
    }
}
