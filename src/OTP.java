/*
This is the code for One-time pad (OTP) cipher method (2.2.5 in the book)
You can read more about it here: https://en.wikipedia.org/wiki/One-time_pad
if you have any questions/suggestions, feel free to contact us about it
Thanks for reading this, enjoy the rest of your day :)
*/

import java.util.Scanner;

public class OTP extends Vingenere {
    /*
    to my understanding, OTP can be used with any cryptography techniques, as long as
    the keys are used once and changing each time
    I will combine it substitution technique here, since it is similar in our book and on wiki page
     */

    protected static String RandomGeneratedKey(int length) {
        String RandomKey ="";
        for (int i = 0; i < length; i++) {
            RandomKey += (char)('a' + (Math.random()*100) % 26);
        }
        return RandomKey;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input plain message:  ");
        String Plain = sc.nextLine();
        String OTP = RandomGeneratedKey(Plain.length());
        String OTP2 = RandomGeneratedKey(OTP.length());

        //output
        System.out.println("---------------------------------");
        System.out.println("Random Generated Key: " + OTP);
        System.out.println("---------------------------------");
        String encrypted = encrypt(Plain, OTP);
        System.out.println("encrypted Plain message: " + encrypted);
        String decrypted = decrypt(encrypted, OTP);
        System.out.println("decrypted Plain message: " + decrypted);
        System.out.println("---------------------------------");
        System.out.println("2nd Random Generated Key: " + OTP2);
        System.out.println("decrypted Plain message using 2nd key: " + decrypt(Plain, OTP2));
        System.out.println("---------------------------------");
    }
}
