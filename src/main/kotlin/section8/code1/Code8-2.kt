package section8.code1

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


//  while 문이 돌때마다 delay때문에  불필요하게 작업을 지연시켜 성능저하 발생 -> yield() 사용
fun main() = runBlocking<Unit> {
    val job = launch(Dispatchers.Default) {
        while (true) {
            print("작업중")
            yield()
        }
    }
    delay(100L)
    job.cancel()

}


