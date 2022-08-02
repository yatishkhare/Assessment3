package com.example.assessment3

import androidx.room.*

@Dao
interface PersonDao {
    @Query("SELECT * FROM PERSON ORDER BY ID")
    fun loadAllPersons(): List<Person?>?

    @Insert
    fun insertPerson(person: Person?)

    @Update
    fun updatePerson(person: Person?)

    @Delete
    fun delete(person: Person?)

    @Query("SELECT * FROM PERSON WHERE ID = :id")
    fun loadPersonById(id: Int): Person?
}

