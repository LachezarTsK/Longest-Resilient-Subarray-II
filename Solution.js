
/**
 * @param {number[]} input
 * @param {number} targetDivisor
 * @return {number}
 */
var resilientSubarray = function (input, targetDivisor) {
    let back = 0;
    let sum = input[0];
    let maxSizeResilientSubarray = 1;
    let previousRemainder = input[0] % targetDivisor;

    for (let front = 1; front < input.length; ++front) {
        if (input[front] % targetDivisor !== previousRemainder) {
            previousRemainder = input[front] % targetDivisor;
            back = front;
            sum = input[front];
            continue;
        }
        if (sum % targetDivisor === 0) {
            maxSizeResilientSubarray = Math.max(maxSizeResilientSubarray, front - back + 1);
        }
        sum += input[front];
    }

    return maxSizeResilientSubarray;
};
