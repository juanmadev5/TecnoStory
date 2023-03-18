package com.jmdev.app.tecnostory.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jmdev.app.tecnostory.R
import com.jmdev.app.tecnostory.ui.theme.dimensions

@Composable
fun CardContent(
    painterResource: Int,
    stringResource: Int,
    navController: NavController,
    destination: String
) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(30.dp))
    ) {
        val (
            featuredImage,
            featuredContentDescription,
            continueButton
        ) = createRefs()

        Image(
            painterResource(painterResource),
            "",
            Modifier
                .constrainAs(featuredImage) {
                    top.linkTo(parent.top, margin = 36.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(featuredContentDescription.top)
                }
                .size(dimensions.cardImageW, dimensions.cardImageH)
                .clip(shape = RoundedCornerShape(30.dp))
        )
        Text(
            stringResource(stringResource),
            Modifier
                .constrainAs(featuredContentDescription) {
                    top.linkTo(featuredImage.bottom, margin = 20.dp)
                    start.linkTo(featuredImage.start)
                    end.linkTo(featuredImage.end)
                }
                .width(360.dp)
                .height(100.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )
        ElevatedButton(
            onClick = {
                navController.navigate(destination)
            },
            Modifier
                .constrainAs(continueButton) {
                    start.linkTo(parent.start, margin = 20.dp)
                    top.linkTo(featuredContentDescription.bottom, 20.dp)
                },
            elevation = ButtonDefaults.buttonElevation(8.dp)
        ) {
            Icon(imageVector = Icons.Filled.PlayArrow, "")
            Spacer(Modifier.padding(4.dp))
            Text(stringResource(R.string.continueReading))
        }
    }
}
