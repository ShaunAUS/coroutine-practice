package section12

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    //구성요소 접근
    val coroutineName = coroutineContext[CoroutineName]

    //구성요소 제거
    val minusKey = coroutineContext.minusKey(CoroutineName)

    val newCoroutineContext = coroutineContext + CoroutineName("MyCoroutine2")

    //Job도 따로 설정 가능
    val jobCoroutineContext = Dispatchers.Default + Job()
}