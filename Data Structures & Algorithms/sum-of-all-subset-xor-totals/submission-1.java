class Solution {
        // static int sum = 0;

            public int subsetXORSum(int[] nums) {
                    return backtrack(nums,0,0);

                        }

                            public static int backtrack(int[] nums,int i,int XOR){
                                    if (i>=nums.length){
                                                return XOR;
                                                        }

                                                                return backtrack(nums,i+1,XOR^nums[i]) + backtrack(nums,i+1,XOR);
                                                                    }
                                                                    }