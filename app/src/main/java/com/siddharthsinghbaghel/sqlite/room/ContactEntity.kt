package com.siddharthsinghbaghel.sqlite.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class ContactEntity(@ColumnInfo(name = "First Name") var name: String,
                    @ColumnInfo(name = "Number") var phoneNo: String ) {
    @PrimaryKey(autoGenerate = true) var id = 0
}


