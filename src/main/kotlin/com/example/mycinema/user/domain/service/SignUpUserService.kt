package com.example.mycinema.user.domain.service

import com.example.mycinema.user.adapter.`in`.dto.request.SignUpUserRequestDto
import com.example.mycinema.user.adapter.`in`.dto.response.SignUpUserResponseDto
import com.example.mycinema.user.application.port.`in`.SignUpUserUseCase
import com.example.mycinema.user.application.port.out.SingUpUserPort
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
@Transactional
class SignUpUserService(
    private val signUpUserPort: SingUpUserPort
): SignUpUserUseCase {

    override fun signUp(signUpUserRequestDto: SignUpUserRequestDto): SignUpUserResponseDto {
        if(signUpUserPort.existsByEmail(signUpUserRequestDto.email)) {
            throw RuntimeException("Email already exists.")
        }
        if(signUpUserRequestDto.name.isBlank()) {
            throw RuntimeException("Name Must not be blank.")
        }
        if(signUpUserRequestDto.email.isBlank()) {
            throw RuntimeException("Email Must not be blank.")
        }

        val user = signUpUserRequestDto.toEntity()
        val savedUser = signUpUserPort.save(user)

        return SignUpUserResponseDto.from(savedUser)
    }

}
