package com.example.food_grid.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier // Correct import
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.food_grid.R
import com.example.food_grid.ui.data.DataSource
import com.google.firebase.firestore.remote.Datastore

@Composable
fun StartScreen(
    flashViewModel: FlashViewModel,
    onCategoryClicked: (Int) -> Unit
    ) {
    val context = LocalContext.current
    val flashUiState by flashViewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)

    ) {

        items(DataSource.loadCategories()){
            CategoryCard(
                context = context,
                stringResourceId  = it.stringResourceId,
                imageResourceId = it.imageResourceId,
                itemCategoryID = it.stringResourceId,
                flashViewModel = flashViewModel,
                onCategoryClicked = onCategoryClicked
            )

        }


    }

}
@Composable
fun  CategoryCard
            (context: Context,
             stringResourceId: Int,
             imageResourceId: Int,
             itemCategoryID: Int,
             flashViewModel: FlashViewModel,
             onCategoryClicked: (Int) -> Unit
             ){
                val categoryName = stringResource(id = stringResourceId)
    Card (modifier= Modifier.clickable {
        flashViewModel.updateClickText(categoryName)
        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        onCategoryClicked(stringResourceId)
    }){
        Column (modifier = Modifier.padding(5.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(
                text = categoryName,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center // Increased width for better visibility
            )
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = "Fresh Fruit",
                modifier = Modifier.size(150.dp)
            )
        }
    }

}