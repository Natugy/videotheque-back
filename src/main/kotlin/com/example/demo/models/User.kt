package com.example.demo.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id
    val idUser: ObjectId =ObjectId(),
    val name: String,
    val filmList: MutableList<UserFilm>
)

