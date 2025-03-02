package com.example.mycinema.cinema.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.Builder

@Builder
@Table(name = "cinemas")
@Entity
class Cinema(
    cinemaNumber: Int
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    protected set

    @Column
    val cinemaNumber = cinemaNumber

    @OneToMany(mappedBy = "cinema", cascade = [CascadeType.ALL], orphanRemoval = true)
    @Column
    val seats: MutableList<Seat> = mutableListOf()

    fun addSeat(seat: Seat) {
        seats.add(seat)
    }

    fun findSeat(seatId: Long): Seat {
        for (seat in seats) {
            if (seat.id == seatId) {
                return seat
            }
        }
        throw RuntimeException("No seat found")
    }

}
