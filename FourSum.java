import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// Problem: Four Sum
// Given an array nums of n integers, return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
// such that 0 <= a, b, c, d < n, and nums[a] + nums[b] + nums[c] + nums[d] == target.
// The solution should avoid duplicate quadruplets.
public class FourSum {
    
    // ----------------------------------------------------------------
    // 🧮 Brute Force Approach
    // ----------------------------------------------------------------
    // Time Complexity: O(n^4)
    // Space Complexity: O(n^4) due to storing all combinations in the HashSet
    // Explanation:
    // - Use 4 nested loops to explore every possible quadruplet.
    // - Check if the sum equals target.
    // - Sort each quadruplet and store it in a HashSet to avoid duplicates.
    // ----------------------------------------------------------------
    // static List<List<Integer>> FourSum(int[] arr, int target) {
    //     int n = arr.length;
    //     HashSet<List<Integer>> st = new HashSet<>(); // TC -> on avg -> O(1), and on worst case -> O(Log(m))

    //     // TC -> O(n^4)
    //     // SC -> O(n^4)
    //     for (int i=0; i<n; i++) { // TC -> O(n)
    //         for (int j=i+1; j<n; j++) { // TC -> O(n)
    //             for (int k=j+1; k<n; k++) { // TC -> O(n)
    //                 for (int l=k+1; l<n; l++) { // TC -> O(n)
    //                     long sum = arr[i] + arr[j];
    //                     sum += arr[k];
    //                     sum += arr[l];
    //                     if (sum == target) {
    //                         List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
    //                         Collections.sort(temp); // (m Log(m)) where m = 4
    //                         st.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }


    // ----------------------------------------------------------------
    // ⚙️ Better Approach (Using HashSet to store the 4th element)
    // ----------------------------------------------------------------
    // Time Complexity: O(n^3)
    // Space Complexity: O(n) for HashSet + O(n^3) for storing results
    // Explanation:
    // - Fix the first two numbers (i, j).
    // - For the remaining subarray, use a HashSet to find the fourth number
    //   such that arr[i] + arr[j] + arr[k] + fourth == target.
    // - Use a HashSet of lists to avoid duplicate quadruplets.
    // ----------------------------------------------------------------

    // static List<List<Integer>> FourSum(int[] arr, int target) {
    //     int n = arr.length;
    //     HashSet<List<Integer>> st = new HashSet<>(); // TC -> on avg -> O(1), and on worst case -> O(Log(m))
    //     // TC -> O(n^3)
    //     for (int i=0; i<n; i++) { // TC -> O(n)
    //         for (int j=i+1; j<n; j++) { // TC -> O(n)
    //             HashSet<Long> hashSt = new HashSet<>(); // TC -> O(Log(n))
    //             for (int k=j+1; k<n; k++) { // TC -> O(n)
    //                 long sum = arr[i] + arr[j] + arr[k];
    //                 long fourth = target - sum;
    //                 if (hashSt.contains(fourth)) {
    //                     List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int)fourth);// TC -> O(4)
    //                     Collections.sort(temp); // (m Log(m)) where m = 4
    //                     st.add(temp);
    //                 }
    //                 hashSt.add((long)arr[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }


    // ----------------------------------------------------------------
    // 🚀 Optimal Approach (Two-Pointer after Sorting)
    // ----------------------------------------------------------------
    // Time Complexity: O(n^3) + O(n log n) (for sorting)
    // Space Complexity: O(1) (ignoring output list)
    // Explanation:
    // - Sort the array to easily skip duplicates and use two-pointer optimization.
    // - Fix the first two indices (i, j) and then apply the two-pointer technique
    //   for the remaining elements (k, l).
    // - Move pointers based on the current sum compared to the target.
    // - Skip duplicates to ensure unique quadruplets.
    // ----------------------------------------------------------------
    static List<List<Integer>> FourSum(int[] arr, int target) {
        // TC -> O(nLog(n))
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        // TC -> O(n^3)
        for (int i=0; i<n; i++) { // TC -> O(n)
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j=i+1; j<n; j++) { // TC -> O(n)
                if (j!=i+1 && arr[j] == arr[j-1])continue;
                int k = j+1;
                int l = n-1;
                while (k < l) { // TC -> O(n)
                    long sum = arr[i] + arr[j];
                    sum += arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k-1]) k++;
                        while (k < l && arr[l] == arr[l+1]) l--;
                    }
                    else if (sum < target) k++;
                    // sum > target
                    else l--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        int target = 8;

        List<List<Integer>> ans = FourSum(arr,target);
        System.out.println(ans);
    }

}
