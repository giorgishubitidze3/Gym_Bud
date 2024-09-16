package com.spearson.gymbud.presentation.workouts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spearson.gymbud.domain.repository.ExerciseRepository
import com.spearson.gymbud.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutsViewModel @Inject constructor(
    private val repository: ExerciseRepository
) : ViewModel()
{

    var state by mutableStateOf(WorkoutsState())

    private var searchJob: Job? = null

    fun onEvent(event: WorkoutsEvent){
        when(event){
            is WorkoutsEvent.OnSearchQueryChange ->{
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch{
                    delay(500L)
                    getWorkoutListings()
                }
            }
        }
    }


    private fun getWorkoutListings(
        query:String = state.searchQuery.lowercase()
    ){
        viewModelScope.launch{
            repository
                .getExercises()
                .collect{result ->
                    when(result){
                        is Resource.Success ->{
                            result.data?.let{listings ->
                                state = state.copy(
                                    workouts = listings
                                )
                            }
                        }
                        is Resource.Error -> Unit

                        is Resource.Loading ->{
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}