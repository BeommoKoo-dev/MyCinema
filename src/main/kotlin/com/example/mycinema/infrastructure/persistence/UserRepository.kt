package com.example.mycinema.infrastructure.persistence

import com.example.mycinema.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsUserByEmail(email: String): Boolean

}
