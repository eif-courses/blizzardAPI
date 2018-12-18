import javafx.application.Application.launch
import kotlinx.coroutines.*

fun main() = runBlocking{
  val start = System.currentTimeMillis()
  pavyzdysAsyncAwait()
  val end = System.currentTimeMillis()
  println("time in ms: ${end - start}ms")
}



fun pavyzdysAsyncAwait() = runBlocking {
  val deferred1 = async { skaiciuoti(1000L) }.await()
  val deferred2 = async { skaiciuoti(1000L) }.await()
  val deferred3 = async { skaiciuoti(1000L) }.await()

  val sum = deferred1 + deferred2 + deferred3
  println("async/await result = $sum")
}

suspend fun skaiciuoti(ms: Long = 1000L):Int {
  delay(ms)
  return ms.toInt() * 500
}




//suspend fun sustabdyti(ms: Long) {delay(ms); print("Darbas atliktas !!!")}


