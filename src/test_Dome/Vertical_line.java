package test_Dome;

public class Vertical_line {
    int[][] pos;
    Vertical_line(int[][] nums){
        this.pos = nums;
    }

    //行列转换输出
    public void wap(){
        int m = pos.length;
        int n = pos[0].length;
        int[][] temp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               temp[j][i]= pos[i][j];

            }
        }
        for (int i = 95; i < 104; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(temp[i][j]);

            }
            System.out.println();
        }
    }
}
