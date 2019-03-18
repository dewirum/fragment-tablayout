package com.example.aplication.rest

import com.example.aplication.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService{

@GET("posts/")
fun getAllPosts(): Observable<List<Post>>


}