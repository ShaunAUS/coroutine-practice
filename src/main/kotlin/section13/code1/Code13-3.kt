package section13.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행 완료")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행 완료")
        }
        this.cancel() //Coroutine1 Scope 취소

    }
    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("${Thread.currentThread().name} 코루틴 실행 완료")
    }
}