package com.example.proyectofinal.di

import com.example.proyectofinal.features.github.data.repository.GithubRepository
import com.example.proyectofinal.features.github.domain.repository.IGithubRepository
import com.example.proyectofinal.features.github.domain.usecase.FindByNickNameUseCase
import com.example.proyectofinal.features.github.presentation.GithubViewModel
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


}