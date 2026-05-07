

class Solution {
    public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

                    for(char ch : s.toCharArray()) {

                                // Open brackets
                                            if(ch == '(' || ch == '{' || ch == '[') {

                                                            stack.push(ch);
                                                                        }

                                                                                    // Close brackets
                                                                                                else {

                                                                                                                // Empty stack check
                                                                                                                                if(stack.isEmpty()) {
                                                                                                                                                    return false;
                                                                                                                                                                    }

                                                                                                                                                                                    char top = stack.peek();

                                                                                                                                                                                                    // Matching check
                                                                                                                                                                                                                    if((ch == ')' && top == '(') ||
                                                                                                                                                                                                                                       (ch == '}' && top == '{') ||
                                                                                                                                                                                                                                                          (ch == ']' && top == '[')) {

                                                                                                                                                                                                                                                                              stack.pop();
                                                                                                                                                                                                                                                                                              }

                                                                                                                                                                                                                                                                                                              else {
                                                                                                                                                                                                                                                                                                                                  return false;
                                                                                                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                                                                                      }

                                                                                                                                                                                                                                                                                                                                                                              // Final check
                                                                                                                                                                                                                                                                                                                                                                                      return stack.isEmpty();
                                                                                                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                                                                                          }
