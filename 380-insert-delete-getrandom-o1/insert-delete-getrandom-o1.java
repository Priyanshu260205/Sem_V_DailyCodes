class RandomizedSet {
    List<Integer> li;
    HashMap<Integer, Integer> map;
    Random rm = new Random();

    public RandomizedSet() {
        li = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, li.size());
        li.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos = map.get(val);
        if(pos != (li.size() - 1)){
            int le = li.get(li.size() - 1);
            li.set(pos, le);
            map.put(le, pos);
        }
        map.remove(val);
        li.remove(li.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int random_int = rm.nextInt(li.size());
        return li.get(random_int);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */