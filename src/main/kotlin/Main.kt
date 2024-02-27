package org.example

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlin.random.Random

fun main() {
}
object Generator {    //создали поток чисел где каждую секунду размещаются случайные числа
    val flow = flow {
        while (currentCoroutineContext().isActive)
        emit(Random.nextInt())
        delay(1000)
    }
    fun flow(): Flow<Int> {
        return flow {
            while (currentCoroutineContext().isActive)
                emit(Random.nextInt())
            delay(1000)
        }
    }
}