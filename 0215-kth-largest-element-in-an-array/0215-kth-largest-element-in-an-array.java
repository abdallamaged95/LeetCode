class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        for (int i = 0; i < k-1; i++) {
            q.poll();
        }
        return q.peek();
    }
}