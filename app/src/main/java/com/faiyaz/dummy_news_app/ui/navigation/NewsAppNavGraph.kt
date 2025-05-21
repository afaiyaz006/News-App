package com.faiyaz.dummy_news_app.ui.navigation

import NewsUIViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faiyaz.dummy_news_app.ui.Favourites.FavouritesUI
import com.faiyaz.dummy_news_app.ui.NewsSearch.NewsSearchUI
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsUI


enum class NewsAppRoute(val route: String) {
    HOME("home"),
    SEARCH("search"),
    Favourite("favourites")
}
@Composable
fun NewsAppNavGraph(
    navController: NavHostController,
    newsUiViewModel: NewsUIViewModel
) {
    NavHost(navController = navController, startDestination = NewsAppRoute.HOME.route) {

        composable(NewsAppRoute.HOME.route) { NewsUI(newsUiViewModel) }
        composable(NewsAppRoute.SEARCH.route) { NewsSearchUI() }
        composable(NewsAppRoute.Favourite.route) { FavouritesUI() }
    }
}