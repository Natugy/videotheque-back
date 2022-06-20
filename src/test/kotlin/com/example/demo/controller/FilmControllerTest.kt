//package com.example.demo.controller
//
//
//import com.example.demo.models.SystResponse
//import com.example.demo.models.ImportFilm
//import com.example.demo.service.FilmService
//import com.ninjasquad.springmockk.MockkBean
//import io.mockk.every
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
//
//
//@WebMvcTest(FilmController::class)
//class FilmControllerTest(@Autowired val mockMvc: MockMvc){
//    @MockkBean
//    lateinit var filmService: FilmService
//
//
////    val film = importFilm(title = "Avatar",type="SF")
//
//    @Test
//    fun testGetFilmWrong(){
//        every{ filmService.findByTitle("Avatar") } returns SystResponse("Error", "")
//
//        mockMvc.perform(get("/v1/film/title/Avatar"))
//            .andExpect(status().isOk)
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.type").value("Error"))
//
//    }
//    @Test
//    fun testPostError(){
//        every { filmService.postFilm(ImportFilm(title = "Avatar",type="SF")) } returns SystResponse("Error", "Already Exist")
//
//        mockMvc.perform(
//            post("/v1/film/add")
//                .param("title","Avatar")
//                .param("type","SF")
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(status().isOk)
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.type").value("Error"))
//    }
//    @Test
//    fun testPostSuccess(){
//        every { filmService.postFilm(ImportFilm(title = "Avatar",type="SF")) } returns SystResponse("Success", "Add Successfully")
//
//        mockMvc.perform(
//            post("/v1/film/add")
//                .param("title","Avatar")
//                .param("type","SF")
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(status().isOk)
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.type").value("Success"))
//    }
//
//}