package fr.thibma.android_layouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    private lateinit var textUsername: TextView
    private lateinit var textFollowing: TextView
    private lateinit var textFollower: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textUsername = findViewById<TextView>(R.id.textViewName)
        textUsername.text = intent.getStringExtra("Username")

        textFollowing = findViewById<TextView>(R.id.textViewFollowing)
        textFollowing.text = intent.getStringExtra("Following") + " abonnements"

        textFollower = findViewById<TextView>(R.id.textViewFollower)
        textFollower.text = intent.getStringExtra("Follower") + " abonnés"
    }
}