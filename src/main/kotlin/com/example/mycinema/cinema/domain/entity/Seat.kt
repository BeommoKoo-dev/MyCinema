package com.example.mycinema.cinema.domain.entity

import com.example.mycinema.cinema.domain.enums.SeatStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "seats")
@Entity
class Seat(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    val cinema: Cinema,

    @Enumerated(EnumType.STRING)
    var status: SeatStatus = SeatStatus.AVAILABLE
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    protected set

    val row: Int

    val column: Int

    init {
        this.row = cinema.seats.size % 10 + 1
        this.column = cinema.seats.size / 10 + 1
        cinema.addSeat(this)
    }

    fun isAvailable(): Boolean {
        return status.equals(SeatStatus.AVAILABLE)
    }

    fun reserved() {
        this.status = SeatStatus.RESERVED
    }
}
