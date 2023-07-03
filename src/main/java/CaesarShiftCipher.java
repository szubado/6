import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//http://www.codeabbey.com/index/task_view/caesar-shift-cipher
public class CaesarShiftCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> alfabet = new HashMap<>();
        alfabet.put(1, "A");
        alfabet.put(2, "B");
        alfabet.put(3, "C");
        alfabet.put(4, "D");
        alfabet.put(5, "E");
        alfabet.put(6, "F");
        alfabet.put(7, "G");
        alfabet.put(8, "H");
        alfabet.put(9, "I");
        alfabet.put(10, "J");
        alfabet.put(11, "K");
        alfabet.put(12, "L");
        alfabet.put(13, "M");
        alfabet.put(14, "N");
        alfabet.put(15, "O");
        alfabet.put(16, "P");
        alfabet.put(17, "Q");
        alfabet.put(18, "R");
        alfabet.put(19, "S");
        alfabet.put(20, "T");
        alfabet.put(21, "U");
        alfabet.put(22, "V");
        alfabet.put(23, "W");
        alfabet.put(24, "X");
        alfabet.put(25, "Y");
        alfabet.put(26, "Z");

        String pierwszaLinia = scanner.nextLine();
        int liczbaWierszy = 0;
        int przeskok = 0;
        String linia;
        String original = "";

        for (int i = 0; i < pierwszaLinia.length() - 1; i++) {
            if (pierwszaLinia.charAt(i + 1) == ' ') {
                liczbaWierszy = Integer.parseInt(pierwszaLinia.substring(0, i + 1));
                przeskok = Integer.parseInt(pierwszaLinia.substring(i + 2));
            } else continue;
        }
              for (int j = 0; j < liczbaWierszy; j++) {
            linia = scanner.nextLine();
            for (int d = 0; d < linia.length(); d++) {
                if (linia.charAt(d) == ' ') {
                    original = original.substring(0, d) + " ";
                } else if (linia.charAt(d) == '.') {
                    original = original.substring(0, d) + ".";
                } else {
                    String zamianaCNaS = "" + linia.charAt(d);
                    Set<Map.Entry<Integer, String>> entries = alfabet.entrySet();
                    for (Map.Entry<Integer, String> entry : entries) {
                        if (entry.getValue().equals(zamianaCNaS)) {
                            if (przeskok > entry.getKey()) {
                                int zmiana = 26 - przeskok + entry.getKey();
                                original = original.substring(0, d) + alfabet.get(zmiana);
                            } else {
                                original = original.substring(0, d) + alfabet.get(entry.getKey() - przeskok);
                            }
                        }
                    }
                }
            }
            System.out.print(original + " ");
        }
    }
}
