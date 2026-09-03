class MedianFinder {
     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
        }
        else if(num <= maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
           return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
           return maxHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */