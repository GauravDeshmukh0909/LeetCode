/*
3355. Zero Array Transformation I
Attempted
Medium
Topics
Companies
Hint

You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

    Select a 

    of indices within the range [li, ri] in nums.
    Decrement the values at the selected indices by 1.

A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

 

Example 1:

Input: nums = [1,0,1], queries = [[0,2]]

Output: true

Explanation:

    For i = 0:
        Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
        The array will become [0, 0, 0], which is a Zero Array.

Example 2:

Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]

Output: false

Explanation:

    For i = 0:
        Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
        The array will become [4, 2, 1, 0].
    For i = 1:
        Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
        The array will become [3, 1, 0, 0], which is not a Zero Array.

 

Constraints:

    1 <= nums.length <= 105
    0 <= nums[i] <= 105
    1 <= queries.length <= 105
    queries[i].length == 2
    0 <= li <= ri < nums.length


*/



brute force takes : O(qN) time 

  
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=queries.length;
        
        for(int i=0;i<n;i++){
            int start=queries[i][0];
            int last=queries[i][1];

            for(int j=start;j<=last;j++){
                if(nums[j]>0){
                    nums[j]-=1;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return false;
            }
        }

        return true;
    }
}


below method take : O(N) time 

(difference array method ) 

  
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;

        int diff[]=new int[n+1];

        for(int i=0;i<queries.length;i++){
            int st=queries[i][0];
            int end=queries[i][1];

            diff[st]+=1;                          // st me increase karo aur end+1 me decrease karo 
            diff[end+1]-=1;
        }

        int prefixsum=0;

        for(int i=0;i<n;i++){
            prefixsum+=diff[i];
            if(prefixsum<nums[i]) return false;
        }

        return true;
    }
}

