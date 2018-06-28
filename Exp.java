class Exp
{

  private Integer val;

  Exp(int n)
  {
    val = n;
  }

  Exp(Exp e1, Exp e2, Op op)
  {
    val = evaluate(e1.val, e2.val, op);
  }

  private int evaluate(int val1, int val2, Op op)
  {
    return op.getValue(val1, val2);
  }

  public Integer getVal()
  {
    return val;
  }

}
