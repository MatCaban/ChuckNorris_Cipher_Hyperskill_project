package chucknorris;
import java.util.Arrays;
import java.util.Scanner;
public class UserInterface {
    CodeMessage code = new CodeMessage();
    DecodeMessage decode = new DecodeMessage();

    private Scanner sc;


    public UserInterface() {
        this.sc = new Scanner(System.in);


    }


    public void startUI() {
       // getMessageFromUser();

       // printResult();

        decodeMessage();
    }

    private void getMessageFromUser() {
        System.out.println("Input string: ");
        code.setMessageToCode(sc.nextLine());
    }

    private void printResult() {
        System.out.println("The result:");
        System.out.println(code.toChuckNorrisEncrypt());
    }


    private void decodeMessage() {
        System.out.println("Input string: ");
        decode.encodeFromChuckNorris(sc.nextLine());

        System.out.println("The result:");
        System.out.println(decode.sevenDigitToChar());
    }
}
