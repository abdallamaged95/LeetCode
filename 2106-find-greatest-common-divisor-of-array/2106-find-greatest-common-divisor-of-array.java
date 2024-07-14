class Solution {
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums)
        {
            if (n < min)
                min = n;
            if (n > max)
                max = n;
        }
        return GCD(min, max);
    }

    public static int GCD(int a, int b)
    {
        if (b == 0)
            return a;
        return GCD(b, a%b);
    }
}