package memory.hash;

import java.util.Arrays;

public class Hash_String {
    int[] element;
    public Hash_String(){
        element = new int[26];
    }

    //key为26个字母,index用来存储在字符中的下标
    public void addElement(char key, int index) {
        if (key >= 97) {
            element[key - 97] = index;
        }
    }

    public void PrintfString() {
        System.out.println(Arrays.toString(element));
    }

    public int getElement(char key) {
        return element[key-97];
    }
}
