package com.example.api_posts_jan27_trint02.model.repository

import com.example.api_posts_jan27_trint02.model.network.ApiManager
import com.example.api_posts_jan27_trint02.model.network.models.Post
import java.lang.Exception

class PostRepository(
    private val apiManager: ApiManager
) {
    suspend fun getPosts() : List<Post>? {
        return try {
            val response = apiManager.getPosts()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }

}