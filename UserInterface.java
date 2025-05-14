package chucknorris;
import java.util.Arrays;
import java.util.Scanner;
public class UserInterface {
    private CodeMessage code = new CodeMessage();
    private DecodeMessage decode = new DecodeMessage();
    private String operation;


    private Scanner sc;


    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.operation = "";


    }


    public void startUI() {
       // getMessageFromUser();

       // printResult();

//        decodeMessage();
        chooseOperation();
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

    private void chooseOperation() {

        this.operation = validateOperationInput();
    }

    private String validateOperationInput() {
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            this.operation = sc.nextLine();
            if (this.operation.equals("exit")
            || this.operation.equals("encode")
            || this.operation.equals("decode")) {
                return this.operation;
            } else {
                System.out.printf("There is no %s operation%n", this.operation);
                System.out.println();
            }


        }

    }
}
