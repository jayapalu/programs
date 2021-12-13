/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 *
 * https://leetcode.com/problems/maximize-distance-to-closest-person/description/
 *
 * algorithms
 * Medium (44.89%)
 * Likes:    1659
 * Dislikes: 144
 * Total Accepted:    126.3K
 * Total Submissions: 281.4K
 * Testcase Example:  '[1,0,0,0,1,0,1]'
 *
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the i^th seat, and seats[i] = 0 represents
 * that the i^th seat is empty (0-indexed).
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized. 
 * 
 * Return that maximum distance to the closest person.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation: 
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest
 * person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation: 
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats
 * away.
 * This is the maximum distance possible, so the answer is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: seats = [0,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= seats.length <= 2 * 10^4
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 * 
 * [0,0,0,1,0,0,0,1]
 *  [1,0,0,1,0,0,0,1,0,0,0,0,0]
 * [1,0,0,1]
 * [0,0,1,0,0,0]
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int zc = 0;

        int i =0;
        // 0001
        while(seats[i] != 1 && i < seats.length) {
            zc++;   
            i++;
        }
        max = zc;
        i++;
        zc = 0;

        // 1 0000 1
        while(i < seats.length){
            //System.out.println("i= "+i +" seats[i]= "+seats[i]);

            //101 & 1000
            // when 1 seen then calcute the max distance
            if(seats[i] == 1) {

                // 101 case
                if(zc == 1){
                    max = Math.max(max, zc);
                    //System.out.println("zc=1 case zc count = 1 max = "+max);
                    zc = 0;
                }else {
                    boolean even = zc%2 == 0;

                    if(even) {
                        max = Math.max(max, zc/2);
                        //System.out.println("    zc even zc= "+ zc + " and max "+ max);
                    }else{
                        //System.out.println("    zc odd zc= "+ zc + " and max "+ max);
                        max = Math.max(max, zc/2+1);
                    }
                    zc = 0;
                }
            }
            //increse zeros only when there is zero 
            if(seats[i] == 0){
                zc++;
            }
            //System.out.println("        zc = "+zc);  
            i++; 
        }


        //1000
        if(i == seats.length && seats[i-1] == 0){
            max = Math.max(max, zc);
            //System.out.println("        last zero zc= "+ zc + " and max "+ max);
        }

        return max;
        
    }
}
// @lc code=end

