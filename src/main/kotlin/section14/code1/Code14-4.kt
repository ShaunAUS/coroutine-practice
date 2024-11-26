package section14.code1

import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 생성 함수로 생서된 Job객체는 자동으로 실행 완료되지 않기 때문에** 명시적으로 complete함수를 호출해 줘야함
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val newJob: CompletableJob = Job()
        launch(context = CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            println("${Thread.currentThread().name} 코루틴 실행")
        }
        newJob.complete()
    }
}