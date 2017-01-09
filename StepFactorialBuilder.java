import java.math.BigInteger;

public class StepFactorialBuilder
{
    private BigInteger f, l, s, m;

    public StepFactorialBuilder first(BigInteger x)
    {
        f = x;
        return this;
    }

    ///*
    public StepFactorialBuilder first(Integer x)
    {
        f = BigInteger.valueOf(x);
        return this;
    }
    //*/

    public StepFactorialBuilder last(BigInteger x)
    {
        l = x;
        return this;
    }

    public StepFactorialBuilder step(BigInteger x)
    {
        s = x;
        return this;
    }

    ///*
    public StepFactorialBuilder step(Integer x)
    {
        s = BigInteger.valueOf(x);
        return this;
    }
    //*/

    public StepFactorialBuilder mod(BigInteger x)
    {
        m = x;
        return this;
    }

    public StepFactorial build()
    {
        return new StepFactorial(f, l, s, m);
    }
}
