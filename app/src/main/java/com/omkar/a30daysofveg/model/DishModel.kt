package com.omkar.a30daysofveg.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DishModel (
    @DrawableRes val dishImg: Int,
    @StringRes val dishName: Int,
    @StringRes val dishIngredient: Int,
    @StringRes val dishInstruction: Int
)