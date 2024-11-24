package section7.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val longJob = launch(Dispatchers.Default) {
        delay(1000L)
        println("작업1시작")
    }
    longJob.cancelAndJoin()
    executeAfterJobCanceled()
}

fun executeAfterJobCanceled() {
    println("작업1이 취소되었으므로 이 작업이 실행됩니다.")
}



