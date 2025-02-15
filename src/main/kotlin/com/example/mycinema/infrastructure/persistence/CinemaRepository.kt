package com.example.mycinema.infrastructure.persistence

import com.example.mycinema.cinema.domain.entity.Cinema
import org.springframework.data.jpa.repository.JpaRepository

interface CinemaRepository: JpaRepository<Cinema, Long> {
}
