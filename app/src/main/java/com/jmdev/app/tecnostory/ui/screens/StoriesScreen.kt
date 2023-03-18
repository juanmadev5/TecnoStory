@file:OptIn(ExperimentalMaterial3Api::class)

package com.jmdev.app.tecnostory.ui.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jmdev.app.tecnostory.R
import com.jmdev.app.tecnostory.data.Screens
import com.jmdev.app.tecnostory.ui.components.CardContent
import com.jmdev.app.tecnostory.ui.theme.dimensions

@Composable
fun StoriesScreen(navController: NavController) {
    ConstraintLayout(
        Modifier
            .verticalScroll(rememberScrollState())
            .clip(shape = RoundedCornerShape(30.dp))) {

        val (card1, card2, card3, TopTitle) = createRefs()

        Text(
            stringResource(R.string.allStories),
            Modifier
                .constrainAs(TopTitle) {
                    top.linkTo(parent.top, 50.dp)
                    start.linkTo(parent.start, 20.dp)
                }
                .height(110.dp),
            fontSize = dimensions.storyTitle,
            fontWeight = FontWeight.Light,
            lineHeight = 42.sp
        )
        Card(
            Modifier
                .constrainAs(card1) {
                    top.linkTo(TopTitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(card2.top, 10.dp)
                }
                .height(dimensions.cardHeight)
                .width(dimensions.cardWidth),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            CardContent(
                painterResource = R.drawable.android,
                stringResource = R.string.featuredContentDescription1,
                navController,
                destination = Screens.AndroidStory.Route
            )
        }
        Card(
            Modifier
                .constrainAs(card2) {
                    top.linkTo(card1.bottom, 20.dp)
                    start.linkTo(card1.start)
                    end.linkTo(card1.end)
                    bottom.linkTo(card3.top, 10.dp)
                }
                .height(dimensions.cardHeight)
                .width(dimensions.cardWidth),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            CardContent(
                painterResource = R.drawable.ios,
                stringResource = R.string.featuredContentDescription2,
                navController,
                destination = Screens.iosStory.Route
            )
        }
        Card(
            Modifier
                .constrainAs(card3) {
                    top.linkTo(card2.bottom, 20.dp)
                    start.linkTo(card2.start)
                    end.linkTo(card2.end)
                    bottom.linkTo(parent.bottom, 20.dp)
                }
                .height(dimensions.cardHeight)
                .width(dimensions.cardWidth),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            CardContent(
                painterResource = R.drawable.jetpackcompose,
                stringResource = R.string.card,
                navController,
                destination = Screens.App_info.Route
            )
        }

    }
}
