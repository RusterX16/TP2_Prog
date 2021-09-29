package dev.ruster.tp1;

import dev.ruster.tp1.utils.Util;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Question 1 : Générateur aléatoire
        */

        /*
        Question 2 : Simulation d'un marin ivre
        */

        int[] dimensions = getDimensions();

        // 1. Méthode arivobato()

        System.out.println(arivobato(dimensions) ? "Vous avez réussi !" : "Vous avez échoué...");

        // 2. Méthode displayBoard()


    }

    @Contract(" -> new")
    public static int @NotNull [] getDimensions() {
        int length, width;

        do {
            System.out.print("Fixer une valeur pour la largeur : ");
            width = scan.nextInt();
        } while(width % 2 == 0);

        do {
            System.out.print("Fixer une valeur supérieur à " + width + " pour la longueur maintenant : ");
            length = scan.nextInt();
        } while(length < width);

        return new int[]{length, width};
    }

    public static int roll() {
        int n = Util.randomIntBetween(1, 100);

        if(n <= 50)
            return 1;
        if(n <= 70)
            return 2;
        if(n <= 90)
            return 3;
        if(n <= 100)
            return 4;
        return 0;
    }

    public static boolean arivobato(int @NotNull [] dimensions) {
        boolean success = false;
        boolean onBoard = true;

        int[] directions = new int[4];
        int distance = dimensions[0];
        int x = dimensions[1] / 2;
        int y = 0;

        while(onBoard) {
            if(x < 0 || x >= dimensions[1] || y < 0 || y == distance) {
                if(y == distance) {
                    success = true;
                }
                onBoard = false;
            }
            displayMarin(dimensions[0], dimensions[1], x, y);

            for(int i = 0; i < dimensions[1]; i++) {
                System.out.print("-");
            }
            System.out.println("\n");

            switch(roll()) {
                case 1 -> {
                    directions[0]++;
                    y++;
                }
                case 2 -> {
                    directions[1]++;
                    x--;
                }
                case 3 -> {
                    directions[2]++;
                    x++;
                }
                case 4 -> {
                    directions[3]++;
                    y = y > 0 ? y - 1 : y;
                }
            }
        }
        System.out.println("Vous avez fait " + directions[0] + " pas vers l'avant");
        System.out.println("Vous avez fait " + directions[1] + " pas vers la gauche");
        System.out.println("Vous avez fait " + directions[2] + " pas vers la droite");
        System.out.println("Vous avez fait " + directions[3] + " pas vers l'arrière");
        return success;
    }

    public static String displayBoard(int length, int width) {
        String board = "";

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                board = board.concat("#");
                //System.out.print("#");
            }
            board = board.concat("\n");
            //System.out.print("\n");
        }
        return board;
    }

    public static String displayMarin(int width, int length, int y, int x) {
        String board = "";

        for(int i = width - 1; i >= 0; i--) {
            for(int j = length - 1; j >= 0; j--) {
                //System.out.print("#");

                if(i == x && j == y) {
                    board = board.concat("o");
                } else {
                    board = board.concat("#");
                }
            }
            board = board.concat("\n");
            //System.out.print("\n");
        }
        System.out.println(board);
        Util.sleep(1);
        return board;
    }
}