class Solution {
    public int primeSubarray(int[] nums, int k) {
        int[] prime = primeNumbers();

        // queue for runtime min & max
        Deque<Integer> minDQ = new ArrayDeque<>(); // monotonic
        Deque<Integer> maxDQ = new ArrayDeque<>(); // monotonic
        Deque<Integer> primeDQ = new ArrayDeque<>();

        int left = 0; // valid window index
        int prevPrime = 0; // index of second last prime index
        
        int result = 0; // our result -- count of valid subarray

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int ele = nums[i];

            // curr ele is prime
            if(prime[ele] == 1) {
                insertPrimeDQ(minDQ, maxDQ, nums, i);
                if(!primeDQ.isEmpty()) prevPrime = primeDQ.peekLast(); 
                primeDQ.addLast(i);

                // validate window
                while(nums[maxDQ.peekFirst()] - nums[minDQ.peekFirst()] > k) {
                    // remove first prime present in current window
                    int tempInx = primeDQ.removeFirst();
                    left = tempInx + 1; // may be next window is valid

                    // remove form Dequeue
                    if(minDQ.peekFirst() <= tempInx) minDQ.removeFirst();
                    if(maxDQ.peekFirst() <= tempInx) maxDQ.removeFirst();
                }
            }

            if(primeDQ.size() >= 2) {
                result += prevPrime - left + 1;
            }
        }

        return result;
    }

    public int[] primeNumbers() {
        int MAX_NUM = (int) 1e4;
        int[] prime = new int[5 * MAX_NUM + 1];
        int n = prime.length;

        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;

        // start from 2
        for(int i = 2; i < n; i++) {
            if(i%2 == 0 && i > 2) continue;
            
            for(int candidate = 2*i; candidate < n; candidate += i) prime[candidate] = 0;
        }

        return prime;
    }

    public void insertPrimeDQ(Deque<Integer> minDQ, Deque<Integer> maxDQ, int[] nums, int inx) {
        
        while(!minDQ.isEmpty() && nums[minDQ.peekLast()] > nums[inx]) minDQ.removeLast();
        minDQ.addLast(inx);

        while(!maxDQ.isEmpty() && nums[maxDQ.peekLast()] < nums[inx]) maxDQ.removeLast();
        maxDQ.addLast(inx);
    }

}