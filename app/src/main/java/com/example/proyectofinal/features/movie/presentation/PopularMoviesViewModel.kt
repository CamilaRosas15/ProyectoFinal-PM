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
) : ViewModel() {


    sealed class UiState {
        object Loading : UiState()
        data class Success(val movies: List<MovieModel>) : UiState()
        data class Error(val message: String) : UiState()
    }

    // El StateFlow privado que contendrá el estado actual
    private val _state = MutableStateFlow<UiState>(UiState.Loading)

    // La versión pública y de solo lectura del StateFlow que la UI observará
    val state: StateFlow<UiState> = _state.asStateFlow()

    // Inicializamos la carga de películas cuando se crea el ViewModel
    init {
        fetchPopularMovies()
    }


    fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = UiState.Loading
            // Invocamos el caso de uso para obtener las películas
            fetchPopularMovies.invoke().fold(
                onSuccess = { remoteMovies ->

                    localDataSource.insertMovies(remoteMovies)

                    val localMovies = localDataSource.getList()

                    // ¡Emitimos la lista LOCAL, no la remota!
                    _state.value = UiState.Success(localMovies)
                },
                onFailure = { throwable ->

                    val localMovies = localDataSource.getList()
                    if (localMovies.isNotEmpty()) {
                        _state.value = UiState.Success(localMovies)
                    } else {
                        _state.value = UiState.Error(throwable.message ?: "Ocurrió un error desconocido")
                    }
                }
            )
        }
    }

    fun likeMovie(movieId: Int, liked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {

            localDataSource.updateLike(movieId, if (liked) 1 else 0)

            val updatedMovies = localDataSource.getList()

            _state.value = UiState.Success(updatedMovies)
        }
    }
}