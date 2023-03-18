package com.jmdev.app.tecnostory.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jmdev.app.tecnostory.ui.theme.dimensions

@Composable
fun Story(
    painter: Painter,
    Title: String,
    SubTitle: String,
    Text: String,
    SubTitle2: String,
    Text2: String
) {
    ConstraintLayout(
        Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val (topImage, title, text) = createRefs()

        Image(
            painter, "",
            Modifier
                .constrainAs(topImage) {
                    top.linkTo(parent.top, 0.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(title.top)
                }
                .height(dimensions.onStoryImageHeight)
                .fillMaxWidth()
        )
        Text(
            Title,
            Modifier
                .constrainAs(title) {
                    top.linkTo(topImage.bottom, 50.dp)
                    start.linkTo(parent.start, 20.dp)
                    bottom.linkTo(title.top)
                }
                .height(110.dp),
            fontSize = dimensions.storyTitle,
            fontWeight = FontWeight.Light,
            lineHeight = 42.sp
        )
        SelectionContainer(
            Modifier
                .constrainAs(text) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(start = 20.dp, top = 40.dp, bottom = 20.dp, end = 20.dp))
        {
            Column {
                Text(
                    SubTitle,
                    fontSize = dimensions.storySubTitle,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.padding(10.dp))
                Text(
                    Text,
                    fontSize = dimensions.storyText,
                    fontWeight = FontWeight.Normal
                )
                Spacer(Modifier.padding(10.dp))
                Text(
                    SubTitle2,
                    fontSize = dimensions.storySubTitle,
                    fontWeight = FontWeight.Normal
                )
                Spacer(Modifier.padding(10.dp))
                Text(
                    Text2,
                    fontSize = dimensions.storyText,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}