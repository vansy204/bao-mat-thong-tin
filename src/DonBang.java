import java.util.Scanner;

public class DonBang {
    private static String encrypt(String Plain, String Key){
        String Encrypted = "";
        int n = Plain.length();

        for (int i = 0; i < n; i++) {
            char c = Plain.charAt(i);
            //c's position in the alphabet, starting with a at position 0
            int pos = c - 'a';
            //adding the pos-th character into the encrypted message
            Encrypted += Key.charAt(pos);
        }
        return Encrypted;
    }

    private static String decrypt(String encrypted, String Key){
        String Decrypted = "";
        int n = encrypted.length();

        for (int i = 0; i < n; i++) {
            char c = encrypted.charAt(i);
            //looking for the character's position in the key string
            int pos = 0;
            for (int j = 0; j < Key.length(); j++) {
                if (Key.charAt(j) == c) {
                    pos = j;
                    break;
                }
            }
            //add the corresponding character (pos-th character) on the alphabet
            Decrypted += (char)('a' + pos);
        }
        return Decrypted;
    }

    public static void main(String[] args) {
        //khóa dùng trong thay thế đơn bảng có độ dài là 26, ứng với 26 ký tự trong bảng chữ cái
        //a sẽ được thay thế bằng ký tự đầu tiên trong key, b là ký tự thứ hai, c thứ ba, ... z ứng với chữ cái cuối cùng
        String StringKey = "qazwsxedcrfvtgbyhnujmikolp";

        //input
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Plain message: ");
        String Plain = scan.nextLine();

        //encrypt and decrypt
        String encrypted = encrypt(Plain, StringKey);
        System.out.println("encrypted Plain message: " + encrypted);
        String decrypted = decrypt(encrypted, StringKey);
        System.out.println("decrypted Plain message: " + decrypted);
    }
}
