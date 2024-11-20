package section3.code1

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking


//싱글 스레드 디스패처
val singleThreadDispatcher: CoroutineDispatcher =
    newSingleThreadContext("singleThread")

fun main() = runBlocking<Unit> {
    launch(singleThreadDispatcher) {
        println(" [${Thread.currentThread().name}] 실행")
    }
}