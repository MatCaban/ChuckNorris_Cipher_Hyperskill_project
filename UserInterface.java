package chucknorris;
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

        chooseOperation();
    }

    private void getMessageToCode() {
        System.out.println("Input string: ");
        code.setMessageToCode(sc.nextLine());
    }

    private void printCodedMessage() {
        System.out.println("Encoded string:");
        System.out.println(code.toChuckNorrisEncrypt());
        System.out.println();
    }


    private void getMessageToDecode() {
        System.out.println("Input string: ");
        decode.encodeFromChuckNorris(sc.nextLine());
    }

    private void printDecodedMessage() {
        System.out.println("Decoded string:");
        System.out.println(decode.sevenDigitToChar());
        System.out.println();
    }

    private void chooseOperation() {
        while (true) {
            this.operation = validateOperationInput();

            if (this.operation.equals("exit")) {
                break;
            }

            if (this.operation.equals("encode")) {
                getMessageToCode();
                printCodedMessage();
            }
            if (this.operation.equals("decode")) {
                getMessageToDecode();
                printDecodedMessage();
            }
        }

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
