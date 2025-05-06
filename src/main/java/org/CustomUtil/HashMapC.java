package org.CustomUtil;
import java.util.*;

public class HashMapC<K extends Comparable<K>, V> extends HashMap<K, V> {
    public HashMapC() {
        super();
    }

    public void putSort(K key, V value) {
        if (this.isEmpty()) {
            this.put(key, value);
            System.out.println(this);
            return;
        }

        List<K> returned = new ArrayList<>(this.keySet());
        ListIterator<K> iter  = returned.listIterator();

        while(iter.hasNext()) {
            K curr = iter.next();
            System.out.println(curr + " compared to " + key);
            int compare  = curr.compareTo(key);
            System.out.println(compare);

            if (compare > 0) {
                iter.previous();
                iter.add(key);
                this.put(key, value);
                System.out.println(this);
                return;

            }
        }

        iter.add(key);
        this.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<K> keys = new ArrayList<>(this.keySet());
        ListIterator<K> iter = keys.listIterator();

        while(iter.hasNext()) {
            K curr = iter.next();
            sb.append(curr.toString());
            sb.append(": ");
            sb.append(this.get(curr).toString());

            if (iter.hasNext()) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        HashMapC<String, String> map = new HashMapC<>();
        map.putSort("apple", "red");
        map.putSort("banana", "yellow");
        map.putSort("cherry", "red");
        map.putSort("avocado", "green");
        System.out.println(map); // Output: apple: red, avocado: green, banana: yellow, cherry: red
    }
}
