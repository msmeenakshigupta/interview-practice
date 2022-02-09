package com.geekcircle.LowLevelDesign.Chess;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

/*
1. Pawn -> 8
2. Rooks -> 2
3. Knight ->2
4. Bishop -> 2
5. King -> 1
6. Queen -> 1
 */

abstract class Piece {

    private Boolean isWhite;

    private Boolean isKilled;

    public Piece(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Boolean getWhite() {
        return isWhite;
    }

    public Boolean getKilled() {
        return isKilled;
    }

    public void setKilled(Boolean killed) {
        isKilled = killed;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
}

class Pawn extends Piece {

    public Pawn(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class Rooks extends Piece {

    public Rooks(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class Knight extends Piece {

    public Knight(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class Bishop extends Piece {

    public Bishop(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class King extends Piece {

    public King(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class Queen extends Piece {

    public Queen(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        //Business logic
        return false;
    }

}

class Spot {

    int r;
    int c;
    Piece piece;

    public Spot(int r, int c, Piece piece) {
        this.r = r;
        this.c = c;
        this.piece = piece;
    }
}

class Board {

    Spot[][] spots;

    int N = 8;

    Board() {
         spots = new Spot[N][N];
    }

    boolean reInitialize(){
        spots[0][0] = new Spot(0,0,new Rooks(true));
        spots[0][7] = new Spot(0,7,new Rooks(true));
        spots[0][1] = new Spot(0,1,new Knight(true));
        spots[0][6] = new Spot(0,6,new Knight(true));
        spots[0][2] = new Spot(0,2,new Bishop(true));
        spots[0][5] = new Spot(0,5,new Bishop(true));
        spots[0][3] = new Spot(0,3,new King(true));
        spots[0][4] = new Spot(0,4,new Queen(true));
        for(int i = 0; i < N ; i++){
            spots[1][i] = new Spot(1,i,new Pawn(true));
            spots[6][i] = new Spot(6,i,new Pawn(false));
        }

        spots[7][0] = new Spot(7,0,new Rooks(true));
        spots[7][7] = new Spot(7,7,new Rooks(true));
        spots[7][1] = new Spot(7,1,new Knight(true));
        spots[7][6] = new Spot(7,6,new Knight(true));
        spots[7][2] = new Spot(7,2,new Bishop(true));
        spots[7][5] = new Spot(7,5,new Bishop(true));
        spots[7][3] = new Spot(7,3,new King(true));
        spots[7][4] = new Spot(7,4,new Queen(true));

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }

        return true;
    }

    Spot getBlock(int i, int j) throws Exception {
        if(i < 0 || i > 7 || j < 0 || j > 7){
            throw new Exception("Out of bound");
        }
        return spots[i][j];
    }

}

class Move {

    Player player;

    Spot start;

    Spot end;



}

abstract class Player {

    String name;

    Boolean isWhite;

    Boolean isComputer;

    public Player(String name, Boolean isWhite, Boolean isComputer) {
        this.name = name;
        this.isWhite = isWhite;
        this.isComputer = isComputer;
    }

}

class HumanPlayer extends Player {

    public HumanPlayer(String name, Boolean isWhite) {
        super(name, isWhite, false);
    }
}

class ComputerPlayer extends Player {

    public ComputerPlayer(Boolean isWhite) {
        super("Computer", isWhite, true);
    }
}


class Game {

    Player player1;

    Player player2;

    Board board;

    Player chance;

    public Game(String playerName1, String playerName2) {
        board = new Board();
        this.player1 = new HumanPlayer("Akshay", true);
        this.player2 = new ComputerPlayer(false);
        chance = player1;
        board.reInitialize();
    }

    void move(Player player, int sourceRow, int sourceCol, int destRow, int destCol) {

    }
}

public class ChessGame {
    public static void main(String[] args) {

    }
}
