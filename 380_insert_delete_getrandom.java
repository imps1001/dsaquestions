class RandomizedSet {

    List<Integer> list;
    HashMap<Integer, Integer> map; 
    java.util.Random rand = new java.util.Random();
    
    public RandomizedSet() {
        
        list = new ArrayList<>();
        map = new HashMap<>();
        
    }
    
    public boolean insert(int val) {
        
        if(map.get(val) != null)
            return false;
        
        int size = list.size();
        map.put(val, size);
        list.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        
        if(map.get(val) == null)
            return false;
        
        int size = list.size();
        Integer last = list.get(size-1);
        
        Integer index = map.get(val);
        
        if(index < list.size()-1){
            Collections.swap(list, index, size-1);            
            map.put(last, index);
        }
        
        list.remove(size-1);
        map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        
        
        
        int x = rand.nextInt(list.size());
        return list.get(x);
    }
}
