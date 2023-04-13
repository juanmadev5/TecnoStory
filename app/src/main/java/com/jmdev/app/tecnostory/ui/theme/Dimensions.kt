package com.jmdev.app.tecnostory.ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

interface Dimensions {
    val topTitle: TextUnit
    val description: TextUnit
    val iconFeatured: Dp
    val featured: TextUnit
    val cardHeight: Dp
    val cardWidth: Dp
    val cardImageW: Dp
    val cardImageH: Dp
    val storyTitle: TextUnit
    val storySubTitle: TextUnit
    val storyText: TextUnit
    val onStoryImageWidth: Dp
    val onStoryImageHeight: Dp
}

data class Sw240dp(
    override val topTitle: TextUnit = 86.sp,
    override val description: TextUnit = 56.sp,
    override val iconFeatured: Dp = 60.dp,
    override val featured: TextUnit = 48.sp,
    override val cardHeight: Dp = 400.dp,
    override val cardWidth: Dp = 400.dp,
    override val cardImageW: Dp = 390.dp,
    override val cardImageH: Dp = 200.dp,
    override val storyTitle: TextUnit = 80.sp,
    override val storySubTitle: TextUnit = 54.sp,
    override val storyText: TextUnit = 30.sp,
    override val onStoryImageWidth: Dp = 400.dp,
    override val onStoryImageHeight: Dp = 210.dp
) : Dimensions

data class Sw320dp(
    override val topTitle: TextUnit = 66.sp,
    override val description: TextUnit = 16.sp,
    override val iconFeatured: Dp = 30.dp,
    override val featured: TextUnit = 20.sp,
    override val cardHeight: Dp = 400.dp,
    override val cardWidth: Dp = 400.dp,
    override val cardImageW: Dp = 390.dp,
    override val cardImageH: Dp = 200.dp,
    override val storyTitle: TextUnit = 58.sp,
    override val storySubTitle: TextUnit = 34.sp,
    override val storyText: TextUnit = 28.sp,
    override val onStoryImageWidth: Dp = 400.dp,
    override val onStoryImageHeight: Dp = 210.dp
) : Dimensions

//
data class Sw480dp(
    override val topTitle: TextUnit = 40.sp,
    override val description: TextUnit = 18.sp,
    override val iconFeatured: Dp = 24.dp,
    override val featured: TextUnit = 16.sp,
    override val cardHeight: Dp = 415.dp,
    override val cardWidth: Dp = 420.dp,
    override val cardImageW: Dp = 320.dp,
    override val cardImageH: Dp = 167.dp,
    override val storyTitle: TextUnit = 35.sp,
    override val storySubTitle: TextUnit = 20.sp,
    override val storyText: TextUnit = 16.sp,
    override val onStoryImageWidth: Dp = 400.dp,
    override val onStoryImageHeight: Dp = 212.dp
) : Dimensions

data class Large(
    override val topTitle: TextUnit = 16.sp,
    override val description: TextUnit = 15.sp,
    override val iconFeatured: Dp = 24.dp,
    override val featured: TextUnit = 14.sp,
    override val cardHeight: Dp = 400.dp,
    override val cardWidth: Dp = 400.dp,
    override val cardImageW: Dp = 390.dp,
    override val cardImageH: Dp = 180.dp,
    override val storyTitle: TextUnit = 10.sp,
    override val storySubTitle: TextUnit = 26.sp,
    override val storyText: TextUnit = 18.sp,
    override val onStoryImageWidth: Dp = 400.dp,
    override val onStoryImageHeight: Dp = 210.dp
) : Dimensions


val LocalSw240dpDimensions = compositionLocalOf { Sw240dp() }
val LocalSw320dpDimensions = compositionLocalOf { Sw320dp() }
val LocalSw480dpDimensions = compositionLocalOf { Sw480dp() }
val LocalLargeDimensions = compositionLocalOf { Large() }

val dimensions: Dimensions
    @Composable
    @ReadOnlyComposable
    get() {
        val sw = LocalConfiguration.current.smallestScreenWidthDp
        return when {
            sw <= 240 -> LocalSw240dpDimensions.current
            sw <= 320 -> LocalSw320dpDimensions.current
            sw <= 480 -> LocalSw480dpDimensions.current
            else -> LocalLargeDimensions.current
        }
    }

val orientation: Int
    @Composable
    @ReadOnlyComposable
    get() = LocalConfiguration.current.orientation