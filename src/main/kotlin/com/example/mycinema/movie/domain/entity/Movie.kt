package com.example.mycinema.movie.domain.entity

import com.example.mycinema.movie.domain.enums.MovieStatus
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Table(name = "movies")
@Entity
class Movie(
    val movieName: String,
    val directorName: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    protected set

    val releaseDate: LocalDate = LocalDate.now()

    var movieStatus: MovieStatus = MovieStatus.RUNNING
    protected set

}
