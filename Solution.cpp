
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
    int resilientSubarray(vector<int>& input, int targetDivisor) {
        int back = 0;
        long long sum = input[0];
        int maxSizeResilientSubarray = 1;
        int previousRemainder = input[0] % targetDivisor;

        for (int front = 1; front < input.size(); ++front) {
            if (input[front] % targetDivisor != previousRemainder) {
                previousRemainder = input[front] % targetDivisor;
                back = front;
                sum = input[front];
                continue;
            }
            if (sum % targetDivisor == 0) {
                maxSizeResilientSubarray = max(maxSizeResilientSubarray, front - back + 1);
            }
            sum += input[front];
        }

        return maxSizeResilientSubarray;
    }
};
