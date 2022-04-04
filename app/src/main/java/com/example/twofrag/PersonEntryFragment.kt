package com.example.twofrag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// in PersonEntryFragment
public class PersonEntryFragment : Fragment(R.layout.personentryfrag)
{
    var callback: ((String) -> Unit)? = null
    val list = listOf("Tim Berners-Lee", "John Lennon", "Linus Torvalds", "Barack Obama")

    // when the view has been created, add the event listener to the button, so
    // the callback is called when it's clicked
    override fun onViewCreated(v: View, b: Bundle?) {

        /*
        val btnGo = v.findViewById(R.id.btnGo) as Button
        val etPersonName = v.findViewById(R.id.etPersonName) as EditText



        btnGo.setOnClickListener {
            // Invoke the callback, passing it the text in the edit text.
            // We cannot just do
            // callback(etPersonName.text.toString())
            // as the callback is nullable, and will be null until it's set.

            callback?.invoke(etPersonName.text.toString())
        }

         */

        val recycler = v.findViewById<RecyclerView>(R.id.recycler1)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = PersonAdapter(list) {
            callback?.invoke(list[it])
        }
    }
}