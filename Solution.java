import java.util.*;
public class Solution {
  
    // Helper function for finding the paths
    public void helper(int[][] mat, int row, int col, String path, List<String> ans) 
    {
        
        int n = mat.length;
 
        // Base case for invalid cell or out-of-bounds
        if (row < 0 || col < 0 || row >= n || col >= n || mat[row][col] == 0 || mat[row][col] == -1) {
            return;
        }

        mat[row][col] = 0;
     
        helper(mat, row + 1, col, path + "D", ans); // Down
        helper(mat, row - 1, col, path + "U", ans); // Up
        helper(mat, row, col - 1, path + "L", ans); // Left
        helper(mat, row, col + 1, path + "R", ans); // Right

        // Backtrack: Unmark the cell as visited
        mat[row][col] = 1;
      
        // If destination is reached, add the path to the result
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

    }

    // Function to find all paths from top left to bottom right
    public List<String> findPath(int[][] mat) {
        List<String> ans = new ArrayList<>();
        String path = "";

        helper(mat, 0, 0, path, ans);
        
        return ans;
    }

    public static void main(String[] args) {
        // Test case setup
        Solution solution = new Solution();
        
        // Example input matrix (1 represents open path, 0 represents blocked)
        int[][] mat = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        // Finding the paths
        List<String> result = solution.findPath(mat);

        // Printing the result
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (String path : result) {
                System.out.println(path);
            }
        }
    }
}
