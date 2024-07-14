class Solution {
    public int addDigits(int num) {
        if (num / 10 == 0)
            return num;
        int x = 0, y = num;
        while (y != 0)
        {
            x += y % 10;
            y /= 10;
        }
        return addDigits(x);
    }
}