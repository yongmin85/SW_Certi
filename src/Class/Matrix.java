package Class;

public class Matrix {

    int[][] M;
    public int length;
    public Matrix(int n){
        M = new int[n][n];
        length = n;
        this.init();
    }

    public boolean equars(int[][] Matrix){

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(M[i][j] != Matrix[i][j]) return false;
            }
        }

        return true;
    }
    public void init(){

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                M[i][j] = 0;
            }
        }
    }
}
