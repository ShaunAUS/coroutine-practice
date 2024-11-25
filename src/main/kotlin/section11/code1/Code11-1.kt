package section11.code1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


//이런
fun main() = runBlocking<Unit> {
    val result1 = withContext(Dispatchers.IO) {
        delay(1000L)
        "결과1"
    }

    val result2 = withContext(Dispatchers.IO) {
        delay(1000L)
        "결과2"
    }

    val results = listOf(result1, result2)

}
