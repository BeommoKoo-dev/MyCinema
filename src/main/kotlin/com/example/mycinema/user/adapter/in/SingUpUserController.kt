package com.example.mycinema.user.adapter.`in`

import com.example.mycinema.user.adapter.`in`.dto.request.SignUpUserRequestDto
import com.example.mycinema.user.adapter.`in`.dto.response.SignUpUserResponseDto
import com.example.mycinema.user.application.port.`in`.SignUpUserUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/users/signup")
@RestController
class SingUpUserController(
    private val signUpUserUseCase: SignUpUserUseCase
) {
    @PostMapping
    fun signUp(@RequestBody requestDto: SignUpUserRequestDto): SignUpUserResponseDto {
        val responseDto = signUpUserUseCase.signUp(requestDto)
        return responseDto
    }
}
