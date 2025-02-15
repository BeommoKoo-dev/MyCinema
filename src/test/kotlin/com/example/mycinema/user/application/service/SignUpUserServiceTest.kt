package com.example.mycinema.user.application.service

import com.example.mycinema.user.adapter.`in`.dto.request.SignUpUserRequestDto
import com.example.mycinema.user.application.port.out.SingUpUserPort
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat

internal class SignUpUserServiceTest: BehaviorSpec({

    val signUpUserPort = mockk<SingUpUserPort>()

    val signUpUserService = SignUpUserService(signUpUserPort)

    Given("사용자는") {
        And("회원가입을 할 때") {
            val requestDto = SignUpUserRequestDto("rnqjaah1234@gmail.com", "구범모")
            val user = requestDto.toEntity()
            every { signUpUserPort.existsByEmail(any()) } returns false
            every { signUpUserPort.save(any()) } returns user

            When("빈칸이 아닌 이름을 입력하면") {
                val responseDto = signUpUserService.signUp(requestDto)
                Then("회원가입에 성공하여 Response Dto를 반환한다") {
                    assertThat(requestDto).usingRecursiveComparison()
                        .isEqualTo(responseDto)
                }
            }
        }

        And("회원가입을 할 때") {
            val alreadyExistsEmailDto = SignUpUserRequestDto("rnqjaah1234@gmail.com", "구범모")
            every { signUpUserPort.existsByEmail(any()) } returns true
            When("이미 존재하는 이메일이면") {
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        signUpUserService.signUp(alreadyExistsEmailDto)
                    }
                }
            }
        }

        And("회원가입을 할 때") {
            val blankNameDto = SignUpUserRequestDto("", "구범모")
            When("빈칸인 이름을 입력하면") {
                every { signUpUserPort.existsByEmail(any()) } returns false
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        signUpUserService.signUp(blankNameDto)
                    }
                }
            }
        }


        And("회원가입을 할 때") {
            val blankEmailDto = SignUpUserRequestDto("rnqjaah1234@gmail.com", "")
            When("빈칸인 이메일을 입력하면") {
                every { signUpUserPort.existsByEmail(any()) } returns false
                Then("예외가 발생한다") {
                    shouldThrow<RuntimeException> {
                        signUpUserService.signUp(blankEmailDto)
                    }
                }
            }
        }
    }

})
