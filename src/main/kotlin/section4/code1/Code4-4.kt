package section4.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import section3.code1.multiThreadDispatcher

// IO,Default 둘다 코루틴 라이브러리의 공유 스레드풀 사용함
fun main() = runBlocking<Unit> {
    val limitedParallelism = Dispatchers.IO.limitedParallelism(2)
    repeat(10) {
        launch(limitedParallelism) {
            println(" [${Thread.currentThread().name}] 작업${it + 1} 실행")
        }
    }
}
