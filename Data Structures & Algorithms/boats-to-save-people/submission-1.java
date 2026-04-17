class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int curr_wt = 0;
        int boats = 0;

        while(left <= right){
            curr_wt = people[right--];
            if(curr_wt + people[left] <= limit){
                left++;
            }
            boats++;
        }

        return boats;
    }
}