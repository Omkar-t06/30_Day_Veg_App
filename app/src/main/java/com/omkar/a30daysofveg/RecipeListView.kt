package com.omkar.a30daysofveg

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omkar.a30daysofveg.data.DishesList
import com.omkar.a30daysofveg.model.DishModel

@Composable
fun RecipeListView(
    modifier: Modifier = Modifier,
    dishesList: List<DishModel>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        itemsIndexed(dishesList) { index, dish ->
            RecipeCard(
                dayNumber = index + 1,
                recipeOfDish = dish,
                modifier = modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_small),
                    vertical = dimensionResource(id = R.dimen.padding_extra_small)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    RecipeListView(dishesList = DishesList.loadDishes)
}