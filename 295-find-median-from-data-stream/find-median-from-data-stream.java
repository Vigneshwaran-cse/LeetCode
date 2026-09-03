class MedianFinder {
    private PriorityQueue<Integer> left;  // max heap
    private PriorityQueue<Integer> right; // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to max heap first
        left.offer(num);

        // Step 2: Balance by moving largest from left to right
        right.offer(left.poll());

        // Step 3: Ensure left has equal or +1 size
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
