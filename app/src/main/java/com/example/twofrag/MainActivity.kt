package com.example.twofrag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // in the Activity
    override fun onCreate (savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)

        // Find each fragment using their IDs
        val personEntryFrag = supportFragmentManager.findFragmentById(R.id.personEntryFrag) as PersonEntryFragment
        val personDetailsFrag = supportFragmentManager.findFragmentById(R.id.personDetailsFrag) as PersonDetailsFragment?

        personEntryFrag.callback = {

            if(personDetailsFrag == null || !personDetailsFrag.isVisible) {
           // if (resources.configuration.orientation != android.content.res.Configuration.ORIENTATION_LANDSCAPE) {

                Intent (this, PersonDetailsActivity::class.java).apply {
                    this.putExtra("name", it)
                    startActivity(this)
                }
            } else {
                personDetailsFrag.setText(it)
            }
        }
    }
}