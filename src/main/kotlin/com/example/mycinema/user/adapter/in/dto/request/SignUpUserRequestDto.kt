package com.example.mycinema.user.adapter.`in`.dto.request

import com.example.mycinema.user.domain.entity.User

data class SignUpUserRequestDto(
    val name: String,
    val email: String
) {
    fun toEntity(): User {
        return User(
            name = name,
            email = email
        )
    }
}
