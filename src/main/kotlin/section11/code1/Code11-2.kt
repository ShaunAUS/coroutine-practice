package section11.code1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() = runBlocking<Unit> {
    val result1 = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}]결과값이 반환됩니다.")
        "결과1"
    }

    println("[${Thread.currentThread().name}] $result1")

}
