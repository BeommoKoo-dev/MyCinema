package com.example.mycinema.movie.adapter.`in`.dto.request

import com.example.mycinema.movie.domain.entity.Movie

data class RegisterMovieRequestDto(
    val movieName: String,
    val directorName: String
) {
    fun toEntity(): Movie {
        return Movie(
            movieName,
            directorName
        )
    }
}
