class Solution {
    public int maxArea(int[] heights) {
        int max_area = 0;
        int a_pointer = 0;
        int b_pointer = heights.length - 1;

        while(a_pointer < b_pointer){
            if(heights[a_pointer] < heights[b_pointer]){
                max_area = 
                Math.max(max_area, heights[a_pointer] * (b_pointer - a_pointer));
                a_pointer += 1;
            }
            else {
                max_area = Math.max(max_area, heights[b_pointer] * (b_pointer - a_pointer));
                b_pointer -= 1;
            }
        }

        return max_area;

    }
}
