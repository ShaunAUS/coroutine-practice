package section8.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


fun main() = runBlocking<Unit> {
    val job = launch(Dispatchers.Default) {
        while (this.isActive) {
            print("작업중")
            yield()
        }
    }
    delay(100L)
    job.cancel()

}


