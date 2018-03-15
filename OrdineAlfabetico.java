import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class OrdineAlfabetico {

  public static void main (String[] args)
  {
      String[] input = inputData();
  }

    static String[] inputData()
  {
      ArrayList<String> input = new ArrayList<String>();
      Scanner sc = new Scanner(System.in);
      int count = -1;

        do {
          System.out.println("Inserisci un vocabolo/numero: ");
          String data = sc.nextLine();
          data = data.trim();
          data = data.toLowerCase();
          input.add(data);
          count++;
      } while (!input.get(count).equals(""));

      String[] array = input.toArray(new String[0]);
      array = Arrays.copyOf(array, array.length - 1);
      return array;
  }

/*
    static String[] ordina(String[] data)
  {

  }
*/
}
