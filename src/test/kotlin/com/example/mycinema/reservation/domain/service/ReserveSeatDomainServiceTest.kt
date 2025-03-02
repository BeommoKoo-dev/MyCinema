package com.example.mycinema.reservation.domain.service

import com.example.mycinema.cinema.domain.entity.Cinema
import com.example.mycinema.cinema.domain.entity.Seat
import com.example.mycinema.user.domain.entity.User
import com.example.mycinema.user.domain.enums.UserStatus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll

internal class ReserveSeatDomainServiceTest: BehaviorSpec({
    val reserveSeatDomainService = ReserveSeatDomainService()

    Given("좌석을 예매할 때") {
        And("예약되지 않은 좌석과 정상 상태인 유저가") {

            val cinema = Cinema(1)
            val seat = Seat(cinema)
            val user = User("구범모", "123512@gmail.com", UserStatus.AVAILABLE)

            setSeatIdForTest(seat, 1)

            When(" 예매를 요청하면") {
                val reservation = reserveSeatDomainService.makeReservation(cinema, 1, user)
                Then("예매에 성공한다") {
                    assertAll(
                        { assertThat(reservation.seat.id).isEqualTo(1) },
                        { assertThat(user.name).isEqualTo("구범모") },
                        { assertThat(reservation.seat.isAvailable()).isFalse() }
                    )
                }
            }
        }
        And("유저가") {

            val cinema = Cinema(1)
            val seat = Seat(cinema)
            val user = User("구범모", "123512@gmail.com", UserStatus.INACTIVATED)

            setSeatIdForTest(seat, 1)

            When("정상 상태가 아니라면") {
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        reserveSeatDomainService.makeReservation(cinema, 1, user)
                    }
                }
            }
        }
        And("좌석이") {

            val cinema = Cinema(1)
            val seat = Seat(cinema)
            val user = User("구범모", "123512@gmail.com", UserStatus.INACTIVATED)

            setSeatIdForTest(seat, 1)
            seat.reserved()

            When("예약된 상태라면") {
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        reserveSeatDomainService.makeReservation(cinema, 1, user)
                    }
                }
            }
        }
    }


}) {

    companion object {
        fun setSeatIdForTest(seat: Seat, id: Long) {
            val field = Seat::class.java.getDeclaredField("id")
            field.isAccessible = true
            field.set(seat, id)
        }
    }

}
