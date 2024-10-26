package com.example.hilttestproject.repository

import ContactDao
import com.example.hilttestproject.data.Contact
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(
    private val contactDao: ContactDao
) {
    val contacts = contactDao.getAllContacts()

    suspend fun insertContact(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}