@file:OptIn(ExperimentalMaterial3Api::class)

package com.jmdev.app.tecnostory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jmdev.app.tecnostory.R
import com.jmdev.app.tecnostory.data.Screens
import com.jmdev.app.tecnostory.ui.components.CardContent
import com.jmdev.app.tecnostory.ui.components.Menu
import com.jmdev.app.tecnostory.ui.theme.dimensions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {
    ConstraintLayout(
        Modifier
            .wrapContentSize()
            .verticalScroll(rememberScrollState())
    ) {

        val (
            topTitle,
            description,
            card,
            featuredContentIcon,
            featuredDescription,
            more
        ) = createRefs()

        Menu(navController)
        Text(
            stringResource(R.string.app_name),
            Modifier
                .constrainAs(topTitle) {
                    top.linkTo(parent.top, margin = 140.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                },
            fontSize = dimensions.topTitle,
            fontWeight = FontWeight.Light
        )
        Text(
            stringResource(R.string.description),
            Modifier.constrainAs(description) {
                top.linkTo(topTitle.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 20.dp)
            },
            fontSize = dimensions.description,
            fontWeight = FontWeight.Light
        )
        Icon(
            Icons.Rounded.AutoAwesome,
            "",
            Modifier
                .constrainAs(featuredContentIcon) {
                    top.linkTo(description.bottom, margin = 55.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
                .size(dimensions.iconFeatured)
        )
        Text(
            stringResource(R.string.featuredContent),
            Modifier.constrainAs(featuredDescription) {
                start.linkTo(featuredContentIcon.end, margin = 15.dp)
                top.linkTo(featuredContentIcon.top)
                bottom.linkTo(featuredContentIcon.bottom)
            },
            fontSize = dimensions.featured,
            fontWeight = FontWeight.Light
        )
        Card(
            Modifier
                .constrainAs(card) {
                    top.linkTo(featuredContentIcon.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
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
        ElevatedButton(
            onClick = {
                navController.navigate(Screens.Stories_screen.Route)
            },
            Modifier
                .constrainAs(more) {
                    start.linkTo(parent.start, margin = 20.dp)
                    top.linkTo(card.bottom, margin = 30.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                }
                .height(60.dp),
            elevation = ButtonDefaults.buttonElevation(8.dp)
        ) {
            Icon(imageVector = Icons.Filled.LibraryBooks, "")
            Spacer(Modifier.padding(4.dp))
            Text(stringResource(R.string.allStories))
        }
    }
}