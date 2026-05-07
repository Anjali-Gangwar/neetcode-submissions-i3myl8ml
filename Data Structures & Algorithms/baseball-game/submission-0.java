

class Solution {
    public int calPoints(String[] operations) {

            Stack<Integer> stack = new Stack<>();

                    for(String op : operations) {

                                // Case 1: "+"
                                            if(op.equals("+")) {

                                                            int top = stack.pop();
                                                                            int newScore = top + stack.peek();

                                                                                            stack.push(top);
                                                                                                            stack.push(newScore);
                                                                                                                        }

                                                                                                                                    // Case 2: "D"
                                                                                                                                                else if(op.equals("D")) {

                                                                                                                                                                stack.push(2 * stack.peek());
                                                                                                                                                                            }

                                                                                                                                                                                        // Case 3: "C"
                                                                                                                                                                                                    else if(op.equals("C")) {

                                                                                                                                                                                                                    stack.pop();
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                            // Case 4: Number
                                                                                                                                                                                                                                                        else {

                                                                                                                                                                                                                                                                        stack.push(Integer.parseInt(op));
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                    int sum = 0;

                                                                                                                                                                                                                                                                                                            while(!stack.isEmpty()) {
                                                                                                                                                                                                                                                                                                                        sum += stack.pop();
                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                        return sum;
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            }