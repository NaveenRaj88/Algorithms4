/**
 * Created by Naveen Kumar .A on 10/10/16.
 */
public class Board {

    private int [][] board;
    public Board(int[][] blocks){
        int[][] board = new int[blocks.length][];
        for (int i = 0; i < blocks.length ; i++) {
            board[i] = blocks[i].clone();
        }
    }

    public int dimension(){
        return board.length;
    }
    public int hamming(){
        int hammingNumber =0;
        int totalElem = board.length * board.length;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board.length ; j++) {
                if(board[i][j] != totalElem++){
                    hammingNumber++;
                }
            }
        }
        return hammingNumber;
    }

    public int manhattan(){
        int manhanntanNumber =0;
        int totalElem = board.length * board.length;
        return totalElem;
    }
//    public boolean isGoal();
//    public Board twin()
//    public boolean equals(Object y)
//    public Iterable<Board> neighbors()
//    public String toString()
//
//    public static void main(String[] args)
}
