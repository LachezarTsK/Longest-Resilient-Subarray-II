
package main

func resilientSubarray(input []int, targetDivisor int) int {
    back := 0
    sum := int64(input[0])
    maxSizeResilientSubarray := 1
    previousRemainder := input[0] % targetDivisor

    for front := 1; front < len(input); front++ {
        if input[front] % targetDivisor != previousRemainder {
            previousRemainder = input[front] % targetDivisor
            back = front
            sum = int64(input[front])
            continue
        }
        if sum % int64(targetDivisor) == 0 {
            maxSizeResilientSubarray = max(maxSizeResilientSubarray, front - back + 1)
        }
        sum += int64(input[front])
    }

    return maxSizeResilientSubarray
}
