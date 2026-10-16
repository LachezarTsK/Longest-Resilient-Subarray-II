
import kotlin.math.max

class Solution {

    fun resilientSubarray(input: IntArray, targetDivisor: Int): Int {
        var back = 0
        var sum: Long = input[0].toLong()
        var maxSizeResilientSubarray = 1
        var previousRemainder = input[0] % targetDivisor

        for (front in 1..<input.size) {
            if (input[front] % targetDivisor != previousRemainder) {
                previousRemainder = input[front] % targetDivisor
                back = front
                sum = input[front].toLong()
                continue
            }
            if (sum % targetDivisor.toLong() == 0L) {
                maxSizeResilientSubarray = Math.max(maxSizeResilientSubarray, front - back + 1)
            }
            sum += input[front]
        }

        return maxSizeResilientSubarray
    }
}
