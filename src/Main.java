public class Main {

    public static String Caesar(String Plain, int NumKey){
        String encrypted = "";
        int n = Plain.length();

        for (int i = 0; i < n; i++) {
            //ký tự thứ i trong tin gốc
            char PlainChar = Plain.charAt(i);

            //đẩy lên *NumKey* ký tự
            PlainChar += NumKey;

            //nếu qua ký tự 'z' thì quay lại 'a'
            if (PlainChar > 'z')
                PlainChar = 'a';

            encrypted = encrypted + PlainChar;
        }
        return encrypted;
    }

    public static void main(String[] args) {
        int NumKey = 4; //key that are numbers, used in Caesar, and part of permutation

        //Key that is a String, used in other methods
        String Stringkey = "";

        //Plain text
        String Plain = "skibididomdomyesyes";

        System.out.println(Caesar(Plain, NumKey));
    }
}
