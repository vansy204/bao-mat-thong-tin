import java.util.Scanner;

public class RailFence {
    private static String encrypt(String Plain){
        String Encrypted = "";
        int n = Plain.length();
        char [][]rewrite = new char[2][n / 2 + n % 2];

        for (int i = 0; i < n; i++) {
            rewrite[i % 2][i / 2] = Plain.charAt(i);
        }

        for (int i = 0; i <= 1; i++){
            for (int j = 0; j < n/2 + n % 2 - i*(n%2); j++){
                Encrypted += rewrite[i][j];
            }
        }
        return Encrypted;
    }

    private static String decrypt(String Encrypted){
        String Decrypted = "";
        int n = Encrypted.length();
        char [][]rewrite = new char[2][n / 2 + n % 2];

        int cnt = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < n/2 + n % 2 - i*(n%2); j++){
                rewrite[i % 2][j] = Encrypted.charAt(cnt);
                cnt++;
            }
        }

        for (int j = 0; j < n/2; j++){
            for (int i = 0; i <= 1; i++)
                Decrypted += rewrite[i][j];
        }
        if (n % 2 != 0)
            Decrypted += rewrite[0][n/2 + 1];
        return Decrypted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Plain text: ");
        String PlainText = sc.nextLine();

        String Encrypted = encrypt(PlainText);
        System.out.println("Encrypted text: " + Encrypted);
        String decrypted = decrypt(Encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
