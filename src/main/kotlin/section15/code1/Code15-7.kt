package section15.code1

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        try {
            throw Exception("Coroutine1 exception 발생")
        } catch (e: Exception) {
            println(e.message)
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("Coroutine2 코루틴 실행 완료")
        }
    }
}