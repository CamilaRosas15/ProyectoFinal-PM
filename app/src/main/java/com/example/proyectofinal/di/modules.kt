package com.example.proyectofinal.di

import com.example.proyectofinal.features.auth.data.repository.AuthRepository
import com.example.proyectofinal.features.auth.domain.repository.IAuthRepository
import com.example.proyectofinal.features.auth.domain.usecase.AuthUseCase
import com.example.proyectofinal.features.auth.presentation.login.AuthViewModel
import com.example.proyectofinal.features.dollar.data.database.AppRoomDatabase
import com.example.proyectofinal.features.dollar.data.datasource.DollarLocalDataSource
import com.example.proyectofinal.features.dollar.data.repository.DollarRepository
import com.example.proyectofinal.features.dollar.data.datasource.RealTimeRemoteDataSource
import com.example.proyectofinal.features.dollar.domain.repository.IDollarRepository
import com.example.proyectofinal.features.dollar.domain.usecase.FetchDollarUseCase
import com.example.proyectofinal.features.dollar.presentarion.DollarViewModel
import com.example.proyectofinal.features.github.data.repository.GithubRepository
import com.example.proyectofinal.features.github.domain.repository.IGithubRepository
import com.example.proyectofinal.features.github.domain.usecase.FindByNickNameUseCase
import com.example.proyectofinal.features.github.presentation.GithubViewModel
import com.example.proyectofinal.features.notification.presentation.NotificationViewModel
import com.example.proyectofinal.features.profile.application.ProfileViewModel
import com.example.proyectofinal.features.profile.data.repository.ProfileRepository
import com.example.proyectofinal.features.profile.domain.repository.IProfileRepository
import com.example.proyectofinal.features.profile.domain.usecase.GetProfileUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<IGithubRepository>{ GithubRepository() }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get()) }

    viewModel { ProfileViewModel(get()) }
    factory { GetProfileUseCase(get()) }
    single<IProfileRepository> { ProfileRepository() }

    single<IAuthRepository> { AuthRepository() }
    factory { AuthUseCase(get()) }
    viewModel { AuthViewModel(get()) }


    single{RealTimeRemoteDataSource()}
    single { AppRoomDatabase.getDatabase(get()) }
    single { get<AppRoomDatabase>().dollarDao() }
    single { DollarLocalDataSource(get()) }
    single<IDollarRepository> { DollarRepository(get(), get()) }

    //single<IDollarRepository> { DollarRepository(get()) }
    factory { FetchDollarUseCase(get()) }
    viewModel{ DollarViewModel(get()) }

    viewModel { NotificationViewModel() }
}