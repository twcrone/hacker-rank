object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val a0 = sc.nextInt()
    val a1 = sc.nextInt()
    val a2 = sc.nextInt()
    val b0 = sc.nextInt()
    val b1 = sc.nextInt()
    val b2 = sc.nextInt()

    val alice = Array(a0, a1, a2)
    val bob = Array(b0, b1, b2)

    var aliceScore = 0
    var bobScore = 0

    for(i <- 0 until 3) {
      val aliceVal = alice(i)
      val bobVal = bob(i)
      if(aliceVal > 100 || aliceVal < 1 || bobVal > 100 || bobVal < 0) {
        // do nothing
      }
      else if(alice(i) > bob(i)) {
        aliceScore += 1
      }
      else if(bob(i) > alice(i)) {
        bobScore += 1
      }
    }

    println(aliceScore + " " + bobScore)
  }
}
