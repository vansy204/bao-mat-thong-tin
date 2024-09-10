/*
This is the code for Vingenere's cipher method, but with autokey (2.2.3 in the book)
see more here https://en.wikipedia.org/wiki/Autokey_cipher
if you have any questions/suggestions, feel free to contact us about it
Thanks for reading this, enjoy the rest of your day :)
*/

import java.util.Scanner;

public class AutoKey extends Vingenere {
    private static String GenerateNewKey(String Plain, String key){
        String NewKey = key ;
        int n = Plain.length();
        int m = key.length();
        NewKey += Plain.substring(0, n - m);
        return NewKey;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input plain message: ");
        String Plain = sc.nextLine();
        System.out.print("input key: ");
        String Key = sc.nextLine();

        Key = GenerateNewKey(Plain, Key);
        System.out.println("Auto generated key: " + Key);
        String encrypted = encrypt(Plain, Key);
        System.out.println("Encrypted message: " + encrypted);
        String decrypted = decrypt(encrypted, Key);
        System.out.println("Decrypted message: " + decrypted);
    }
}