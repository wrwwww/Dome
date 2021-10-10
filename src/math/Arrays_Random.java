package math;

public class Arrays_Random {
    private int[] array;
    public Arrays_Random(int[] nums){
        this.array =nums;
    }
    public void toRandom(int n){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000) % n;
        }
    }

    public int[] getArray() {
        return array;
    }
}
