package org.example;

public class ticktacktoe_uc1 {

        static char[][] board = new char[3][3];

        public static void main(String[] args) {
            initializeBoard();
            printBoard();
        }

        static void initializeBoard() {
            for(int row=0; row < 3;row++){
                for(int col=0; col<3;col++){

                }
            }
        }

        static void printBoard() {

            for (int row = 0; row < 3; row++) {
                System.out.println("---");
            }
        }
    }