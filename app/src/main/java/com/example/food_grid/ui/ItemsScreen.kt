package com.example.food_grid.ui


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_grid.ui.data.DataSource
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier





@Composable
fun ItemsScreen(flashViewModel: FlashViewModel){
    val flashUiState by flashViewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ){
        items(DataSource.loadItems(
            flashUiState.selectedCategory
        )){
            ItemsCard(
                stringResourceId = it.stringResourceId,
                imageResourceId = it.imageResourceId,
                itemQuantityId = it.itemQuantityId,
                itemPrice = it.itemPrice)

             }
    }

    }

@Composable
fun ItemsCard(
    stringResourceId: Int,
    itemQuantityId: String,
    itemPrice: Int,
    imageResourceId: Int
){
    val context = LocalContext.current
    Column (modifier = Modifier.width(150.dp)){
        Card (){
            Box{
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = "Item Name",
                    modifier = Modifier.fillMaxWidth().height(110.dp)

                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End
                ){
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text(
                            text = "25% Off",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(
                                horizontal = 5.dp,
                                vertical = 2.dp

                            )
                        )
                    }

                }

            }
        }

        Text(
            text = stringResource(id = stringResourceId),
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth(),

            )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
        ){
            Column {
                Text(
                    text = "RS. $itemPrice",
                    fontSize = 10.sp,
                    maxLines = 1,
                    textAlign = TextAlign.Left,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = "Rs.$itemPrice,*75/100",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left,
                    color = Color.Gray
                )
            }
            Text(
                text = itemQuantityId,
                fontSize = 10.sp,
                maxLines = 1,
                textAlign = TextAlign.Right,
                color = Color.Gray,
            )
        }
        Card(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .clickable {
                    Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show()
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.Green
            )
        ){
            Row  (
                modifier = Modifier.fillMaxWidth()
                    .height(24.dp)
                .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ){
                Text(
                    text="Add to cart",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

        }
    }
}
