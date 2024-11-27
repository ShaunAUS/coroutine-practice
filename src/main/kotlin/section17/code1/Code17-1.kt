package section17.code1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// 여러 스레드에서 가변 변수에 동시에 접근해 값을 변경하면 데이터의 손실이나 불일치로 버그가 발생할 수 있다.
@Volatile
var count = 0

fun main(): Unit = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count += 1
            }
        }
    }
    println("count = $count")
}