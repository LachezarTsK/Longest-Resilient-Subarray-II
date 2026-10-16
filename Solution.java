
public class Solution {

    public int resilientSubarray(int[] input, int targetDivisor) {
        int back = 0;
        long sum = input[0];
        int maxSizeResilientSubarray = 1;
        int previousRemainder = input[0] % targetDivisor;

        for (int front = 1; front < input.length; ++front) {
            if (input[front] % targetDivisor != previousRemainder) {
                previousRemainder = input[front] % targetDivisor;
                back = front;
                sum = input[front];
                continue;
            }
            if (sum % targetDivisor == 0) {
                maxSizeResilientSubarray = Math.max(maxSizeResilientSubarray, front - back + 1);
            }
            sum += input[front];
        }

        return maxSizeResilientSubarray;
    }
}
