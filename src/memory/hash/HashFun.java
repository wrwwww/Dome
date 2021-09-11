package memory.hash;
import java.util.Arrays;

public class HashFun {

    int[] array;

    public HashFun(){
       array =new int[100];
    }

    private void Map(int key, int index) {
            this.array[key]=index;
    }

    public void addIntKey(int index,int key){
        Map(key,index);
    }

    public int search(int key) {
        return array[key];
    }

    public void getArray() {
        System.out.println(Arrays.toString(array));
    }
}
