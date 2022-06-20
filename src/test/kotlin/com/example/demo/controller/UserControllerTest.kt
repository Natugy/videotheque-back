package com.example.demo.controller

import com.example.demo.models.Film
import com.example.demo.models.SystResponse
import com.example.demo.models.UserFilm
import com.example.demo.service.UserService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(UserController::class)
internal class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var userService: UserService

    val filmList = listOf<UserFilm>(UserFilm(Film(title = "Avatar"),"VHS"))

    @Test
    fun addFilm() {
        every { userService.addFilm("Avatar","Vador","VHS") } returns SystResponse("Success", "Add Successfully")

        mockMvc.perform(post("/v1/user/film/add")
                .param("userName","Vador")
                .param("title","Avatar")
                .param("discType","VHS")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.type").value("Success"))


    }

    @Test
    fun addUserTest(){
        every { userService.adduser("Vador") } returns SystResponse("Success", "Add Successfully")

        mockMvc.perform(post("/v1/user/addUser")
            .param("name","Vador")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.type").value("Success"))
    }

    @Test
    fun removeUserTest(){
        every { userService.removeFilm("Avatar","Vador","VHS") } returns SystResponse("Error", "Film don't exist in user list")

        mockMvc.perform(post("/v1/user/film/remove")
            .param("title","Avatar")
            .param("userName", "Vador")
            .param("discType","VHS")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.type").value("Error"))
    }

    @Test
    fun filmListTest(){
        every { userService.list("Vador") } returns filmList
        mockMvc.perform(get("/v1/user/filmList").param("userName","Vador").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.[0].discType").value("VHS"))
    }
}