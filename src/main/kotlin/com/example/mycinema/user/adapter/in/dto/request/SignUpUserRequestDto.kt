package com.example.mycinema.user.adapter.`in`.dto.request

import com.example.mycinema.user.domain.entity.User
import com.example.mycinema.user.domain.enums.UserStatus

data class SignUpUserRequestDto(
    val name: String,
    val email: String
) {
    fun toEntity(): User {
        return User(
            name = name,
            email = email,
            userStatus = UserStatus.AVAILABLE
        )
    }
}
