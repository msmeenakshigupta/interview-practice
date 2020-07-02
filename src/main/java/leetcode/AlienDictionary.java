class Solution {
    class Before {
        char a;
        char b;
        
        Before(char a, char b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public String alienOrder(String[] words) {
        List<Before> letterOrderings = new ArrayList<>();
        HashSet<Character> letters = new HashSet<Character>();
        for(int i = 0; i < words.length - 1; i++) {
            if(words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])) {
                return "";
            }
            
            defineOrdering(words[i], words[i+1], letterOrderings);
            
        }
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                letters.add(words[i].charAt(j));
            }
        }
        
        Map<Character, Set<Character>> letterAdjList = new HashMap<>();
        
        convertToAdjList(letterOrderings, letterAdjList);
        
        
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        Set<Character> temporarySeen = new HashSet<>();
        
        for(Character c : letters) {
            temporarySeen.clear();

            if(!dfs(c, sb, seen, temporarySeen, letterAdjList)) {
                return "";
            }
        }
        return sb.toString();
    }
    
	// topological sort DFS
	// https://en.wikipedia.org/wiki/Topological_sorting#Depth-first_search
    private boolean dfs(Character c, StringBuilder stack, Set<Character> seen, Set<Character> temporarySeen,Map<Character, Set<Character>> adjList) {
        if(seen.contains(c)) {
            return true;
        }
        
        if(temporarySeen.contains(c)) {
            return false;
        }
        
        temporarySeen.add(c);
        
        if(adjList.containsKey(c)) {
            Set<Character> nextChars = adjList.get(c);
            for(Character nextC : nextChars) {
                if(!dfs(nextC, stack, seen, temporarySeen, adjList)) {
                    return false;
                }
            }
        }
        
        temporarySeen.remove(c);
        seen.add(c);
        stack.append(c);
        return true;
    }
    
    public void defineOrdering(String before, String after, List<Before> orderings) {
        int minLength = Math.min(before.length(), after.length());
        for(int i = 0; i < minLength; i++) {
            if(before.charAt(i) != after.charAt(i)) {
                orderings.add(new Before(
                    before.charAt(i), after.charAt(i)
                ));
                return;
            }
        }
    }
    
    public void convertToAdjList(List<Before> orderings, Map<Character, Set<Character>> adjList) {
        for(Before before: orderings) {
            adjList.computeIfAbsent(before.b, (b) -> new HashSet<>());
            adjList.get(before.b).add(before.a);
        }
    }
}
