package section4.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import section3.code1.multiThreadDispatcher

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default) {

        launch {
            println(" [${Thread.currentThread().name}] 작업1 실행")
        }
        launch {
            println(" [${Thread.currentThread().name}] 작업2 실행")
        }

        launch {
            println(" [${Thread.currentThread().name}] 작업3 실행")
        }


    }
}