package com.example.mycinema.infrastructure.persistence

import com.example.mycinema.movie.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository: JpaRepository<Movie, Long> {
}
