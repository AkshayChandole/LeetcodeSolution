package Stack.CarFleet;

import java.util.Arrays;
import java.util.Stack;

// *****************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] times = new float[target];

        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (float) (target - position[i]) / speed[i];
        }

        int result = 0;
        float prev = 0;

        for (int i = target - 1; i >= 0; i--) {
            float curr = times[i];
            if (curr > prev) {
                prev = curr;
                result++;
            }
        }

        return result;
    }
}

// *****************************************************************
// Solution 2 using Stack -

/**
 * Time Complexity - O(n*logn)
 * Space Complexity - O(n)
 */
class Solution2 {

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }
}


// *****************************************************************
// Solution 1 -

/**
 * Time Complexity - O(n*logn)
 * Space Complexity - O(n)
 */
class Car {
    public int pos;
    public double time;

    public Car(int pos, double time) {
        this.pos = pos;
        this.time = time;
    }
}

class Solution1 {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; ++i)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);

        Arrays.sort(cars, (a, b) -> b.pos - a.pos);

        double maxTime = 0; // The time of the slowest car to reach the target

        for (Car car : cars)
            // A car needs more time to reach the target, so it becomes slowest
            if (car.time > maxTime) {
                maxTime = car.time;
                ++ans;
            }

        return ans;
    }
}