package exe

import util.ObservationUtil

object Main {

  def main(args: Array[String]): Unit = {
    ObservationUtil.watchNewFile("""E:\work""")
  }

}