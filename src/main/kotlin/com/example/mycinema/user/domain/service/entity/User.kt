package com.example.mycinema.user.domain.service.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Builder

@Builder
@Table(name = "users")
@Entity
class User(
    name: String,
    email: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column
    var name: String = name
    protected set

    @Column
    var email: String = email
    protected set
}
