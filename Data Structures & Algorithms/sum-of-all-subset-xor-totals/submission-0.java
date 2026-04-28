class Solution {
        public int subsetXORSum(int[] nums) {
                int or = 0;

                        // sabka OR nikaalo
                                for(int num : nums) {
                                            or |= num;
                                                    }

                                                            // multiply by 2^(n-1)
                                                                    return or * (1 << (nums.length - 1));
                                                                        }
                                                                        }
