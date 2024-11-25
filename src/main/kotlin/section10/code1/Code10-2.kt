package section10.code1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    val participantDeferred1 = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "영수")
    }


    val participantDeferred2 = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("영희")
    }


    val results = awaitAll(participantDeferred1, participantDeferred2)

    println("${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"