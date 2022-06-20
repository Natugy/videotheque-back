package com.example.demo.repository

import com.example.demo.models.Film
import org.bson.types.ObjectId

import org.springframework.data.mongodb.repository.MongoRepository


interface FilmRepository : MongoRepository<Film, ObjectId>{
//    fun findFilmByType(type: String): List<Film>
    fun findFilmByTitle(title: String): Film?
}