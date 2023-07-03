
import java.util.*;
//http://www.codeabbey.com/index/task_view/blackjack-counting
public class Blackjack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String linia;
        Map<String, Integer> legenda = new HashMap<>();
        legenda.put("1", 1);
        legenda.put("2", 2);
        legenda.put("3", 3);
        legenda.put("4", 4);
        legenda.put("5", 5);
        legenda.put("6", 6);
        legenda.put("7", 7);
        legenda.put("8", 8);
        legenda.put("9", 9);
        legenda.put("T", 10);
        legenda.put("K", 10);
        legenda.put("Q", 10);
        legenda.put("J", 10);
        legenda.put("A", 0);
        int liczbaWierszy = Integer.parseInt(scanner.nextLine());
        if (liczbaWierszy < 1) {
            return;
        }
        for (int i = 0; i < liczbaWierszy; i++) {
            linia = scanner.nextLine();
            int sum = 0;
            String[] splited = linia.split(" ");
            double aceCount = 0;

            for (int j = 0; j < splited.length; j++) {
                if (splited[j].equals("A")) {
                    aceCount++;
                } else {
                    double value = legenda.get(splited[j]);
                    sum += value;
                }
            }
            if (sum > 21) {
                System.out.print("Bust ");
            } else if (aceCount > 0) {
                double resztaZDzielenia = (21 - sum) / aceCount;
                if (resztaZDzielenia == 1) {
                    sum += aceCount;
                    System.out.print(sum + " ");
                } else if (resztaZDzielenia >= 11) {
                    sum += 11;
                    System.out.print(sum + " ");
                } else if (resztaZDzielenia < 1) {
                    System.out.print("Bust ");
                } else if (resztaZDzielenia > 1 || resztaZDzielenia < 11) {
                    sum += 11 + aceCount - 1;
                    System.out.print(sum + " ");
                }
            } else {
                System.out.print(sum + " ");
            }
        }
    }
}
