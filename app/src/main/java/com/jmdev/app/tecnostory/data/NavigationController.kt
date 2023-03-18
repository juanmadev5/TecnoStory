package com.jmdev.app.tecnostory.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jmdev.app.tecnostory.R
import com.jmdev.app.tecnostory.ui.screens.HomeScreen
import com.jmdev.app.tecnostory.ui.screens.StoriesScreen
import com.jmdev.app.tecnostory.ui.screens.Story
import com.jmdev.app.tecnostory.ui.screens.appInfoScreen

@Composable
fun NavHostController(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Home.Route
) {
    /*to navigate in different screens*/
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Home.Route) {
            HomeScreen(
                navController
            )
        }
        composable(Screens.Stories_screen.Route) {
            StoriesScreen(navController)
        }
        composable(Screens.App_info.Route) {
            appInfoScreen()
        }
        composable(Screens.AndroidStory.Route) {
            Story(
                painter = painterResource(R.drawable.android),
                Title = stringResource(R.string.androidTitle),
                SubTitle = stringResource(R.string.androidSubTitle),
                Text = stringResource(R.string.android),
                SubTitle2 = stringResource(R.string.androidSubTitle2),
                Text2 = stringResource(R.string.android2)
            )
        }
        composable(Screens.iosStory.Route) {
            Story(
                painter = painterResource(R.drawable.ios),
                Title = stringResource(R.string.iosTitle),
                SubTitle = stringResource(R.string.iosSubTitle),
                Text = stringResource(R.string.ios),
                SubTitle2 = stringResource(R.string.iosSubTitle2),
                Text2 = stringResource(R.string.ios2)
            )
        }
        composable(Screens.Story3.Route) {

        }
        composable(Screens.Story4.Route) {

        }
        composable(Screens.Story5.Route) {

        }
        composable(Screens.Story6.Route) {

        }
    }
}
/*
* Screen routes
*/
sealed class Screens(val Route: String) {
    object Home : Screens("home")
    object Stories_screen: Screens("stories screen")
    object App_info: Screens("app info")

    //All Histories
    object AndroidStory : Screens("androidStory")
    object iosStory : Screens("pcStory")
    object Story3 : Screens("story 3")
    object Story4 : Screens("story 4")
    object Story5 : Screens("story 5")
    object Story6 : Screens("story 6")
}