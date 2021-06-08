package com.siddharthsinghbaghel.sqlite.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContact(contact: ContactEntity)
    @Delete
    suspend fun deleteContact(contact: ContactEntity)
    @Query("select * from contacts order by `First Name` ASC")
    fun getAllContacts(): LiveData<List<ContactEntity>>

}