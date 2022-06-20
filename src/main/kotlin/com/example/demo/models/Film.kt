package com.example.demo.models


import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document



@Document
data class Film(@Id val newid: String = ObjectId().toHexString(),
                val id : Int=0,
                val title: String="",
                val description: String="",
                val year: String = "",
                val rating:Double ,
                val posterPath:String="",
                val isFavorite: Boolean = false,
                val added: Boolean =true

)

data class ImportFilm(val title: String, val description: String,
                      val year: Int,)

