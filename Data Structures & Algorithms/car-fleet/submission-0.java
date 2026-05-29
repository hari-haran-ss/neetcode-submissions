class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int len = position.length;
       if(len <= 1)
        return len;
       Point[] arr = new Point[len];
       for(int i=0; i<len; i++){
        arr[i] = new Point(position[i], speed[i], (double)(target - position[i])/speed[i]);
       }
       Arrays.sort(arr, (a,b) -> b.position - a.position);
       Stack<Point> stack = new Stack<>();
       for(int i=0; i<len; i++){
        stack.push(arr[i]);
        while(!stack.isEmpty() && stack.size() >= 2 && stack.peek().milesToTarget <= stack.get(stack.size()-2).milesToTarget)
            stack.pop();
       }
       return stack.size();
    }
}

class Point{
    int position;
    int speed;
    double milesToTarget;
    public Point(int position, int speed, double milesToTarget){
        this.position = position;
        this.speed = speed;
        this.milesToTarget = milesToTarget;
    }
}
