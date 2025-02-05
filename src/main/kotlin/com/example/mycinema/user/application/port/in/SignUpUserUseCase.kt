package com.example.mycinema.user.application.port.`in`

import com.example.mycinema.user.adapter.`in`.dto.request.SignUpUserRequestDto
import com.example.mycinema.user.adapter.`in`.dto.response.SignUpUserResponseDto

interface SignUpUserUseCase {
    fun signUp(signUpUserRequestDto: SignUpUserRequestDto): SignUpUserResponseDto
}
