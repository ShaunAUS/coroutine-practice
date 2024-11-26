package section15.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {

    val supervisorJob = SupervisorJob(this.coroutineContext[Job])

    launch(CoroutineName("Coroutine1") + supervisorJob) {
        launch(CoroutineName("Coroutine3")) {
            throw Exception("예외 발생 꺅")
        }
        delay(100L)
        println("${Thread.currentThread().name} 코루틴 실행")
    }
    launch(CoroutineName("Coroutine2") + supervisorJob) {
        delay(100L)
        println("${Thread.currentThread().name} 코루틴 실행")
    }
    supervisorJob.complete()
}