package com.example.food_grid.ui.data

import androidx.annotation.StringRes
import com.example.food_grid.R

object DataSource {
    fun loadCategories(): List<Categories> {
        return listOf<Categories>(
            Categories(
                stringResourceId = R.string.fresh_fruits,
                imageResourceId = R.drawable.fruits
            ),
            Categories(R.string.sweet_tooth, R.drawable.sweet),
            Categories(R.string.bath_body, R.drawable.bathbody),
            Categories(R.string.bread_biscuits, R.drawable.bread),
            Categories(R.string.beverages, R.drawable.beverages),
            Categories(R.string.vegetables, R.drawable.vegetables),
            Categories(R.string.fresh_fruits, R.drawable.fruits),
            Categories(R.string.munchies, R.drawable.munchies),
            Categories(R.string.packaged_food, R.drawable.packaged),


            )
    }

    fun loadItems(
        @StringRes categoryName: Int
    ): List<Item> {
        return listOf<Item>(
            Item(R.string.shimla_apple, R.string.fresh_fruits, "1 kg", 100, R.drawable.fruits),
            Item(R.string.papaya_semi_ripe, R.string.fresh_fruits, "1 kg", 100, R.drawable.fruits),
            Item(R.string.pomegranate, R.string.fresh_fruits, "1 kg", 100, R.drawable.fruits),
            Item(R.string.pineapple, R.string.fresh_fruits, "2Kg", 150, R.drawable.fruits),
            Item(R.string.pepsi_can, R.string.beverages, "1L", 100, R.drawable.beverages),
            Item(R.string.banana_robusta, R.string.fresh_fruits, "1Kg", 100, R.drawable.fruits),
        ).filter {
            it.itemCategoryId == categoryName

        }

    }


}