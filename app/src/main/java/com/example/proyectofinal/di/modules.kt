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
import com.example.proyectofinal.features.github.data.api.GithubService
import com.example.proyectofinal.features.github.data.datasource.GithubRemoteDataSource
import com.example.proyectofinal.features.github.data.repository.GithubRepository
import com.example.proyectofinal.features.github.domain.repository.IGithubRepository
import com.example.proyectofinal.features.github.domain.usecase.FindByNickNameUseCase
import com.example.proyectofinal.features.github.presentation.GithubViewModel
import com.example.proyectofinal.features.movie.data.api.MovieService
import com.example.proyectofinal.features.movie.data.datasource.MovieRemoteDataSource
import com.example.proyectofinal.features.movie.data.repository.MovieRepository
import com.example.proyectofinal.features.movie.domain.repository.IMoviesRepository
import com.example.proyectofinal.features.movie.domain.usecase.FetchPopularMoviesUseCase
import com.example.proyectofinal.features.movie.presentation.PopularMoviesViewModel
import com.example.proyectofinal.features.notification.presentation.NotificationViewModel
import com.example.proyectofinal.features.profile.application.ProfileViewModel
import com.example.proyectofinal.features.profile.data.repository.ProfileRepository
import com.example.proyectofinal.features.profile.domain.repository.IProfileRepository
import com.example.proyectofinal.features.profile.domain.usecase.GetProfileUseCase
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetworkConstants {
    const val RETROFIT_GITHUB = "RetrofitGithub"
    const val GITHUB_BASE_URL = "https://api.github.com/"
    const val RETROFIT_MOVIE = "RetrofitMovie"
    const val MOVIE_BASE_URL = "https://api.themoviedb.org/"
}

val appModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // Retrofit
    single(named(NetworkConstants.RETROFIT_GITHUB)) {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.GITHUB_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named(NetworkConstants.RETROFIT_MOVIE)) {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.MOVIE_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<GithubService> {
        get<Retrofit>( named(NetworkConstants.RETROFIT_GITHUB)).create(GithubService::class.java)
    }
    single{ GithubRemoteDataSource(get()) }
    single<IGithubRepository>{ GithubRepository(get()) }

    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get(), get()) }


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

    single(named("apiKey")) { androidApplication().getString(com.example.proyectofinal.R.string.api_key) }

    single<MovieService> {
        get<Retrofit>(named(NetworkConstants.RETROFIT_MOVIE)).create(MovieService::class.java)
    }

    single { MovieRemoteDataSource(get(), get(named("apiKey"))) }
    single<IMoviesRepository> { MovieRepository(get()) }
    factory { FetchPopularMoviesUseCase(get()) }
    viewModel{ PopularMoviesViewModel(get()) }
}