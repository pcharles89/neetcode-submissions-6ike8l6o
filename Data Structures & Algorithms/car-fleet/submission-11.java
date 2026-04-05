class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] cars = new int[length][2];

        for(int i = 0; i < length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for(int i = 0; i < length; i++){
            int pos = cars[i][0];
            int spd = cars[i][1];

            double time = (double)(target - pos) / spd;

            if(stack.isEmpty() || time > stack.peekLast()){
                stack.addLast(time);
            }
        }
        return stack.size();
    }
}
