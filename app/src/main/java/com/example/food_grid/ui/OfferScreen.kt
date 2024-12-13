package com.example.food_grid.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.food_grid.R

@Composable
fun OfferScreen(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(Color.Blue )
    ){
        Image(painter = painterResource(id = R.drawable.dall_e_2024_11_27_11_14_12___a_vibrant_promotional_image_for_a_grocery_app__featuring_fresh_fruits__vegetables__and_grocery_items_like_rice_and_spices_displayed_in_a_visually_appe),
            contentDescription = "Offer",
            modifier = Modifier.padding(16.dp))

    }
}