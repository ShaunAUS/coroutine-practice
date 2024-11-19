package section2.code1

import kotlinx.coroutines.runBlocking

//이 함수를 호출한 쓰레드를 사용해 실행되는 코루틴을 만들어냄
//즉 메인쓰레드를 점유하는 코루틴을 만들어냄
//runBlocking 코루틴은 runblocking 코루틴 , 혹은 그와 관련된 코루틴이 아니면 스레드 점유 불가
fun main() = runBlocking {

    println("Hello Coroutines")

}