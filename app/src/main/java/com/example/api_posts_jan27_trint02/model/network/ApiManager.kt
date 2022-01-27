package com.example.api_posts_jan27_trint02.model.network

class ApiManager {

    private var postService: PostService =
        RetrofitInstance.providesRetrofit().create(PostService::class.java)

    suspend fun getPosts() = postService.getPosts()
}