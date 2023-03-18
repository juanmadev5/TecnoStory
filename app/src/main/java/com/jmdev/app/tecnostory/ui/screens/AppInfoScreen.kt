package com.jmdev.app.tecnostory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jmdev.app.tecnostory.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun appInfoScreen(
    AppName: String = stringResource(R.string.app_name),
    AppVer: String = "v1.1",
    DevName: String = "by Juan Manuel (JM Dev)",
    Description: String = "$AppName es una simple aplicación para ver historias relacionadas" +
            " a la tecnología. ",
    JCDesc: String = "Esta aplicación esta totalmente construído con Android Jetpack Compose."
) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (appVer, appName, Icon, devIcon, devName, devNote, devNotes, JetCompImage, JetCompDesc) = createRefs()

        Icon(
            painterResource(R.drawable.ic_launcher_main_foreground), "",
            Modifier
                .constrainAs(Icon) {
                    top.linkTo(parent.top, margin = 80.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end)
                }
        )
        Text(
            AppName,
            Modifier
                .constrainAs(appName) {
                    top.linkTo(Icon.bottom, margin = 20.dp)
                    start.linkTo(Icon.start)
                    end.linkTo(Icon.end)
                },
            fontSize = 26.sp
        )
        Text(
            AppVer,
            Modifier
                .constrainAs(appVer) {
                    start.linkTo(appName.start)
                    end.linkTo(appName.end)
                    top.linkTo(appName.bottom, margin = 6.dp)
                },
            fontSize = 18.sp
        )
        Icon(
            Icons.Rounded.Person, "",
            Modifier
                .constrainAs(devIcon) {
                    top.linkTo(appVer.bottom, margin = 60.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
        )
        Text(
            DevName,
            Modifier
                .constrainAs(devName) {
                    top.linkTo(devIcon.top)
                    start.linkTo(devIcon.end, margin = 20.dp)
                    bottom.linkTo(devIcon.bottom)
                },
            fontSize = 18.sp
        )
        Icon(
            Icons.Rounded.Notes, "",
            Modifier
                .constrainAs(devNote) {
                    top.linkTo(devIcon.bottom, margin = 90.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
        )
        Text(
            Description,
            Modifier
                .constrainAs(devNotes) {
                    top.linkTo(devNote.top)
                    start.linkTo(devNote.end, margin = 20.dp)
                    bottom.linkTo(devNote.bottom)
                    end.linkTo(parent.end, maxOf(40.dp))
                }
                .padding(50.dp)
        )
        Image(
            painterResource(R.drawable.jetpackcompose), "",
            Modifier
                .constrainAs(JetCompImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(devNotes.bottom)
                }
                .fillMaxWidth()
                .height(205.dp)
        )
        Text(
            JCDesc,
            Modifier
                .constrainAs(JetCompDesc) {
                    start.linkTo(JetCompImage.start)
                    end.linkTo(JetCompImage.end)
                    top.linkTo(JetCompImage.bottom, margin = 8.dp)
                }
                .padding(15.dp)
        )
    }
}