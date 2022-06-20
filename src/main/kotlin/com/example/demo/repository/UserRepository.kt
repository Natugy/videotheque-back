package com.example.demo.repository

import com.example.demo.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User,Long> {
    fun findUserByName(name:String): User?
}