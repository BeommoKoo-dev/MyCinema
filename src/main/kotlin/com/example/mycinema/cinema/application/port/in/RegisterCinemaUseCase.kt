package com.example.mycinema.cinema.application.port.`in`

import com.example.mycinema.cinema.adapter.`in`.dto.request.RegisterCinemaRequestDto
import com.example.mycinema.cinema.adapter.`in`.dto.response.RegisterCinemaResponseDto

interface RegisterCinemaUseCase {

    fun registerCinema(requestDto: RegisterCinemaRequestDto): RegisterCinemaResponseDto

}
