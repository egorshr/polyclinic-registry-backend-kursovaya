package com.example.di

import auth.TokenConfig
import com.example.data.employee.EmployeeRepo
import com.example.data.employee.EmployeeRepoImpl
import com.example.data.patient.PatientRepo
import com.example.data.patient.PatientRepoImpl
import com.example.data.service.ServiceRepo
import com.example.data.service.ServiceRepoImpl
import com.example.data.user.UserRepo
import com.example.data.user.UserRepoImpl
import io.ktor.server.application.Application
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun appModule(application: Application) = listOf(
    provideRepositoryModule,
//    provideTokenServiceModule,
//    provideHashingService,
    provideTokenConfigModule(application)
)


val provideRepositoryModule = module {
    singleOf(::UserRepoImpl) { bind<UserRepo>() }
    singleOf(::ServiceRepoImpl) { bind<ServiceRepo>() }
    singleOf(::EmployeeRepoImpl) { bind<EmployeeRepo>() }
    singleOf(::PatientRepoImpl) { bind<PatientRepo>() }
}

//val provideTokenServiceModule = module {
//    singleOf(::JwtTokenService) { bind<TokenService>() }
//}
//
//val provideHashingService = module {
//    singleOf(::SHA256HashingService) { bind<HashingService>() }
//}


fun provideTokenConfigModule(application: Application) = module {
    single {
        TokenConfig(
            issuer = application.environment.config.property("jwt.issuer").getString(),
            audience = application.environment.config.property("jwt.audience").getString(),
            expiresIn = 365L * 1000L * 60L * 60L * 24L,
            secret = System.getenv("JWT_SECRET")
        )
    }
}



