package com.example.api_posts_jan27_trint02.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.api_posts_jan27_trint02.databinding.FragmentPostBinding
import com.example.api_posts_jan27_trint02.model.network.ApiManager
import com.example.api_posts_jan27_trint02.model.repository.PostRepository
import com.example.api_posts_jan27_trint02.viewmodel.PostViewModel

class PostFragment : Fragment(){

    private var _binding : FragmentPostBinding? = null
    private val binding : FragmentPostBinding get() = _binding!!

    private val viewModel: PostViewModel by activityViewModels {
        PostViewModel.Factory(PostRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater,container,false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.posts.observe(viewLifecycleOwner) {
            binding.tvPost.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}