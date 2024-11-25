package section13.code1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val parentJob: Job = launch(Dispatchers.IO) { //부모 코루틴
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async { //자식 코루틴
                delay(1000L)
                println("[$it] 로부터 데이터 가져오기 성공")
                "[$it] data"
            }
        }
        val dbResults: List<String> = dbResultsDeferred.awaitAll()
        println(dbResults)
    }
    parentJob.cancel() // 부모 코루틴 취소 요청
}