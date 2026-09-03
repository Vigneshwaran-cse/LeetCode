class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();

        return backtrack(s, 0, dict, memo);
    }

    private List<String> backtrack(String s, int start,
                                   Set<String> dict,
                                   Map<Integer, List<String>> memo) {

        // If we reached the end, return an empty sentence
        if (start == s.length()) {
            return new ArrayList<>(Arrays.asList(""));
        }

        // Already calculated
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Try every possible word starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            // If word exists in dictionary
            if (dict.contains(word)) {

                List<String> remaining =
                        backtrack(s, end, dict, memo);

                for (String sentence : remaining) {

                    if (sentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sentence);
                    }
                }
            }
        }

        // Store result for this starting index
        memo.put(start, result);

        return result;
    }
}