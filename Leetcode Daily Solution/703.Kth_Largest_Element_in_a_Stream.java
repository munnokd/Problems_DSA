class KthLargest {
  private PriorityQueue<Integer> heap = new PriorityQueue<>();
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (var n : nums) add(n);
  }
  
  public int add(int val) {
    heap.offer(val);
    if (heap.size() > k) heap.poll();
    return heap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
