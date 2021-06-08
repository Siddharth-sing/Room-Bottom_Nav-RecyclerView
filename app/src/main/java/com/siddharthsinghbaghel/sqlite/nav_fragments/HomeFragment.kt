package com.siddharthsinghbaghel.sqlite.nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.siddharthsinghbaghel.sqlite.R
import com.siddharthsinghbaghel.sqlite.room.ContactEntity
import com.siddharthsinghbaghel.sqlite.room.ContactsViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    lateinit var viewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this
            ).get(ContactsViewModel::class.java)

        myFragmentView.btnSave.setOnClickListener {

            val nameText = etFirstName.text.toString()
            val numberText = etContact.text.toString()
            if(nameText.isNotEmpty() && numberText.isNotEmpty()) {
                viewModel.insertContact(ContactEntity(nameText,numberText))
                Toast.makeText(context, "${nameText} Inserted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Invalid Entry", Toast.LENGTH_SHORT).show()
            }
        }

        return myFragmentView
    }
}