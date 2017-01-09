import java.math.BigInteger;

public class StepFactorial implements Runnable
{
    private BigInteger f, l, s, p, r;

    public StepFactorial(BigInteger first, BigInteger last, BigInteger step, BigInteger mod)
    {
        f = first;
        l = last;
        s = step;
        p = mod;
        r = BigInteger.ONE;
    }

    public void run()
    {
        BigInteger x = f;
        while(l.compareTo(x) >= 0)
        {
            r = r.multiply(x).mod(p);
            x = x.add(s);
        }
    }

    public BigInteger result()
    {
        return r;
    }

    public String toString()
    {
        return String.format("[first: %s] [last: %s] [step: %s] [mod: %s]", f.toString(), l.toString(), s.toString(), p.toString());
    }

    public void print()
    {
        System.out.println(this);
    }
}
