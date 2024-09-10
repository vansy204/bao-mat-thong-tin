/*
This is the code for Rail Fence cipher method (2.3.1 in the book)
see more about it here: https://en.wikipedia.org/wiki/Rail_fence_cipher
the article says that there are three rails in the cipher method, but
we are taught to use 2 in school book, so this program only use 2 rows as you can see below
if you have any questions/suggestions, feel free to contact us about it
Thanks for reading this, enjoy the rest of your day :)
*/

import java.util.Scanner;

public class RailFence {
    private static String encrypt(String Plain){
        String Encrypted = "";
        int n = Plain.length();
        char [][]rewrite = new char[2][n / 2 + n % 2];

        //write on two rows
        //Ex: abcde will become
        //a c e
        //b d
        for (int i = 0; i < n; i++) {
            rewrite[i % 2][i / 2] = Plain.charAt(i);
        }

        //iterate 2 rows and add them to Encrypted string
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
        //write on two rows
        //write on two rows
        //Ex: acebd will become
        //a c e
        //b d
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < n/2 + n % 2 - i*(n%2); j++){
                rewrite[i % 2][j] = Encrypted.charAt(cnt);
                cnt++;
            }
        }

        //iterate 2 rows and add them to Decrypted string
        for (int j = 0; j < n/2; j++){
            Decrypted += rewrite[0][j];
            Decrypted += rewrite[1][j];
        }
        //add the last column to Decrypted if the number of characters is odd
        if (n % 2 != 0)
            Decrypted += rewrite[0][n/2];
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
