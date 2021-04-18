package hashtable;

import org.junit.jupiter.api.Test;
import section.HashTable;

public class HashTableTest {
    @Test
    public void hash(){
        HashTable hashTable = new HashTable();
        hashTable.hash("orangered", 10);
    }
}
