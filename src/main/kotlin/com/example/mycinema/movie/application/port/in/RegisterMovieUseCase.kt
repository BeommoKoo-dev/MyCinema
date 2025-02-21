package com.example.mycinema.movie.application.port.`in`

import com.example.mycinema.movie.adapter.`in`.dto.request.RegisterMovieRequestDto
import com.example.mycinema.movie.adapter.`in`.dto.response.RegisterMovieResponseDto

interface RegisterMovieUseCase {
    fun registerMovie(requestDto: RegisterMovieRequestDto): RegisterMovieResponseDto
}
