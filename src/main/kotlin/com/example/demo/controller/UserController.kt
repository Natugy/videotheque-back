package com.example.demo.controller

import com.example.demo.models.SystResponse
import com.example.demo.models.User
import com.example.demo.models.UserFilm
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController(private val userService: UserService) {


    @GetMapping("/filmList")
    fun filmlist(@RequestParam userName: String) : List<UserFilm> {
        return userService.list(userName)
    }

    @GetMapping("/userList")
    fun userlist(): List<String> = userService.listUser()

    @PostMapping("/addUser")
    fun adduser(@RequestParam name: String): SystResponse = userService.adduser(name)


    @PostMapping("/film/add")
    fun addfilm(@RequestParam userName: String, @RequestParam title: String, @RequestParam discType: String) = userService.addFilm(title,userName,discType)


    @PostMapping("/film/remove")
    fun removefilm(@RequestParam userName: String, @RequestParam title: String,@RequestParam discType: String)  = userService.removeFilm(title,userName,discType)

}