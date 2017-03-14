/**
  * Created by camilo on 11/03/17.
  */
object ws {
  def main(): Unit ={
    val lista = List(1, 2, 3, 4)
    val conjunto = Set(1, 2, 3, 4, 5, 1)
    val mapa = Map(1 -> "Luis", 2 -> "Juan")
    lista.map(_ + 3)
    lista
    lista.filter(_ < 2)
    val names = List("Juan", "Carlos", "Andrés")
    names.map(_.length)
  }

}
ws.main()