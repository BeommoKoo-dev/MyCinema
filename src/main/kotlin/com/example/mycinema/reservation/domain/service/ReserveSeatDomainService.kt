package com.example.mycinema.reservation.domain.service

import com.example.mycinema.cinema.domain.entity.Cinema
import com.example.mycinema.reservation.domain.entity.Reservation
import com.example.mycinema.user.domain.entity.User

class ReserveSeatDomainService {

    fun makeReservation(cinema: Cinema, seatId: Long, user: User): Reservation {
        val seat = cinema.findSeat(seatId)
        if (!seat.isAvailable()) {
            throw RuntimeException("Seat is already reserved")
        }
        if(!user.isAvailable()) {
            throw RuntimeException("User is not common status")
        }
        seat.reserved()

        val reservation = Reservation(user, seat)
        return reservation
    }

}

