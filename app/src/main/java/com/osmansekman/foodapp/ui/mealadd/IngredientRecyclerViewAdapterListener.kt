package com.osmansekman.foodapp.ui.mealadd

import com.osmansekman.foodapp.model.entity.Ingredient

interface IngredientRecyclerViewAdapterListener {
    fun onIngredientClickListener(ingredient: Ingredient, position: Int)
}