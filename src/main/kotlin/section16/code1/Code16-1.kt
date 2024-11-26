package section16.code1

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

//일시 중단 함수는 CoroutineScope에 접근할 수 없기 때문에 별도 처리 없이 코루틴 빌더 함수를 호출할 수 없다
suspend fun searchByKeyword(keyword: String): Array<String>  = coroutineScope{
    val dbResultsDeferred = async {
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    return@coroutineScope arrayOf(*(dbResultsDeferred.await()), *(serverResultsDeferred.await()))
}

suspend fun searchFromDB(keyword: String): Array<String> {
    delay(timeMillis = 1000L)
    return arrayOf("DB{$keyword}1", "DB{$keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
    delay(timeMillis = 1000L)
    return arrayOf("[Server]{$keyword}1", "[Server]{$keyword}2")
}