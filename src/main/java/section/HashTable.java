package section;

/**
 * what is ? used to store key-value pairs and not ordered
 * unlike arrays, hash table is fast because it find by key (O(1) - constant time)
 *
 * what makes a good hash ?
 * 1. constant time
 * 2. distributed uniformly
 * 3. same input same output
 */

/**
 * what happen when there is a collision in key ?
 * 1. Separate Chaining - will create array inside an array to store that multiple value
 * 2. Linear Probing - search through the array to find the next empty slot
 *
 */
public class HashTable {
    /**
     * example basic hashfunction (not always like this)
     * v1 : linear time because we need to loop each char
     */
    public int hashV1(String key, int len){
        int total = 0;
        for(char chr : key.toCharArray()){
            int num = chr - 96;
            total = (total + num ) % len;
        }
        return total;
    }

    public int hashV2(String key, int len){
        int total = 0;
        for(char chr : key.toCharArray()){
            int num = chr - 96;
            total = (total + num ) % len;
        }
        return total;
    }
}
