package section7.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//cancel함수는 코루틴을 바로 취소하지 않고, 취소 확인용 플래그를 취소 요청됨 으로 바꾸는 역활만 한다
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob = launch(Dispatchers.IO) {
        repeat(100) {
            delay(1000L)
            println(" [${getelapsedTime(startTime)}] 작업1 실행")
        }
    }
    delay(2500L)
    longJob.cancel()
}



