
public class Solution{
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= n; i++) {
        int curHeight = (i == n ? 0 : heights[i]);
        while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
            int mid = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = i - left - 1;
            maxArea = Math.max(maxArea, mid * width);
        }
        stack.push(i);
    }
    return maxArea;
}
}

