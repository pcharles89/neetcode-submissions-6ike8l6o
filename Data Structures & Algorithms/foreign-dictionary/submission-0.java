class Solution {

    public String foreignDictionary(String[] words) {

        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Create every character as a node
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build directed edges from adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int minLength = Math.min(word1.length(), word2.length());

            // Invalid prefix case:
            // ["abc", "ab"]
            if (word1.length() > word2.length()
                    && word1.substring(0, minLength)
                            .equals(word2.substring(0, minLength))) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {

                    // Only add/count this edge once
                    if (adj.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        // Start BFS with all nodes that have no prerequisites
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        // Kahn's Algorithm
        while (!queue.isEmpty()) {

            char current = queue.poll();
            result.append(current);

            for (char neighbor : adj.get(current)) {

                indegree.put(
                        neighbor,
                        indegree.get(neighbor) - 1
                );

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we couldn't process every node, there is a cycle
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
