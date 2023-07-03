import java.util.Scanner;

public class GameOf2048 {
    public static void main(String[] args) {
        //http://www.codeabbey.com/index/task_view/game-of-2048
        Scanner scanner = new Scanner(System.in);
        String line = "";
        int size = 4;
        for (int i = 0; i < size; i++) {
            line += scanner.nextLine() + " ";
        }
        int number = 0;
        int[][] gra = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                gra[row][col] = line.charAt(number) - '0';
                number += 2;
                System.out.print(gra[row][col]);
            }
            System.out.println();
        }
        String[] moves = scanner.nextLine().split(" ");
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case "D":
                    for (int col = 0; col < size; col++) {
                        int zmianaO = 1;
                        for (int row = size - 1; row > 0; row--) {
                            //porownywanie w kolumnie
                            if (gra[row][col] == gra[row - 1][col]) {
                                if (gra[row][col] == 0) {
                                    zmianaO++;
                                    row--;
                                    continue;
                                }
                                //zmiana dolnej wartosci na sume
                                gra[row][col] += gra[row - 1][col];
                                //zmiana gornej wartosci na 0
                                gra[row - 1][col] = 0;
                                //przesuwanie
                                if (row == 1) {
                                    //przesuwanie w dol o jeden albo 2 ORTOGRAFIA !!!
                                    gra[row + zmianaO][col] = gra[row][col];
                                    //zmiana gornej na zero
                                    gra[row][col] = 0;
                                }
                                row--;
                            } else {
                                    if (gra[row][col] == 0) {
                                        gra[row][col] = gra[row - 1][col];
                                        gra[row - 1][col] = 0;
                                }
                                    if(zmianaO > 1) {
                                        gra[row + zmianaO][col] = gra[row][col];
                                        gra[row + 1][col] = gra[row - 1][col];
                                        gra[row][col] = 0;
                                        gra[row - 1][col] = 0;
                                    }
                                    if(row < size - 1 && gra[row + 1][col] == 0) {
                                        gra[row + 1][col] = gra[row][col];
                                        gra[row][col] = gra[row - 1][col];
                                    }
                            }
                        }
                        System.out.print(gra[0][0] + " ");
                        System.out.print(gra[1][0] + " ");
                        System.out.print(gra[2][0] + " ");
                        System.out.print(gra[3][0] + " ");
                    }
                    break;
                case "U":
                    for (int col = 0; col < size; col++) {
                        int zmianaO = 1;
                        for (int row = 0; row < size - 1; row++) {
                            if (gra[row][col] == gra[row + 1][col]) {
                                if (gra[row][col] == 0) {
                                    zmianaO++;
                                    row++;
                                    continue;
                                }
                                gra[row][col] += gra[row + 1][col];
                                gra[row + 1][col] = 0;
                                if (row == 2) {
                                    gra[row - zmianaO][col] = gra[row][col];
                                    gra[row][col] = 0;
                                }
                                row++;
                            } else {
                                if (gra[row][col] == 0) {
                                    gra[row][col] = gra[row + 1][col];
                                    gra[row + 1][col] = 0;
                                }
                                if(zmianaO > 1) {
                                    gra[row - zmianaO][col] = gra[row][col];
                                    gra[row - 1][col] = gra[row + 1][col];
                                    gra[row][col] = 0;
                                    gra[row + 1][col] = 0;
                                }
                                if(row > 0 && gra[row - 1][col] == 0) {
                                    gra[row - 1][col] = gra[row][col];
                                    gra[row][col] = gra[row + 1][col];
                                }
                            }
                        }
                        System.out.print(gra[0][0] + " ");
                        System.out.print(gra[1][0] + " ");
                        System.out.print(gra[2][0] + " ");
                        System.out.print(gra[3][0] + " ");
                    }
                    break;
                case "R":
                    for (int row = 0; row < size; row++) {
                        int zmianaO = 1;
                        for (int col = size - 1; col > 0; col--) {
                            if (gra[row][col] == gra[row][col - 1]) {
                                if (gra[row][col] == 0) {
                                    zmianaO++;
                                    col--;
                                    continue;
                                }
                                gra[row][col] += gra[row][col - 1];
                                gra[row][col - 1] = 0;
                                if (col == 1) {
                                    gra[row][col + zmianaO] = gra[row][col];
                                    gra[row][col] = 0;
                                }
                                col--;
                            } else {
                                if (gra[row][col] == 0) {
                                    gra[row][col] = gra[row][col - 1];
                                    gra[row][col - 1] = 0;
                                }
                                if(zmianaO > 1) {
                                    gra[row][col + zmianaO] = gra[row][col];
                                    gra[row][col + 1] = gra[row][col - 1];
                                    gra[row][col] = 0;
                                    gra[row][col - 1] = 0;
                                }
                                if(col < size - 1 && gra[row][col + 1] == 0) {
                                    gra[row][col + 1] = gra[row][col];
                                    gra[row][col] = gra[row][col - 1];
                                }
                            }
                        }
                        System.out.print(gra[0][0] + " ");
                        System.out.print(gra[0][1] + " ");
                        System.out.print(gra[0][2] + " ");
                        System.out.print(gra[0][3] + " ");
                    }
                    break;
                case "L":
                    for (int row = 0; row < size; row++) {
                        int zmianaO = 1;
                        for (int col = 0; col < size - 1; col++) {
                            if (gra[row][col] == gra[row][col + 1]) {
                                if (gra[row][col] == 0) {
                                    zmianaO++;
                                    col++;
                                    continue;
                                }
                                gra[row][col] += gra[row][col + 1];
                                gra[row][col + 1] = 0;
                                if (row == 2) {
                                    gra[row][col - zmianaO] = gra[row][col];
                                    gra[row][col] = 0;
                                }
                                col++;
                            } else {
                                if (gra[row][col] == 0) {
                                    gra[row][col] = gra[row][col + 1];
                                    gra[row][col + 1] = 0;
                                }
                                if(zmianaO > 1) {
                                    gra[row][col - zmianaO] = gra[row][col];
                                    gra[row][col - 1] = gra[row][col + 1];
                                    gra[row][col] = 0;
                                    gra[row][col + 1] = 0;
                                }
                                if(col > 0 && gra[row][col - 1] == 0) {
                                    gra[row][col - 1] = gra[row][col];
                                    gra[row][col] = gra[row][col + 1];
                                }
                            }
                        }
                        System.out.print(gra[0][0] + " ");
                        System.out.print(gra[0][1] + " ");
                        System.out.print(gra[0][2] + " ");
                        System.out.print(gra[0][3] + " ");
                    }
                    break;
            }
        }
    }
}

