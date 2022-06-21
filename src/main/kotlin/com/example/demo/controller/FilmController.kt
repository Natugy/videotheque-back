package com.example.demo.controller

import com.example.demo.models.Film
import com.example.demo.service.FilmService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/film")
class FilmController(private val filmService: FilmService){
//
//    @GetMapping("/filter/{type}")
//    fun index(@PathVariable type: String): List<Film> = filmService.findByType(type)

    @GetMapping("/title")
    fun title(@RequestParam title: String) = filmService.findByTitle(title)

    @GetMapping("/list")
    fun root(): List<Film> {
        return filmService.all()
    }

    @PostMapping("/add")
    fun post(@RequestParam title: String,
             @RequestParam description: String,
             @RequestParam year: String,
             @RequestParam tmdbId: Int,
             @RequestParam rating:Double,
             @RequestParam posterPath: String
    ) {
        val film = Film(title = title, description = description, year = year, id = tmdbId, rating = rating, posterPath = posterPath)
        filmService.postFilm(film)
    }
    @PostMapping("/update")
    fun update(@RequestParam title: String, @RequestParam isFav : Boolean) = filmService.updateFilm(title, isFav)

    @PostMapping("/delete")
    fun delete(@RequestParam title: String) = filmService.deleteFilm(title)
}
