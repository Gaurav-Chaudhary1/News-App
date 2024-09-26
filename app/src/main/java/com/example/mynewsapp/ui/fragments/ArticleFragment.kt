package com.example.mynewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.mynewsapp.R
import com.example.mynewsapp.databinding.FragmentArticleBinding
import com.example.mynewsapp.ui.NewsActivity
import com.example.mynewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        // Null safety check for the article object
        article?.let {
            binding.webView.apply {
                webViewClient = WebViewClient()
                it.url?.let { url -> loadUrl(url) } // Ensure URL is not null
            }
        } ?: run {
            // Handle the case when article is null
            Snackbar.make(view, "Error: Article not found.", Snackbar.LENGTH_LONG).show()
        }

        // Null safety check for the article object
        article?.let {
            binding.webView.apply {
                webViewClient = WebViewClient()
                it.url?.let { url -> loadUrl(url) } // Ensure URL is not null
            }
        } ?: run {
            // Handle the case when article is null
            Snackbar.make(view, "Error: Article not found.", Snackbar.LENGTH_LONG).show()
        }
    }
}
