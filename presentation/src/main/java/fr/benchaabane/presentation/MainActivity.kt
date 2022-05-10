package fr.benchaabane.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.benchaabane.presentation.car.CarViewModel
import fr.benchaabane.presentation.ui.theme.ZFTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZFTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: CarViewModel = viewModel()
                    Greeting(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    viewModel: CarViewModel
) {
    val uiState = viewModel.uiState
    LazyColumn(
        modifier.fillMaxSize()
    ) {
        itemsIndexed(items = uiState.cars) { _, car ->
            Card(
                modifier = Modifier.background(
                    color = Color.White,
                    shape = MaterialTheme.shapes.medium
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Vehicle is ${car.vehicleId}")
                    Text(text = "latitude is ${car.latitude}")
                    Text(text = "latitude is ${car.longitude}")
                }
            }
        }
    }
}
