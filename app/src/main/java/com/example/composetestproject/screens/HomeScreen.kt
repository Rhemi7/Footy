package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color(0xff181829),
        topBar = {
            SportyAppBar(title = "LiveScore", navController = navController)
        }
    ) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(horizontal = 10.dp)) {

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

@Composable
fun SportyAppBar(title: String,
                 icon: ImageVector? = null,
//                 showProfile: Boolean = true,
                 navController: NavController,
                 onBackArrowClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.padding(top = 40.dp), title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
//            if(showProfile) {
//                Icon(
//                    imageVector = Icons.Default.Favorite,
//                    contentDescription = "Logo Icon",
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(12.dp))
//                        .scale(0.9f)
//                )
//            }
                if (icon != null) {
                    Icon(imageVector = icon,
                        contentDescription = "Arrow Back",
                        tint = Color.Red.copy(alpha = 0.7f),
                        modifier = Modifier.clickable { onBackArrowClick.invoke() })

                }
                if (icon != null) {
                    Spacer(modifier = Modifier.width(40.dp))
                }
                Text(
                    text = title,
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 23.sp)
                )
//                          Spacer(modifier = Modifier.width(150.dp))
            }
        },
        actions = {
            if (icon == null) {
                Row() {
                    IconButton(
                        modifier = Modifier.padding(3.dp),
                        onClick = {
//                FirebaseAuth.getInstance().signOut().run {
//                    navController.navigate(ReaderScreens.LoginScreen.name)
//                }
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )

                    }
                    IconButton(
                        modifier = Modifier.padding(3.dp),
                        onClick = {
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "Notification Icon",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )

                    }
                }
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}