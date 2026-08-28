class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return answer;
    }

    private void backtrack(int index,
                           int[] nums,
                           List<Integer> currentSubset) {

        if (index == nums.length) {

            answer.add(new ArrayList<>(currentSubset));

            return;
        }

        // Take

        currentSubset.add(nums[index]);

        backtrack(index + 1, nums, currentSubset);

        // Undo

        currentSubset.remove(currentSubset.size() - 1);

        // Don't Take

        backtrack(index + 1, nums, currentSubset);
    }
}