package com.example.mycinema.user.adapter.`in`.dto.response

import com.example.mycinema.user.domain.entity.User

data class SignUpUserResponseDto(
    val name: String,
    val email: String
) {
    companion object {
        fun from(user: User): SignUpUserResponseDto {
            return SignUpUserResponseDto(
                name = user.name,
                email = user.email
            )
        }
    }
}
