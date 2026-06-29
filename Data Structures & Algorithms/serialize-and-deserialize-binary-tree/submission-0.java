/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

        // Serialize
            public String serialize(TreeNode root) {
                    StringBuilder sb = new StringBuilder();
                            dfs(root, sb);
                                    return sb.toString();
                                        }

                                            private void dfs(TreeNode node, StringBuilder sb) {
                                                    if (node == null) {
                                                                sb.append("N,");
                                                                            return;
                                                                                    }

                                                                                            sb.append(node.val).append(",");
                                                                                                    dfs(node.left, sb);
                                                                                                            dfs(node.right, sb);
                                                                                                                }

                                                                                                                    // Deserialize
                                                                                                                        private int index;

                                                                                                                            public TreeNode deserialize(String data) {
                                                                                                                                    String[] arr = data.split(",");
                                                                                                                                            index = 0;
                                                                                                                                                    return build(arr);
                                                                                                                                                        }

                                                                                                                                                            private TreeNode build(String[] arr) {
                                                                                                                                                                    if (arr[index].equals("N")) {
                                                                                                                                                                                index++;
                                                                                                                                                                                            return null;
                                                                                                                                                                                                    }

                                                                                                                                                                                                            TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
                                                                                                                                                                                                                    root.left = build(arr);
                                                                                                                                                                                                                            root.right = build(arr);

                                                                                                                                                                                                                                    return root;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        }
