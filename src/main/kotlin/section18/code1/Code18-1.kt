package section18.code1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//CoroutineStart.Default
fun main() = runBlocking {
    launch {
        println("작업1")
    }
    println("작업2")
}