// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
        
//         int l = 0;
//         int r = numbers.length - 1;

//         while(l < r){

//             int sum = numbers[l] + numbers[r];

//             if(sum == target){
//                 return new int[]{l+1, r+1};

//             }else if(sum < target){
//                 l++;

//             }else{
//                 r--;

//             }
//         }
//         return new int[]{-1, -1};
//     }
// }

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while(l < r){

            if(numbers[l] == numbers[r]){
                continue;
            }

            int sum = numbers[l]+numbers[r];

            if(sum > target){
                r--;

            }else if(sum < target){
                l++;
                
            }else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{0,0};
    }
}

