package exe

import util.ObservationUtil
import java.nio.file.Path
import http.FileUpload

object Main {

  def main(args: Array[String]): Unit = {
//    val filePath : Unit = ObservationUtil.watchNewFile("""E:\work""", """E:\work\trash""")
//    println(filePath.toString())

    println("読み込む前")
    FileUpload
    println("読み込んだ後")
  }

}