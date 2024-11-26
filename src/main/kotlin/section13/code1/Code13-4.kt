package section13.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val whileJob = launch(Dispatchers.Default) {
        while (this.isActive) {
            println("작업중")
        }
    }
    delay(1000L)
    whileJob.cancel()
}