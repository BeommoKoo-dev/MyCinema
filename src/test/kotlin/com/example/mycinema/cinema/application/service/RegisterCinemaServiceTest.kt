package com.example.mycinema.cinema.application.service

import com.example.mycinema.cinema.adapter.`in`.dto.request.RegisterCinemaRequestDto
import com.example.mycinema.cinema.application.port.out.RegisterCinemaPort
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat

internal class RegisterCinemaServiceTest: BehaviorSpec({

    val registerCinemaPort = mockk<RegisterCinemaPort>()

    val registerCinemaService = RegisterCinemaService(registerCinemaPort)

    Given("상영관을") {
        And("등록할 때") {
            val cinemaNumber = 1
            val requestDto = RegisterCinemaRequestDto(cinemaNumber, 5)
            every { registerCinemaPort.register(any()) } just Runs
            When("1개 이상의 좌석을 요청하면") {
                val responseDto = registerCinemaService.registerCinema(requestDto)

                Then("정상적으로 상영관이 등록된다") {
                    assertThat(responseDto).usingRecursiveComparison()
                        .isEqualTo(requestDto)
                }
            }
            When("1개 미만의 좌석을 요청하면") {
                val registerCinemaRequestDto = RegisterCinemaRequestDto(1, 0)
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        registerCinemaService.registerCinema(registerCinemaRequestDto)
                    }
                }
            }
        }
    }

})
