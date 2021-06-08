package com.siddharthsinghbaghel.sqlite.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ContactsRepository(private val contactDao: ContactDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    val allContacts: LiveData<List<ContactEntity>> = contactDao.getAllContacts()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(contact: ContactEntity) {
        contactDao.insertContact(contact)
    }
    suspend fun delete(contact: ContactEntity) {
        contactDao.deleteContact(contact)
    }

}