package com.example.demo.service

import com.example.demo.models.SystResponse
import com.example.demo.models.User
import com.example.demo.models.UserFilm
import com.example.demo.repository.FilmRepository
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userdb: UserRepository, val filmdb: FilmRepository) {

    fun addFilm(title: String, name: String, typeDisc: String) :SystResponse{

        filmdb.findFilmByTitle(title)?.let { film ->
            val userFilm= UserFilm(film= film, discType = typeDisc)

            userdb.findUserByName(name)?.let { user ->

                if(user.filmList.contains(userFilm)) {

                    return SystResponse("Error", "Already exist")
                }
                else {

                    user.filmList.add(userFilm)
                    userdb.save(user)
                    return SystResponse("Success", "Add Successfully ")
                }
            }
            return SystResponse("Error", "User not found in the DataBase")
        }
        return SystResponse("Error", "Film not found in the DataBase")
    }


    fun list(name: String): List<UserFilm> {
        userdb.findUserByName(name)?.let { user ->
            return user.filmList
        }
        println("User doesn't exist")
        return listOf()
    }

    fun adduser(name: String): SystResponse {
        var newUser= User(name = name, filmList = mutableListOf())
        userdb.findUserByName(name)?.let {
            newUser = it
            println("User already exist")
            return SystResponse("Error", "User Already Exist")
        }
        userdb.save(newUser)
        return SystResponse("Success","User add Successfully")
    }

    fun removeFilm(title: String, username: String, discType: String): SystResponse {
        userdb.findUserByName(username)?.let {user ->
            filmdb.findFilmByTitle(title)?.let { film ->
                val userFilm= UserFilm(film = film, discType = discType)
                if(user.filmList.contains(userFilm)){
                    user.filmList.remove(userFilm)

                    userdb.save(user)
                    return SystResponse("Success", "Film removed successfully")
                }
                else{
                    return SystResponse("Error", "Film not in user's list")

                }
            }
            return SystResponse("Error", "Film doesn't in Database")
        }
        return SystResponse("Error", "User not found in database")
    }

    fun listUser(): MutableList<String> {
        val list = userdb.findAll()
        val res = mutableListOf<String>()
        for (user in list){
            res.add(user.name)
        }
        return res
    }

}