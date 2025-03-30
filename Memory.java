import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Memory {
    private final ConcurrentHashMap<String,Integer> memory;

    public Memory() {
        memory = new ConcurrentHashMap<String,Integer>(10);
    }

    
    public void set(String address, int value) {
        memory.put(address,value);
    }

    public int get(String address) {
        return  memory.getOrDefault(address, 0);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Memory: [");

        // Iterate over the entries in the memory HashMap
        for (HashMap.Entry<String, Integer> entry : memory.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }

        // Remove the last ", " if the map is not empty
        if (!memory.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]");
        return sb.toString();
    }

}
/*
 * 0,val
 * 1,val
 * 
 * a,vl
 * b,val
 */
