package com.example.api_posts_jan27_trint02.viewmodel

import androidx.lifecycle.*
import com.example.api_posts_jan27_trint02.model.network.models.Post
import com.example.api_posts_jan27_trint02.model.repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    private var _posts: MutableLiveData<List<Post>?> = MutableLiveData()
    val posts: LiveData<List<Post>?> = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = postRepository.getPosts()
            _posts.postValue(response)
        }
    }

    class Factory(
        private val postRepository: PostRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
                return PostViewModel(postRepository) as T
            } else {
                throw RuntimeException("Could not create instance of PostViewModel")
            }
        }
    }
}