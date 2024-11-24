package section7.code1

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.text.Typography.times

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    launch (Dispatchers.IO){
        repeat(100){
            delay(1000L)
            println(" [${getelapsedTime(startTime)}] 작업1 실행")
        }
    }
}

fun getelapsedTime(startTime: Long) : String=
    (System.currentTimeMillis() - startTime).toString() + "ms"


