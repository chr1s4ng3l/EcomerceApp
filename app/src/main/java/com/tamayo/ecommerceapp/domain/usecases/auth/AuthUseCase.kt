package com.tamayo.ecommerceapp.domain.usecases.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase,
    val updateSessionUseCase: UpdateSessionUseCase
)
