package com.siddharthsinghbaghel.sqlite.nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.siddharthsinghbaghel.sqlite.ContactsAdapter
import com.siddharthsinghbaghel.sqlite.R
import com.siddharthsinghbaghel.sqlite.room.ContactEntity
import com.siddharthsinghbaghel.sqlite.room.ContactsViewModel
import kotlinx.android.synthetic.main.contact_item.*
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_contacts.view.*


class ContactsFragment : Fragment(),ContactsAdapter.IContactRVAdapter {

    lateinit var viewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView =  inflater.inflate(R.layout.fragment_contacts, container, false)

        val contactRecyclerView = myFragmentView.rvAllContacts
        val adapter = ContactsAdapter(this,this)
        contactRecyclerView.adapter = adapter
        contactRecyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(requireActivity()
        ).get(ContactsViewModel::class.java)

        viewModel.allContacts.observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.updateList(it)
            }
        })

        return myFragmentView


    }

    override fun onItemClicked(contact: ContactEntity) {

            Toast.makeText(context, "onItemClicked Delete", Toast.LENGTH_SHORT).show()
            viewModel.deleteContact(contact)



    }


}