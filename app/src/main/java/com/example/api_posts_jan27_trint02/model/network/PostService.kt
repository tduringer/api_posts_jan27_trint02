package com.example.api_posts_jan27_trint02.model.network

import com.example.api_posts_jan27_trint02.model.network.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}