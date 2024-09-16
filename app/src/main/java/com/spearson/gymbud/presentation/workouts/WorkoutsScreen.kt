package com.spearson.gymbud.presentation.workouts


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun WorkoutsScreen(
    viewModel: WorkoutsViewModel = hiltViewModel()
){
//   Box(modifier = Modifier.fillMaxSize()){
//       Text(text = "WorkoutsScreen", modifier = Modifier.align(Alignment.Center))
//   }

    val state = viewModel.state


    Column(modifier = Modifier.fillMaxSize()) {

        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(WorkoutsEvent.OnSearchQueryChange(it)
                )
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text= "Search...")
            },
            maxLines = 1,
            singleLine = true
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(state.workouts.size){i ->
                val workout = state.workouts[i]
                GymExerciseItem(
                    workout = workout,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                if(i < state.workouts.size){
                    VerticalDivider(modifier= Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}
