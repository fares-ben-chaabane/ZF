package fr.benchaabane.domain.car

class RetrieveCarsUseCase(private val repository: ICarRepository) {
    suspend fun execute() = repository.retrieveCars()
}
