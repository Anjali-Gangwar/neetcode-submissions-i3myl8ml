class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while(left < right){
            int ht = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = ht * width;

            maxWater = Math.max(maxWater, area);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxWater;
    }
}
