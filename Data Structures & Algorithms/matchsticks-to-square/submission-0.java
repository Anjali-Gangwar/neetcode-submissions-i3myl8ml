
class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);

        // Descending order
        reverse(matchsticks);

        int[] sides = new int[4];

        return backtrack(0, matchsticks, sides, target);
    }

    private boolean backtrack(int idx, int[] matchsticks,
                              int[] sides, int target) {

        if (idx == matchsticks.length) {

            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[idx];

        for (int i = 0; i < 4; i++) {

            if (sides[i] + stick > target) {
                continue;
            }

            sides[i] += stick;

            if (backtrack(idx + 1, matchsticks, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            // Optimization
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}