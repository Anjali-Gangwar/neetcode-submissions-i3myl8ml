class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = maxArray(piles);
        int left = 1;
        while (left < right){
            int mid = left + (right - left)/2;
            int time = timeToEat(piles, mid);
            if (time > h){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return right;
    }
    public int maxArray(int[] array){
        //assume array not null
        int max = Integer.MIN_VALUE;
        for (int ele: array){
            if (ele>max){
                max = ele;
            }
        }
        return max;
    }
    public int timeToEat(int[] piles, int speed){
        int time = 0;
        for (int pile : piles){
            time += Math.ceilDiv(pile,speed);
        }
        return time;
    }
}
