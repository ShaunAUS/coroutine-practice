package section10.code1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val deferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000L)
        return@async "Hello"
    }
}

