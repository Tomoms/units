import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Run
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the table's width/length:");
    int n = sc.nextInt();
    Op op = new Op(n);
    sc.nextLine();
    System.out.println();
    System.out.println("Type an expression using the Polish notation (e.g. Fx,y):");
    String exp = sc.nextLine();
    String exptmp = exp;
    exptmp = exptmp.replaceAll("F", " ").replaceAll(",", " ").trim();
    String elExpTmp[] = exptmp.split("\\s+");
    int elExp[] = new int[elExpTmp.length];
    for (int i = 0; i < elExp.length; i++) {
      elExp[i] = Integer.parseInt(elExpTmp[i]);
      System.out.println("ELEMENTI SEMPLICI = " + elExp[i]);
    }

    int countF = 0, countComma = 0, countTotal = 1;
    for (int i = 0; i < exp.length(); i++) {
      if (exp.charAt(i) == 'F')
        countF++;
      else if (exp.charAt(i) == ',')
        countComma++;
    }

    countTotal += countF + countComma;
    ArrayList<Exp> exparr = new ArrayList<>();
    for (int i = 0; i < countTotal; i++)
      exparr.add(new Exp(-1));

    int lastPos, val;
    for (int i = elExp.length - 1; i >= 0; i--) {
      System.out.println(exp);
      lastPos = exp.lastIndexOf((char)(elExp[i] + 48));
      val = lastPos - countComma;
      exparr.remove(val);
      exparr.add(val, new Exp(elExp[i]));
      exp = exp.substring(0, lastPos);
      countComma--;
    }

    for (int i = exparr.size() - 3; i >= 0; i--) {
      if (exparr.get(i).getVal() == -1
          && exparr.get(i + 1).getVal() != -1
          && exparr.get(i + 2).getVal() != -1) {
        exparr.remove(i);
        exparr.add(i, new Exp(exparr.get(i), exparr.get(i + 1), op));
        exparr.remove(i + 1);
        exparr.remove(i + 1);
      }
    }

    System.out.println();
    System.out.println();
    System.out.println("FINAL RESULT:");
    System.out.println(exparr.get(0).getVal());
  }

}
