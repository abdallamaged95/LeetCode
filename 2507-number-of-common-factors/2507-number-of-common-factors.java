class Solution {
    public static int commonFactors(int a, int b) {
        Set<Integer> f = new HashSet<>();
        int l1 = (int)Math.sqrt(a), l2 = (int)Math.sqrt(b);
        for (int i = 1; i <= l1; i++)
            if (a % i == 0)
            {
                f.add(i);
                f.add(a / i);
            }

        for (int i = 1; i <= l2; i++)
            if (b % i == 0)
            {
                f.add(i);
                f.add(b / i);
            }
        int factors = 0;
        for (Integer i : f)
        {
            if (a % i == 0 && b % i == 0)
                factors++;
        }
        return factors;
    }
}