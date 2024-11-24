package section5.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//순서보장 x
fun main() = runBlocking<Unit> {
    val updateTokenJob = launch(Dispatchers.IO) {
        println(" [${Thread.currentThread().name}] 작업1 실행")
        delay(100L)
        println(" [${Thread.currentThread().name}] 작업1 완료")

    }

    val networkCallJob = launch(Dispatchers.IO) {
        println(" [${Thread.currentThread().name}] 네트워크 요청")
    }
}
