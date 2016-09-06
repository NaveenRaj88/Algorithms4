
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Naveen Kumar .A on 9/4/16.
 */
public class Percolation {

    private int [][] gridStatus;
    private WeightedQuickUnionUF quickUnionUF;
    private int count;
    private int n;

    public Percolation(int n){
        if(n <= 0){
            throw  new IllegalArgumentException("invalid grid size");
        }
        this.n=n;
        gridStatus = new int[n][n];
        quickUnionUF = new WeightedQuickUnionUF(n*n+2);
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                count++;
                if(i ==0){
                    quickUnionUF.union(count, 0);
                }else if(i == n-1){
                    quickUnionUF.union(count, n*n+1);
                }
            }
        }
    }

    public void open(int i, int j){
        int x = i-1, y=j-1;
        gridStatus[x][y] = 1;
        for (int k = x-1; k <=x+1 ; k+=2) {
            if (isValid(k, y)) {
                if (isOpen(k+1, y + 1)) {
                    quickUnionUF.union((k * n) + (y + 1), (x * n) + j);
                }
            }
        }

        for (int k = y-1; k <=y+1 ; k+=2) {
            if(isValid(x,k)){
                if(isOpen(x+1, k+1)){
                    quickUnionUF.union((x*n)+(k+1), (x*n)+j);
                }
            }
        }
    }

    public boolean isOpen(int i, int j){
        if(!isValid(i-1,j-1)){
            throw new  IndexOutOfBoundsException("invalid grid range isOpen");
        }
        return gridStatus[i-1][j-1] ==1;
    }

    public boolean isFull(int i, int j){
        if(!isValid(i-1,j-1)){
            throw new  IndexOutOfBoundsException("invalid grid range");
        }
        if(quickUnionUF.connected(((i-1)*n)+j, 0)){
            return gridStatus[i-1][j-1] == 1;
        }else{
            return false;
        }

    }

    public boolean percolates(){
        return quickUnionUF.connected(0, (n*n)+1);
    }

    private boolean percolates(int i , int j){
            if(i == gridStatus.length-1){
                return true;
            }
        if(isFull(i+1,j)){
            return percolates(i++,j);
        }else if(isFull(i,j)){
        }
        return false;
    }


    private boolean isValid(int i, int j){
        return i>=0 && i < n && j>=0 && j<n;
    }

}
