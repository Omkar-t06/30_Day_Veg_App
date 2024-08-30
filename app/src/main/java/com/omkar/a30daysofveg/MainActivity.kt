package com.omkar.a30daysofveg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.omkar.a30daysofveg.data.DishesList
import com.omkar.a30daysofveg.ui.theme._30DaysOfVegTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfVegTheme {
                A30DaysOfVeg()
            }
        }
    }
}

@Composable
fun A30DaysOfVeg() {
    Scaffold(topBar = { MyAppBar() }) { innerPadding ->
        RecipeListView(
            dishesList = DishesList.loadDishes,
            contentPadding = innerPadding,
        )
    }
}

@Composable
fun MyAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}


@Preview
@Composable
fun AppPreview() {
    _30DaysOfVegTheme {
        A30DaysOfVeg()
    }
}