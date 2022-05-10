package fr.benchaabane.presentation.car

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.benchaabane.domain.car.RetrieveCarsUseCase
import fr.benchaabane.domain.common.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(private val useCase: RetrieveCarsUseCase) :
    ViewModel() {

    var uiState by mutableStateOf(value = CarUiState())
        private set

    init {
        viewModelScope.launch {
            val result = useCase.execute()
            if (result is Result.Success) {
                uiState = CarUiState(cars = result.data.map { it.toUi() })
            }
        }
    }
}
