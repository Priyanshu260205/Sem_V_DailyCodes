/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int[] row : res){
            Arrays.fill(row, -1);
        }
        int i=0, j=0;
        int curr = 0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(head != null){
            res[i][j] = head.val;
            int newi = i + directions[curr][0];
            int newj = j + directions[curr][1];
            if(newi < 0 || newj < 0 || newi >= m || newj >= n || res[newi][newj] != -1){
                curr = (curr + 1) % 4;
            }
            i += directions[curr][0];
            j += directions[curr][1];
            head = head.next;
        }
        return res;
    }
}