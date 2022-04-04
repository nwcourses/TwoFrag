package com.example.twofrag

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PersonDetailsActivity : AppCompatActivity()
{

    override fun onCreate (savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE)
        {
            finish()
            return
        }

        setContentView(R.layout.persondetails)

        intent?.apply {
            val person = this.getStringExtra("name") ?: "No name found"
            val  frag = supportFragmentManager.findFragmentById(R.id.personDetailsFrag) as PersonDetailsFragment
            frag.setText(person)
        }
    }

}