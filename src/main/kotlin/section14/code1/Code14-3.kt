package section14.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//14-2 구조화 꺠기 Job
fun main() = runBlocking<Unit> {// rootJob

    val newJob = Job()

    launch(CoroutineName("Coroutine1") + newJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행")
        }
    }
    launch(CoroutineName("Coroutine2") + newJob) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행")
        }
    }

/*
    newJob.cancel()
    delay(100L)
*/
}