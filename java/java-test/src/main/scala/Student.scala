package main.scala

class Student(name: String, age: Int) {
  def printInfo(): Unit = {
    println(name + " " + age + " " + Student.school)
  }
}

// 引入半生对象
object Student {
  val school: String = "atguigu"

  def main(args: Array[String]): Unit = {
    val alice = new Student("Alice", 20)
    val bob = new Student("Bob", 23)
    alice.printInfo()
    bob.printInfo()
  }
}
