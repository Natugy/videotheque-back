//package com.example.demo.service
//
//import com.example.demo.models.Film
//import com.example.demo.models.SystResponse
//import com.example.demo.models.ImportFilm
//import com.example.demo.repository.FilmRepository
//import io.mockk.every
//import io.mockk.mockk
//import io.mockk.verify
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//
//class FilmServiceTest {
//    private val filmRepository : FilmRepository = mockk()
//    private val filmService : FilmService = FilmService(filmRepository)
//    private val listFilm : List<Film> = listOf(Film(title = "Batman", type = "Action"))
//
//
//
//    @Test
//    fun testFindAll(){
//        every { filmRepository.findAll() } returns listFilm
//
//        val result = filmService.all()
//
//        assertEquals(listFilm, result)
//
//    }
//
//    @Test
//    fun testFindByType(){
//        every { filmRepository.findFilmByType("Action") } returns listFilm
//
//
//        val result = filmService.findByType("Action")
//        verify { filmRepository.findFilmByType("Action") }
//        assertEquals(listFilm[0].type, result[0].type)
//    }
//
//
//    @Test
//    fun testPostFilmWhenFilmAlreadyExist(){
//
//        every { filmRepository.findFilmByTitle("Avatar") } returns Film(title = "Avatar")
//
//        val result= filmService.postFilm(ImportFilm("Avatar","Action"))
//
//        verify { filmRepository.findFilmByTitle("Avatar") }
//
//        assertEquals(SystResponse("Error", "Film already in Database"),result)
//    }
//
//    @Test
//    fun testPostFilmWhenFilmDontExist(){
//
//        every { filmRepository.findFilmByTitle("Avatar") } returns null
////        every { filmRepository.save(Film(title = "Avatar", type = "Action")) } returns Film(title = "Avatar")
//        every { filmRepository.save(any()) } returns Film(title = "Robot")
//        val result= filmService.postFilm(ImportFilm("Avatar","Action"))
//
//        verify { filmRepository.findFilmByTitle("Avatar") }
//
//        assertEquals(SystResponse("Success", "Add Successfully"),result)
//    }
//}