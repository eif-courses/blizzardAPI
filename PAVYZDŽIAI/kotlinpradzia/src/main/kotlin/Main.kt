import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.swing.JComponent
import javax.swing.JOptionPane
import javax.xml.bind.JAXBElement
import kotlin.properties.Delegates

//Main.kt


class User {
  var name: String by Delegates.observable("<no name>") {
      prop, old, new ->
    println("$old -> $new")
  }
}

fun main() {
  val user = User()
  user.name = "first"
  user.name = "second"
  user.name = "Next"
}









