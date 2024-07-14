class Solution {
    public boolean isThree(int n)
    {
        int x = (int)Math.sqrt(n);
        if (x*x == n && isPrime(x))
            return true;
        return false;
    }

    public boolean isPrime(int n)
    {
        if (n == 2)
            return true;
        if (n % 2 == 0 || n == 1)
            return false;

        for (int i = 3; i < n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}