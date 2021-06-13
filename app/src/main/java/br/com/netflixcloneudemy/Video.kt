package br.com.netflixcloneudemy

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import br.com.netflixcloneudemy.databinding.ActivityVideoBinding

class Video : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val videoURL = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-udemy.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=bd820418-d452-4342-b8c3-a6346219912c")

        val video = binding.vvVideo
        video.setMediaController(MediaController(this))
        video.setVideoURI(videoURL)
        video.requestFocus()
        video.start()
    }
}