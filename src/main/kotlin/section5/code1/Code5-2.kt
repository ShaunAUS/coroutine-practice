package section5.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// join() 으로 메인함수가 updateTokenJob이 끝날때까지 기다리다가 결과가 나오면 netwrokCallJob을 실행
fun main() = runBlocking<Unit> {
    val updateTokenJob = launch(Dispatchers.IO) {
        println(" [${Thread.currentThread().name}] 작업1 실행")
        delay(100L)
        println(" [${Thread.currentThread().name}] 작업1 완료")
    }

    updateTokenJob.join()

    val networkCallJob = launch(Dispatchers.IO) {
        println(" [${Thread.currentThread().name}] 네트워크 요청")
    }
}
