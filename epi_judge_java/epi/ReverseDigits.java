package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {

    // a key here is that return type is long, not int. so no overflow need to be handled for Integer type.
    // see
    /*
    public int reverse(int x) {    // where return type is int
    int y = 0;
    while(x != 0) {
        if(y > Integer.MAX_VALUE/10 || y < Integer.MIN_VALUE/10) return 0;  // -- overflow need to be handled
        y *= 10;
        y += x % 10;
        x /= 10;
    }
    return y;
}

     */
    long result = 0;
    result = x % 10;
    while (x / 10 != 0){
      x = x / 10;
      result = result * 10 + (x % 10);
    }

    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
