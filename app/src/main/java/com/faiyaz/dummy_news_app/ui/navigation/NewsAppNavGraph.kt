package com.faiyaz.dummy_news_app.ui.navigation

import NewsUIViewModel
import ViewAllNewsUI
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faiyaz.dummy_news_app.ui.Favourites.FavouriteNewsViewModel
import com.faiyaz.dummy_news_app.ui.Favourites.FavouritesUI
import com.faiyaz.dummy_news_app.ui.NewsApp
import com.faiyaz.dummy_news_app.ui.NewsDetails.NewsDetailUI
import com.faiyaz.dummy_news_app.ui.NewsSearch.NewsSearchUI
import com.faiyaz.dummy_news_app.ui.NewsSearch.NewsSearchViewModel
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsUI
import com.faiyaz.dummy_news_app.ui.Settings.SettingsUI
import com.faiyaz.dummy_news_app.ui.Settings.SettingsViewModel


enum class NewsAppRoute(val route: String) {
    HOME("home"),
    SEARCH("search"),
    Favourite("favourites"),
    Details("Details"),
    AllNews("All"),
    FeaturedNews("FeaturedNews"),
    Settings("Settings")
}
@Composable
fun NewsAppNavGraph(
    navController: NavHostController,
    newsUiViewModel: NewsUIViewModel,
    newsSearchViewModel: NewsSearchViewModel,
    newsFavViewModel: FavouriteNewsViewModel,
    settingsViewModel: SettingsViewModel
) {
    NavHost(navController = navController, startDestination = NewsAppRoute.HOME.route) {

        composable(NewsAppRoute.HOME.route) {
            NewsUI(
                newsUiViewModel,
                onNewsCardTap = {
                    navController.navigate(NewsAppRoute.Details.route)
                },
                onViewAllClick = {
                    navController.navigate(NewsAppRoute.AllNews.route)
                },
                onFeaturedNewsClick = {
                    navController.navigate(NewsAppRoute.FeaturedNews.route)
                },
                onLikeButtonClicked = {
                    news -> newsFavViewModel.togglelikeNews(news)
                }

            )
        }
        composable(NewsAppRoute.SEARCH.route) {
            NewsSearchUI(
                newsSearchViewModel,
                onSearchItemTapped = {
                    news -> newsUiViewModel.selectNews(news)
                    navController.navigate(NewsAppRoute.Details.route)
                },
                onLikeButtonClicked = {
                        news -> newsFavViewModel.togglelikeNews(news)
                }
            )
        }
        composable(NewsAppRoute.Favourite.route) {
            FavouritesUI(
                newsFavViewModel.getFavouriteNews(),
                onLikeButtonClicked = {
                        news -> newsFavViewModel.togglelikeNews(news)
                }
            )
        }
        composable(NewsAppRoute.Details.route){
            NewsDetailUI(newsUiViewModel)
        }
        composable(NewsAppRoute.AllNews.route){
            ViewAllNewsUI(
                selectedTopic = newsUiViewModel.getCategory(),
                newsList = newsUiViewModel.getCurrentCategoryNews(),
                onNewsCardTap = {
                    news -> newsUiViewModel.selectNews(news)
                    navController.navigate(NewsAppRoute.Details.route)
                },
                onLikeButtonClicked = {
                    news -> newsFavViewModel.togglelikeNews(news)
                }
            )
        }
        composable(NewsAppRoute.FeaturedNews.route){
            ViewAllNewsUI(
                selectedTopic = "Featured",
                newsList = newsUiViewModel.getCurrentTopNews(),
                onNewsCardTap = {
                    news -> newsUiViewModel.selectNews(news)
                    navController.navigate(NewsAppRoute.Details.route)
                },
                onLikeButtonClicked = {
                    news -> newsFavViewModel.togglelikeNews(news)
                }
            )
        }
        composable(NewsAppRoute.Settings.route){
            SettingsUI(settingsViewModel)
        }
    }
}