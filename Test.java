import java.math.BigInteger;

class Test
{
    public static final BigInteger one = BigInteger.ONE;

    public static BigInteger modfact1(BigInteger n, BigInteger p)
    {
        BigInteger r = one;
        BigInteger x = n;
        while(x.compareTo(one) > 0)
        {
            r = r.multiply(x).mod(p);
            x = x.subtract(one);
        }
        return r;
    }

    public static BigInteger modfact2(BigInteger n, BigInteger p, int t) throws InterruptedException
    {
        Thread[] threads = new Thread[t];
        StepFactorial[] runs = new StepFactorial[t];
        StepFactorialBuilder builder = new StepFactorialBuilder();
        for(int i=1; i<=t; i++)
        {
            runs[i-1] = builder.first(i).last(n).step(t).mod(p).build();
            threads[i-1] = new Thread(runs[i-1]);
        }
        for(int i=0; i<t; i++)
            threads[i].start();
        for(int i=0; i<t; i++)
            threads[i].join();
        BigInteger r = one;
        for(int i=0; i<t; i++)
            r = runs[i].result().multiply(r).mod(p);
        return r;
    }

    public static void main(String[] args) throws InterruptedException
    {
        int t = 4;

        BigInteger n, p, r;
        p = BigInteger.valueOf(1000000007);
        n = BigInteger.valueOf(5000000);

        long t1, t2, dt1, dt2;

        t1 = System.currentTimeMillis();
        r = modfact1(n, p);
        t2 = System.currentTimeMillis();
        dt1 = t2 - t1;

        t1 = System.currentTimeMillis();
        r = modfact2(n, p, t);
        t2 = System.currentTimeMillis();
        dt2 = t2 - t1;

        System.out.printf("%s! = %s (mod %s)\n", n.toString(), r.toString(), p.toString());
        System.out.printf("%d threads: %d ms\n%d threads: %d ms\n", 1, dt1, t, dt2);
    }

}
