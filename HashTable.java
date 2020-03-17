import sun.jvm.hotspot.utilities.HashtableEntry;

public interface Entry<K,V>{
    public K getKey();
    public V getValue();
}


public class HashTable<K, V> implements Entry<K,V>{
    protected K key;
    protected V value;

    public HashEntry(K k, V v){
        key = k;
        value = v;
    }

    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }

    public V setValue(V newValue){
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public boolean equals(Objecty o){
        HashEntry entry;

        try{
            entry =(HashEntry) o; 
        }
        catch (ClassCastException exep){
            return false;
        }
        return (entry.getKey() == key) && (entry.getValue() == value);
    }

    public String toString(){
        return "(" + key + "," + value + ")";
    }

    public void out(K key, V value){
        Entry<K, V> entry = new Entry<>(key, value);
        int bucket = getHash(key) % getBucketSize();
    }

    // private static int size = 16;
    // private HashtableEntry[] entries = new HashtableEntry(size);

    // public void put(String key, String value){
    //     int hash = getHash(key);
    //     final HashtableEntry hashEntry = new HashtableEntry(key,value);
    //     if(entries[hash] == null){
    //         entries[hash] = hashEntry;
    //     }
    //     else{
    //         HashtableEntry temp = entries[hash];
    //         while(temp.next != null){

    //         }
    //     }
    // }

}