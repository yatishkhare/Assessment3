package com.example.assessment3

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "person")
class Person {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name: String
    var email: String
    var number: String
    var city: String

    @Ignore
    constructor(name: String, email: String, number: String, city: String) {
        this.name = name
        this.email = email
        this.number = number
        this.city = city
    }
    constructor(id: Int, name: String, email: String, number: String, city: String) {
        this.id = id
        this.name = name
        this.email = email
        this.number = number
        this.city = city
    }
}