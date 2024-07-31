package coding.interview.algorithm.dynamicprogramming;

// leetCode
// 198. House Robber
public class Robber {
    public int rob(int[] nums) {
        int[] arr = new int[nums.length];

        if(nums.length == 1) return nums[0];

        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);

        if(nums.length > 2){
            for(int i = 2; i < nums.length; i++){
                arr[i] = Math.max(arr[i-1], arr[i-2] + nums[i]);
            }
        }

        return arr[nums.length - 1];
    }

    public static void main(String[] args) {
        Robber solution = new Robber();
        int result = solution.rob(new int[]{2, 7, 9, 3, 1, 4});
        System.out.println("result = " + result);
    }
}
