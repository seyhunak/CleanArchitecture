package com.erikschouten.cleanarchitecture.server

import com.erikschouten.cleanarchitecture.domain.entity.user.Authorities
import com.erikschouten.cleanarchitecture.domain.entity.user.Email
import com.erikschouten.cleanarchitecture.usecases.model.UserModel
import io.ktor.auth.*
import java.util.*

class UserPrincipal private constructor(
    private val id: Int,
    private val email: Email,
    private val authorities: List<Authorities>,
) : Principal {
    constructor(user: UserModel) : this(user.id, user.email, user.authorities)

    fun toUserModel() = UserModel(id, email, authorities)
}
