package com.example.mycinema.reservation.domain.entity

import com.example.mycinema.cinema.domain.entity.Seat
import com.example.mycinema.user.domain.entity.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "reservations")
@Entity
class Reservation(
    @JoinColumn(name = "id")
    @ManyToOne
    val user: User,

    @JoinColumn(name = "id")
    @ManyToOne
    val seat: Seat
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        protected set

}
