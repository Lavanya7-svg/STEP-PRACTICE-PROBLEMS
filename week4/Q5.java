import java.util.Arrays;

public class Q5 {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // reduce unnecessary rotations
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] rotated = rotateArray(nums, 3);
        System.out.println(Arrays.toString(rotated)); // [5,6,7,1,2,3,4]
    }
}
