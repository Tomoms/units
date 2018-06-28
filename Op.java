import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

class Op
{

  private int table[][];
  private int sqlen;

  Op(int n)
  {
    sqlen = n;
    table = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        table[i][j] = ThreadLocalRandom.current().nextInt(0, n);
      }
    }
    for (int i = 0; i < n; i++)
      System.out.println(Arrays.toString(table[i]));
  }

  public int getValue(int r, int c)
  {
    return table[r][c];
  }

}
