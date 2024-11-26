package section15.code1

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("예외 발생[$throwable] ")
    }

    val exceptionHandler2 = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("예외 발생[$throwable] ")
    }

    CoroutineScope(context = exceptionHandler)
        .launch(CoroutineName("Coroutine1") + exceptionHandler2) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2 exception 발생")
            }
        }
    delay(2000L)
}