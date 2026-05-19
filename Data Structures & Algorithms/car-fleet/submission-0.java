class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // pair bana rahe hain : position + speed
        int[][] cars = new int[n][2];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // position ke according sort
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        Stack<Double> st = new Stack<>();

        // peeche se traverse karenge
        for(int i = n - 1; i >= 0; i--) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            // time = distance / speed
            double time = (double)(target - pos) / spd;

            // current fleet ka time push
            st.push(time);

            // agar current car aage wali fleet ko catch kar sakti hai
            if(st.size() >= 2 && st.peek() <= st.get(st.size() - 2)) {

                // current fleet merge ho jayegi
                st.pop();
            }
        }

        return st.size();
    }
}