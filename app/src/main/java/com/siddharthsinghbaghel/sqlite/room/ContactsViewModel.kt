package com.siddharthsinghbaghel.sqlite.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsViewModel(application: Application): AndroidViewModel(application){
    private val repository: ContactsRepository
    val allContacts: LiveData<List<ContactEntity>>
    init {
        val dao = ContactRoomDatabase.getDatabase(application).getContactDao()
        repository = ContactsRepository(dao)
        allContacts = repository.allContacts
    }

    /*viewModelScope.launch(Dispatchers.IO) - coroutines used to avoid async task*/
    fun deleteContact(contact:ContactEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(contact)
    }

    fun insertContact(contact:ContactEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(contact)
    }


}