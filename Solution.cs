
using System;

public class Solution
{
    public int ResilientSubarray(int[] input, int targetDivisor)
    {
        int back = 0;
        long sum = input[0];
        int maxSizeResilientSubarray = 1;
        int previousRemainder = input[0] % targetDivisor;

        for (int front = 1; front < input.Length; ++front)
        {
            if (input[front] % targetDivisor != previousRemainder)
            {
                previousRemainder = input[front] % targetDivisor;
                back = front;
                sum = input[front];
                continue;
            }
            if (sum % targetDivisor == 0)
            {
                maxSizeResilientSubarray = Math.Max(maxSizeResilientSubarray, front - back + 1);
            }
            sum += input[front];
        }

        return maxSizeResilientSubarray;
    }
}
