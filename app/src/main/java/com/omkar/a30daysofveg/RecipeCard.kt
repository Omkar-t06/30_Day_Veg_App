package com.omkar.a30daysofveg

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkar.a30daysofveg.model.DishModel
import com.omkar.a30daysofveg.ui.theme.Montserrat


@Composable
fun RecipeCard(
    dayNumber: Int,
    recipeOfDish: DishModel,
    modifier: Modifier = Modifier
) {
    var showRecipe by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(colorScheme.surfaceContainer),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.day_no,dayNumber),
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(bottom = 4.dp)
            )
            Text(
                text = stringResource(id = recipeOfDish.dishName),
                style = MaterialTheme.typography.headlineMedium,
                modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )
            Image(
                painter = painterResource(id = recipeOfDish.dishImg),
                contentDescription = stringResource(recipeOfDish.dishName),
                contentScale = ContentScale.Crop, // Cropping to maintain aspect ratio
                modifier = Modifier
                    .fillMaxWidth() // Make the image fill the width of the card
                    .height(200.dp) // Set a fixed height
                    .clip(MaterialTheme.shapes.medium) // Clip to the card's shape
            )

            if(showRecipe){
                Text(
                    text = stringResource(id = R.string.ingredients_title),
                    style = MaterialTheme.typography.titleMedium.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = modifier.padding(
                        top = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_extra_small)
                    )
                )
                Text(
                    text = stringResource(id = recipeOfDish.dishIngredient),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(id = R.string.instructions_title),
                    style = MaterialTheme.typography.titleMedium.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = modifier.padding(
                        top = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_extra_small)
                    )
                )
                Text(
                    text = stringResource(id = recipeOfDish.dishInstruction),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_small)))
            ShowRecipeButton(expanded = showRecipe, onClick = { showRecipe = !showRecipe })
        }
    }
}

@Composable
fun ShowRecipeButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorScheme.primary,
            contentColor = colorScheme.onPrimary
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(
                    id = if (expanded) R.string.hide_recipe_button else R.string.show_recipe_button
                ),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = modifier.weight(1f)
            )
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = stringResource(R.string.expand_button_content_description),
                tint = colorScheme.onPrimary
            )
        }
    }
}

@Composable
@Preview
fun RecipeCardPreview() {
    RecipeCard(
        dayNumber = 3,
        DishModel(
            dishImg = R.drawable.recipe3,
            dishName = R.string.recipe_3_name,
            dishIngredient = R.string.recipe_3_ingredient,
            dishInstruction = R.string.recipe_3_instruction
        )
    )
}