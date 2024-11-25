package section9.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch(Dispatchers.Default) {
        delay(1000L)
    }
    job.join()
    println(job)
}

