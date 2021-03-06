package com.example.getmeout.repositories

import androidx.lifecycle.LiveData
import com.example.getmeout.model.Contact
import com.example.getmeout.model.ContactDao

class ContactRepository(private val contactDao: ContactDao) {

    fun getAll(): LiveData<List<Contact>> {
        return contactDao.getAll()
    }

    fun insert(contact: Contact) {
        contactDao.insertAll(contact)
    }

    fun update(selected: Boolean, contact_uid: Int) {
        contactDao.update(selected, contact_uid)
    }

    // TODO -- Delete via UID / PRI KEY
    fun delete(contact: Contact) {
        contactDao.delete(contact)
    }

    fun deleteAll() {
        contactDao.deleteAll()
    }

    fun deleteByUid(contact_uid: Int) {
        contactDao.deleteByUid(contact_uid)
    }

    fun getAllContacts_VALUES(): List<Contact> {
        return contactDao.getAllContacts()
    }

    fun getAllSelected(): List<Contact> {
        return contactDao.getAllSelected()
    }

    fun updateContact(first_name: String, last_name: String, phone_no: String, contact_id: Int) {
        contactDao.updateContact(first_name, last_name, phone_no, contact_id)
    }

}