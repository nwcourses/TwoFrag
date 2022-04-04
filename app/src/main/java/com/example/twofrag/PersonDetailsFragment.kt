package com.example.twofrag

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

// in PersonDetailsFragment
class PersonDetailsFragment : Fragment(R.layout.persondetailsfrag)
{
    var tv: TextView? = null
    var pendingText = ""

    val descriptions = hashMapOf(
        "Tim Berners-Lee" to "Inventor of the World Wide Web.",
        "John Lennon" to "Singer and songwriter from the Beatles whose life was cut tragically short in 1980.",
        "Linus Torvalds" to "Original developer of Linux.",
        "Barack Obama" to "President of the US. (2008-16)"
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = view.findViewById(R.id.tvPersonDetails)
        if(pendingText != "") {
            tv?.setText(descriptions[pendingText] ?:"I do not know $pendingText!")
            pendingText = ""
        }
    }


    // setText() method updates the TextView within the fragment to the
    // details corresponding to the person passed in.
    fun setText(person: String)
    {
        if(tv != null ) {
            tv?.text = descriptions[person] ?: "I do not know about $person !"
        }
        else {
            pendingText = person
        }
    }
}