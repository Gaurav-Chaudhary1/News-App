package com.example.mynewsapp.repository

import com.example.mynewsapp.api.RetrofitInstance
import com.example.mynewsapp.db.ArticleDatabase
import com.example.mynewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticles(article: Article) = db.getArticleDao().deleteArticles(article)

}