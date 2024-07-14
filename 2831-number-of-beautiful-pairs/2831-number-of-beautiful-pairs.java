class Solution {
    public static int countBeautifulPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (GCD(Integer.toString(nums[i]).charAt(0) - '0', nums[j] % 10) == 1)
                    cnt++;
            }
        }
        return cnt;
    }

    public static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}