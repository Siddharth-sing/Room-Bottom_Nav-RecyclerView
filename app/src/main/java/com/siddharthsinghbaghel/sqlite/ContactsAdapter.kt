package com.siddharthsinghbaghel.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.siddharthsinghbaghel.sqlite.nav_fragments.ContactsFragment
import com.siddharthsinghbaghel.sqlite.room.ContactEntity
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactsAdapter(private val context: ContactsFragment, private val listener: IContactRVAdapter):
                     RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>(){


    private val allContacts = ArrayList<ContactEntity>()

    inner class ContactsViewHolder(view: View): RecyclerView.ViewHolder(view){

         val contactName: TextView = view.tvContactName
         val contactNo: TextView = view.tvContactNo
         val btnDelete: ImageView = view.btnDelete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {

        val viewHolder = ContactsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))
      /*  viewHolder.btnDelete.setOnClickListener {
            listener.onItemClicked(allContacts[viewHolder.adapterPosition])
        }*/

        return viewHolder
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {

           val currentContact = allContacts[position]
           holder.contactName.text = currentContact.name
           holder.contactNo.text = currentContact.phoneNo


           holder.btnDelete.setOnClickListener{
                    listener.onItemClicked(allContacts[position])
           }
    }

    override fun getItemCount(): Int {
       return allContacts.size
    }

    /* To tell recycler view about the change of data due to viewModel*/
    fun updateList(newList: List<ContactEntity>){
        allContacts.clear()
        allContacts.addAll(newList)
        notifyDataSetChanged()
    }

interface IContactRVAdapter{

    fun onItemClicked(contact: ContactEntity)
}

}