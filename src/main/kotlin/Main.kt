package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun main() {
    // Получим значения из флоу
    runBlocking {
        launch {
            println("Start collecting...")
            Generator.flow.collect {
                // в блоке collect указываем код, который будет
                // выполнятся при получении каждого из значений flow
                println("Collected value - $it")
            }
            println("Start working...")
        }
    }

}
object Generator {    //создали поток чисел где каждую секунду размещаются случайные числа
    val flow = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt())
            delay(1000)
        }
    }
    fun flow(): Flow<Int> {
        return flow {
            while (currentCoroutineContext().isActive) {
                emit(Random.nextInt())
                delay(1000)
            }
        }
    }
}