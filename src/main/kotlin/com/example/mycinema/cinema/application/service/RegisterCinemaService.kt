package com.example.mycinema.cinema.application.service

import com.example.mycinema.cinema.adapter.`in`.dto.request.RegisterCinemaRequestDto
import com.example.mycinema.cinema.adapter.`in`.dto.response.RegisterCinemaResponseDto
import com.example.mycinema.cinema.application.port.`in`.RegisterCinemaUseCase
import com.example.mycinema.cinema.application.port.out.RegisterCinemaPort
import com.example.mycinema.cinema.domain.entity.Cinema
import com.example.mycinema.cinema.domain.entity.Seat

class RegisterCinemaService(
    private val registerCinemaPort: RegisterCinemaPort
): RegisterCinemaUseCase {

    override fun registerCinema(requestDto: RegisterCinemaRequestDto): RegisterCinemaResponseDto {
        if (requestDto.seatCount <= 0) {
            throw RuntimeException("SeatCount must be over zero")
        }

        val cinema = Cinema(requestDto.cinemaNumber)
        for (i: Int in 1..requestDto.seatCount) {
            val seat = Seat(cinema)
            cinema.addSeat(seat)
        }
        registerCinemaPort.register(cinema)

        return RegisterCinemaResponseDto(cinema.cinemaNumber, cinema.seats.size)
    }

}
