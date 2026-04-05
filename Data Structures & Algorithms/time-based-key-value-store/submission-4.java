
class TimeMap {

    private static class Pair {
        int time;
        String value;
        Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null){
            return "";
        }

        int left = 0, right = list.size() - 1;
        int ansIndex = -1;

        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                ansIndex = mid;
                left = mid + 1;   
            } else {
                right = mid - 1;
            }
        }

        return ansIndex == -1 ? "" : list.get(ansIndex).value;
    }
}

