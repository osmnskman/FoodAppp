package com.osmansekman.foodapp.ui.meal

import com.osmansekman.foodapp.model.entity.meal.Meal

interface IMealOnClick {
    fun onClick(meal: Meal)
}