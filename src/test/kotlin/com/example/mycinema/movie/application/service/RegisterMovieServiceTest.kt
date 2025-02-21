package com.example.mycinema.movie.application.service

import com.example.mycinema.movie.adapter.`in`.dto.request.RegisterMovieRequestDto
import com.example.mycinema.movie.application.port.out.RegisterMoviePort
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.assertj.core.api.Assertions

internal class RegisterMovieServiceTest: BehaviorSpec({

    val registerMoviePort = mockk<RegisterMoviePort>()

    val registerMovieService = RegisterMovieService(registerMoviePort)

    Given("영화를") {
        And("등록할 때") {
            val movieName = "Moviemovie"
            val directorName = "Mr.Koo"
            val requestDto = RegisterMovieRequestDto(movieName, directorName)
            every { registerMoviePort.save(any()) } just Runs
            When("영화의 이름과 감독명을 전달하면") {
                val responseDto = registerMovieService.registerMovie(requestDto)

                Then("정상적으로 영화가 등록된다") {
                    Assertions.assertThat(responseDto.movieName).
                            isEqualTo("Moviemovie")
                }
            }
        }
    }

})
