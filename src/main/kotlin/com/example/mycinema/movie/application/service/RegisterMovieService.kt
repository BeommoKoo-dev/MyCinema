package com.example.mycinema.movie.application.service

import com.example.mycinema.movie.adapter.`in`.dto.request.RegisterMovieRequestDto
import com.example.mycinema.movie.adapter.`in`.dto.response.RegisterMovieResponseDto
import com.example.mycinema.movie.application.port.`in`.RegisterMovieUseCase
import com.example.mycinema.movie.application.port.out.RegisterMoviePort
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Transactional
@RequiredArgsConstructor
@Service
class RegisterMovieService(
    private val registerMoviePort: RegisterMoviePort
): RegisterMovieUseCase {

    override fun registerMovie(requestDto: RegisterMovieRequestDto): RegisterMovieResponseDto {
        val movie = requestDto.toEntity()
        registerMoviePort.save(movie)

        return RegisterMovieResponseDto(movie.movieName)
    }

}
