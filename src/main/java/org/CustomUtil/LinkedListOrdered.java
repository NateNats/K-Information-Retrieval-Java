package org.CustomUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Optional;

public class LinkedListOrdered<T extends Comparable<T>> extends LinkedList<T> {

    public boolean addSort(T val) {
        ListIterator<T> iter = this.listIterator();

        while(iter.hasNext()) {
            T curr = iter.next();
            int comp = (curr).compareTo(val);

            if (comp > 0) {
                iter.previous();
                iter.add(val);

                return true;
            }
        }
        iter.add(val);
        return false;
    }

    public ArrayList<T> getAll() {
        ArrayList<T> list = new ArrayList<>(this);

        return list;
    }

    public Optional<T> get(T val) {
        ListIterator<T> iter = this.listIterator();

        while(iter.hasNext()) {
            T curr = iter.next();
            int comp = curr.compareTo(val);

            if (comp > 0) {
                iter.previous();
                return Optional.of(iter.previous());
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListIterator<T> iter = this.listIterator();

        while (iter.hasNext()) {
            T curr = iter.next();
            sb.append(curr.toString());

            if (iter.hasNext()) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListOrdered<Document> listDocs = new LinkedListOrdered<>();


        Document[] docs = {
                new Document("example5.txt", 2),
                new Document("example.txt", 5),
                new Document("example3.txt", 7),
                new Document("example2.txt", 3),
                new Document("example4.txt", 1),
                new Document("example6.txt", 4)
        };

        for (Document doc : docs) {
            listDocs.addSort(doc);
        }

        Optional<Document> ambil = listDocs.get(new Document("example.txt", 5));
        System.out.println(ambil.get());
    }
}
