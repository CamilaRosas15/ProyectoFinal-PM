package com.example.proyectofinal.features.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.features.movie.domain.model.MovieModel
import com.example.proyectofinal.features.movie.domain.usecase.FetchPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.proyectofinal.features.movie.data.datasource.MovieLocalDataSource



class PopularMoviesViewModel(
    private val fetchPopularMovies: FetchPopularMoviesUseCase,
    private val localDataSource: MovieLocalDataSource
): ViewModel() {

    sealed class UiState {
        object Loading : UiState()
        data class Success(val movies: List<MovieModel>) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = UiState.Loading
            val result = fetchPopularMovies.invoke()
            result.fold(
                onSuccess = {
                    localDataSource.insertMovies(it) // guardamos en local
                    _state.value = UiState.Success(it)
                },
                onFailure = {
                    _state.value = UiState.Error("error")
                }
            )
        }
    }


    fun likeMovie(movieId: Int, liked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataSource.updateLike(movieId, if (liked) 1 else 0)
        }
    }
}