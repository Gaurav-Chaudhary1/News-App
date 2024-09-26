package com.example.mynewsapp.models

import java.io.Serializable

data class Source(
    val id: String?, // Nullable
    val name: String? // Nullable
) : Serializable