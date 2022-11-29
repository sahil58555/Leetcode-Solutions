class RandomizedSet {
    
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    
    public RandomizedSet() {
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        map.put(val,list.size());
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        
        if(!map.containsKey(val))
            return false;
        
        if(map.get(val)==list.size()-1)
        {
            map.remove(val);
            list.remove(list.size()-1);
        }
        else
        {
            int idx = map.get(val);
            int value = list.get(list.size()-1);
            
            list.set(idx,value);
            map.remove(val);
            list.remove(list.size()-1);
            map.put(value,idx);
        }
        
        return true;
    }
    
    public int getRandom() {
     
        int randomIndex = (int)Math.floor(Math.random()*list.size());
        
        return list.get(randomIndex); 
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */