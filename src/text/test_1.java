package text;

import java.util.*;

public class test_1 {
    public static void main(String[] args) {
        Map<Integer, Integer> abcd = new HashMap<>();
        abcd.put(1, 0);
        abcd.put(95, 4);
        abcd.put(5, 6);
        abcd.put(2, 6);

        Set<Integer> cc=abcd.keySet();
        for (Integer num:cc
             ) {
            System.out.println(num+" "+abcd.get(num));
        }
//int[] jj=new int[1];
//jj[0]=1;
//int[] cc=new int[jj.length+1];
//System.arraycopy(jj,0,cc,0,jj.length);
//        System.out.println(Arrays.toString(cc));
    }
}
class SummaryRanges {
//     List<Integer> date;
    int[] date;



    public SummaryRanges() {
//        this.date = new LinkedList<>();
        date=new int[0];
    }

    public void addNum(int val) {
//        this.date.add(val);
        int[] sd=new int[date.length+1];
        if (date.length!=0)
        System.arraycopy(date,0,sd,0,date.length);
        date = sd;
        date[sd.length - 1] = val;
        Arrays.sort(date);
        //需要去重复
        if (date.length != 1) {
            int j=0;
            for (int i = 1; i < date.length; i++) {
                if (date[i] == date[j]) {
                    i++;
                }else {
                    date[++j]=date[i];
                }
            }
            int[] tempp=new int[j+1];
            System.arraycopy(date,0,tempp,0,j+1);
            date = tempp;
        }
    }

    public int[][] getIntervals() {

        List<int[]> temp=new LinkedList<>();
//        Map<Integer, Integer> abc = new HashMap<>();
        Map<Integer, Integer> abc = new TreeMap<>();
        Set<Integer> set = abc.keySet();


        abc.put(date[0],date[0]);
        int aaa=date[0];
if(date.length!=1)
        for (int i=1;i<date.length;i++) {
        if(date[i]!=date[i - 1]+1){
            aaa=date[i];
        }
            abc.put(aaa, date[i]);
            //用Map添加list

        }
        for (Integer num : set) {
            temp.add(new int[]{num, abc.get(num)});
        }


        return temp.toArray(new int[temp.size()][]);
    }
}