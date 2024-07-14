class Solution {
    public static int diagonalPrime(int[][] nums) {
        Set<Integer> arr = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            arr.add(nums[i][i]);
        for (int i = nums.length - 1; i >= 0; i--)
            arr.add(nums[i][nums.length - 1 - i]);
        
        int max = Integer.MIN_VALUE;
        for (int i : arr)
        {
            if (isPrime(i) && i > max)
                max = i;
        }
        if (max == Integer.MIN_VALUE)
            return 0;
        return max;

    }
    
    public static boolean isPrime(int n)
    {
        if (n == 2)
            return true;
        else if (n % 2 == 0 || n == 1)
            return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i+=2)
            if (n % i == 0)
                return false;
        return true;
    }
}