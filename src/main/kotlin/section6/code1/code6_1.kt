package section6.code1

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val lazyJob = launch(start = CoroutineStart.LAZY) {
        println(" [${Thread.currentThread().name}] 작업1 실행")
    }
    lazyJob.start()
}


