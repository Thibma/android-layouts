package fr.thibma.android_layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.error_dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToProfile: Button

    private lateinit var textFieldUsername: EditText
    private lateinit var textFieldFollowing: EditText
    private lateinit var textFieldFollower: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToProfile = findViewById<Button>(R.id.button)

        textFieldUsername = findViewById<EditText>(R.id.editTextName)
        textFieldFollowing = findViewById<EditText>(R.id.editTextFollowing)
        textFieldFollower = findViewById<EditText>(R.id.editTextFollowers)

        buttonToProfile.setOnClickListener {

            if (textFieldUsername.length() > 0 && textFieldFollowing.length() > 0 && textFieldFollower.length() > 0) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Username", textFieldUsername.text.toString())
                    .putExtra("Following", textFieldFollowing.text.toString())
                    .putExtra("Follower", textFieldFollower.text.toString())
                startActivity(intent)
            }

            else {
                val mDialogView = LayoutInflater.from(this).inflate(R.layout.error_dialog, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Erreur")
                val mAlertDialog = mBuilder.show()
                mDialogView.buttonOk.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }

        }

    }
}
