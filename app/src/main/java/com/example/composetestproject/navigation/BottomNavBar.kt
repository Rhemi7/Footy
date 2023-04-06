package com.example.composetestproject.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composetestproject.R


@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Standings,
        BottomNavItem.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarDestination = items.any { it.screen_route == currentRoute }
   if (bottomBarDestination) {
       BottomNavigation(
           backgroundColor = colorResource(id = R.color.sub_background),
           contentColor = Color.Black, modifier = Modifier.height(80.dp)
       ) {

           items.forEach { item ->
               BottomNavigationItem(
                   icon =  {
                       if (currentRoute == item.screen_route) {
                           Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                               modifier = Modifier.padding(vertical = 15.dp)) {
                               Text(
                                   text = item.title + "\n.",
                                   color = colorResource(id = R.color.nav_bar_blue),
                                   textAlign = TextAlign.Center,
                                   fontWeight = FontWeight.ExtraBold,
                                   fontSize = 18.sp
                               )
//                                fontSize = 30.sp)
//                            Spacer(modifier = Modifier.height(2.dp))
//                            Text(
//                                text = ".",
//                                color = colorResource(id = R.color.nav_bar_blue),
//                                fontWeight = FontWeight.ExtraBold,
//                                fontSize = 30.sp
//                            )
                           }
                       } else {
                           Icon(painterResource(id = item.icon),
                               contentDescription = item.title,
                               tint = colorResource(
                                   id = R.color.text_color
                               ), modifier = Modifier.size(30.dp)) }
                   },
//                label = { Text(text = item.title,
//                    fontSize = 9.sp) },
                   selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
                   alwaysShowLabel = false,
                   selected = currentRoute == item.screen_route,
                   onClick = {
                       navController.navigate(item.screen_route) {

                           navController.graph.startDestinationRoute?.let { screen_route ->
                               popUpTo(screen_route) {
                                   saveState = true
                               }
                           }
                           launchSingleTop = true
                           restoreState = true
                       }
                   }
               )
           }
       }
   }
}
//@Composable
// fun currentRoute(navController: NavHostController): String? {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
//}