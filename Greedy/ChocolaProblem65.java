package Greedy;

import java.util.*;

public class ChocolaProblem65 {

    public static void main(String[] args) {
        Integer[] horizontal = { 4, 1, 2 };
        Integer[] vertical = { 2, 1, 3, 1, 4 };

        int horizontalPieces = 1, verticalPieces = 1;
        int horizontalPointer = 0, verticalPointer = 0;
        int cost = 0;
        Arrays.sort(horizontal, Collections.reverseOrder());
        Arrays.sort(vertical, Collections.reverseOrder());
        while (horizontalPointer < horizontal.length && verticalPointer < vertical.length) {
            if (horizontal[horizontalPointer] <= vertical[verticalPointer]) {
                cost += vertical[verticalPointer] * horizontalPieces;
                verticalPointer++;
                verticalPieces++;
            } else {
                cost += horizontal[horizontalPointer] * verticalPieces;
                horizontalPointer++;
                horizontalPieces++;
            }
        }
        while (horizontalPointer < horizontal.length) {
            cost += horizontal[horizontalPointer] * verticalPieces;
            horizontalPointer++;
            horizontalPieces++;
        }
        while (verticalPointer < vertical.length) {
            cost += vertical[verticalPointer] * horizontalPieces;
            verticalPointer++;
            verticalPieces++;
        }
        System.out.println("Cost to cut chocolate : "+cost);
        String s ="ab";
        s.length();
    }

}