package ui;
import model.*;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, String> hashTable = new HashTable<>(10);
        hashTable.putValue(105, "Tom");
        hashTable.putValue(21, "Sana");
        hashTable.putValue(31, "Dinesh");
        System.out.println(hashTable.getSize());
        System.out.println(hashTable.getValue(31));
        System.out.println(hashTable.getValue(21));
        System.out.println(hashTable.getValue(90));
        System.out.println(hashTable.removeValue(21));
        System.out.println(hashTable.getSize());
    }

}