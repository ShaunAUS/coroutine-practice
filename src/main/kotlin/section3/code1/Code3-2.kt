package section3.code1

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

//멀티 스레드 디스패처
//미리 스레드를 만들어 놓기 떄문에 메모리 차지함
val multiThreadDispatcher: CoroutineDispatcher =
    newFixedThreadPoolContext(2,"MultiThread")

fun main() = runBlocking<Unit> {
    launch(multiThreadDispatcher) {
        println(" [${Thread.currentThread().name}] 실행")
    }
    launch(multiThreadDispatcher) {
        println(" [${Thread.currentThread().name}] 실행")
    }
}
