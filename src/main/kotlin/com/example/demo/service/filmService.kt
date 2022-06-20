package com.example.demo.service

import com.example.demo.models.Film
import com.example.demo.models.SystResponse
import com.example.demo.models.ImportFilm
import com.example.demo.repository.FilmRepository
import com.fasterxml.jackson.databind.BeanDescription
import org.springframework.stereotype.Service
import java.time.Year

@Service
class FilmService(var db: FilmRepository) {
//    fun findByType(type: String): List<Film> = db.findFilmByType(type)

    fun findByTitle(title: String) : Boolean {
        db.findFilmByTitle(title)?.let {
            return true
        }
        return false
    }
    fun all(): List<Film> = db.findAll()

    fun postFilm(film: Film){

        db.findFilmByTitle(film.title)?.let {
            throw Exception("Film already Exist")
        }
        db.save(film)


    }
    fun updateFilm(title: String, isFav :Boolean){
        db.findFilmByTitle(title)?.let {
            val film= it.copy(isFavorite = isFav)
            db.save(film);
        }
            ?:throw Exception("Film doesn't exist")
    }

    fun deleteFilm(title: String){
        db.findFilmByTitle(title)?.let {
            db.delete(it)
        }
            ?:throw Exception("Film doesn't exist")
    }
}