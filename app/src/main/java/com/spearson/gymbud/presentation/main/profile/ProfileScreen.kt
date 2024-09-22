package com.spearson.gymbud.presentation.main.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spearson.gymbud.R


@Composable
fun ProfileScreen(
    logout: () -> Unit
){
   Column(modifier = Modifier
       .fillMaxSize()
       .padding(16.dp))
   {
       Box(modifier = Modifier.fillMaxWidth()){
           Image(
               painter = painterResource(id = R.drawable.ic_launcher_foreground),
               contentDescription = "User Profile Image",
               modifier = Modifier
                   .align(Alignment.Center)
                   .clip(CircleShape)
                   .shadow(4.dp)
           )

           IconButton(
               modifier = Modifier
                   .align(Alignment.TopEnd),
               onClick = { /* TODO */ }
           ) {
               Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Add a Session", tint = Color.Red)
           }
       }
       Spacer(Modifier.height(4.dp))
       Text("User", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 22.sp)
       Spacer(Modifier.height(4.dp))

       Column(modifier = Modifier.fillMaxWidth().padding(18.dp)) {
           Box(modifier = Modifier.fillMaxWidth()){
               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterStart)){
                    Text("card",modifier= Modifier.align(Alignment.CenterHorizontally))
               }

               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterEnd)){
                   Text("card",modifier= Modifier.align(Alignment.CenterHorizontally))
               }
           }
           Spacer(Modifier.height(8.dp))
           Box(modifier = Modifier.fillMaxWidth()){
               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterStart)){
                   Text("card", modifier= Modifier.align(Alignment.CenterHorizontally))
               }
               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterEnd)){
                   Text("card",modifier= Modifier.align(Alignment.CenterHorizontally))
               }
           }
           Spacer(Modifier.height(8.dp))
           Box(modifier = Modifier.fillMaxWidth()){
               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterStart)){
                   Text("card", modifier= Modifier.align(Alignment.CenterHorizontally))
               }
               Card(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterEnd)){
                   Text("card",modifier= Modifier.align(Alignment.CenterHorizontally))
               }
           }
       }
   }
}
