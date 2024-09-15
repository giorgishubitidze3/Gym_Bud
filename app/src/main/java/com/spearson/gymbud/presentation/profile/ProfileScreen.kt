package com.spearson.gymbud.presentation.profile


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileScreen(
){
   Box(modifier = Modifier.fillMaxSize()){
       Text(text = "ProfileScreen", modifier = Modifier.align(Alignment.Center))
   }
}
