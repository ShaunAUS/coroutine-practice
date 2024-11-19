package section2.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//코루틴이 생성될 때마다 호출부의 쓰레드를 점령하면 안되기 때문에 runBlocking 함수는 시작구 에서만 사용하고 내부에서 코루틴을 생성할때는 launch()사용
fun main() = runBlocking<Unit>(CoroutineName("runBlocking 코루틴")) {

    println("[${Thread.currentThread().name}]runBlocking 코루틴 실행")

    //launch() : 코루틴scope 필요함
    launch(CoroutineName("launch 코루틴")) {
        println("[${Thread.currentThread().name}]launch 코루틴 실행")
    }

}
