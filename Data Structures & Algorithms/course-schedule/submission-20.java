class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            int course = prereq[0];
            int prerequisite = prereq[1];
            preMap.get(course).add(prerequisite);
        }

        Set<Integer> visiting = new HashSet<>();

        for(int course = 0; course < numCourses; course++){
            if(!dfs(course, preMap, visiting)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting){

        if(visiting.contains(course)){
            return false;
        }

        if(preMap.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);

        for(int prereq : preMap.get(course)){
            if(!dfs(prereq, preMap, visiting)){
                return false;
            }
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());

        return true;
    }
}
