package com.example.themoviedb_graciapardal.poko

data class KnownFor(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: MutableList<Number>,
    val id: Number,
    val media_type: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Number,
    val vote_count: Number,
    val first_air_date: String,
    val name: String,
    val origin_country: MutableList<String>,
    val original_name: String
)

data class People(
    val adult: Boolean,
    val gender: Number,
    val id: Number,
    var known_for: MutableList<KnownFor>,
    val known_for_department: String,
    val name: String,
    val popularity: Number,
    val profile_path: String
)

data class ResponsePopular(
    val page: Number,
    val results: MutableList<People>,
    val total_pages: Number,
    val total_results: Number
)



