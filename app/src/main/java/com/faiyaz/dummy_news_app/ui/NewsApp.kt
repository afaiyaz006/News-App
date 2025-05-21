package com.faiyaz.dummy_news_app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsUI
import com.faiyaz.dummy_news_app.ui.theme.NewsAppTheme
@Preview
@Composable
fun NewsApp(){
    NewsAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {BottomNavigation()},
            topBar = {TopNavigation()}
        ) { innerPadding ->
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                NewsScreen()
            }
        }
    }

}
@Composable
fun NewsScreen(modifier: Modifier=Modifier){
    NewsUI()
}

@Composable
fun BottomNavigation() {
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                IconButton(

                    onClick = { /* do something */ }
                ) {
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(32.dp),

                    )
                }
                IconButton(
                    onClick = { /* do something */ }
                ) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "Localized description" ,
                        modifier = Modifier.size(32.dp),
                    )
                }
                IconButton(

                    onClick = { /* do something */ }
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(32.dp),
                    )
                }
//                IconButton(
//
//                    onClick = { /* do something */ }
//                ) {
//                    Icon(
//                        Icons.Outlined.Person,
//                        contentDescription = "Localized description",
//                        modifier = Modifier.size(32.dp),
//                    )
//                }
            }


        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { /* do something */ },
//                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
//                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
//            ) {
//                Icon(Icons.Filled.Add, "Localized description")
//            }
//        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigation(){
    CenterAlignedTopAppBar(
        title = {
            Text("Dummy News App", maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Localized description"
                )
            }
        }
    )

}
