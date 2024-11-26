package section15.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

//async도 launch 처럼 부모까지 예외 전파가 됨
fun main() : Unit = runBlocking {
    supervisorScope {
        val deferred: Deferred<String> = async(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1 exception")
        }

        try {
            deferred.await()
        } catch (e: Exception) {
            println("[$e] Exception message: ${e.message}")
        }
    }
}