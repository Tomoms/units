import java.util.ArrayList;

class CambiaMonete
{

  static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
  static int[] tagli = {1, 2, 5, 10, 20, 50, 100, 200};
  static int val;

  static int somma(ArrayList<Integer> arr, int n)
  {
    int s = n;
    if (arr.size() > 0) {
      for (Integer i : arr)
        s += i;
    }
    return s;
  }

  static int getIndex(int[] arr, int el)
  {
    for (int i = 0; i < arr.length; i++) {
      if (el == arr[i])
        return i;
    }
    return -1;
  }

  static void comboGen(ArrayList<Integer> combo, int si)
  {
    if (si == -1)
      return;

    int cs = somma(combo, tagli[si]);
    int nsi;
    if (cs < val) {
      combo.add(tagli[si]);
      comboGen(combo, si);
    } else if (cs > val) {
      comboGen(combo, --si);
    } else {
      combo.add(tagli[si]);
      System.out.println(combo.toString());
      res.add(combo);
      int tbr = combo.size() - 1;
      while (tbr > 0 && combo.get(tbr) == 1) {
        combo.remove(tbr);
        tbr--;
      }
      int rim = combo.get(tbr);
      combo.remove(tbr);
      nsi = getIndex(tagli, rim) - 1;
      comboGen(combo, nsi);
    }
  }

  public static void main(String[] args)
  {
    int si = -1;
    val = Integer.parseInt(args[0]);
    for (int i = 0; i < tagli.length; i++) {
      if (tagli[i] <= val)
        si = i;
    }
    comboGen(new ArrayList<Integer>(), si);
    //for (ArrayList<Integer> arr : res)
    //  System.out.println(arr.toString());
  }

}
