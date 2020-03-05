package com.pram.bookapivolley.api.service

object BookApiUrl {
    private const val BASE_URL = "https://ancient-brook-04057.herokuapp.com"
    const val getBooks = "$BASE_URL/books"
    const val getBook = "$BASE_URL/books/"
    const val createBook = "$BASE_URL/books"
    const val putBook = "$BASE_URL/books/"
    const val patchBook = "$BASE_URL/books/"
    const val removeBook = "$BASE_URL/books/"
}