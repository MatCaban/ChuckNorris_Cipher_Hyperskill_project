package chucknorris;
/*
    The class handles communication with the user. It prints prompts to the console,
    collects and validates user input. If the input passes validation,
    it makes a decision on what to do or sends this validated input to other classes for processing.
 */

import java.util.Scanner;
public class UserInterface {
    private final CodeMessage code = new CodeMessage();
    private final DecodeMessage decode = new DecodeMessage();
    private String operation;


    private Scanner sc;


    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.operation = "";


    }


    public void startUI() {

        chooseOperation();
    }

    private void chooseOperation() {
        while (true) {
            this.operation = validateOperationInput();

            if (this.operation.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            if (this.operation.equals("encode")) {
                getMessageToCode();
                printCodedMessage();
            }
            if (this.operation.equals("decode")) {
                getMessageToDecode();

            }
        }
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
        System.out.println("Input encoded string:");
        String code = sc.nextLine();
        if (validateCodedInput(code)) {
            decode.decodeFromChuckNorris(code);
            printDecodedMessage();
        } else {
            System.out.println("Encoded string is not valid.");
            System.out.println();
        }

    }

    private void printDecodedMessage() {
        System.out.println("Decoded string:");
        System.out.println(decode.convertCodeToString());
        System.out.println();
    }


    // validate user input for provided operations

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

    // checking all 4 requirements for valid code message

    private boolean validateCodedInput(String code) {
            return (hasOnlyZeroes(code)
            && isNumberOfBlockEven(code)
            && isValidStartOfBlock(code)
            && isAtLeastSevenDigits(code));

    }

    // check if input string contains only zeroes and spaces

    private boolean hasOnlyZeroes(String code) {
        boolean isValid = true;
        String[] toArr = code.split("");
        for (String letter : toArr) {
            if (letter.equals("0")
            || letter.equals(" ")){
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    // checking if number of block is not odd

    private boolean isNumberOfBlockEven(String code) {
        String[] toArr = code.split(" ");
        return toArr.length % 2 == 0;
    }

    // checking if each block of code start with 0 or 00

    private boolean isValidStartOfBlock(String code) {
        boolean isValid = true;
        String[] toArr = code.split(" ");

        // iterate only through even indexes, that is where 0 or 1 is coded

        for (int i = 0; i < toArr.length; i += 2) {
            if (toArr[i].equals("0")
            || toArr[i].equals("00")) {

            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    // check if code message can be equally divided by 7

    private boolean isAtLeastSevenDigits(String code) {
        String[] toArr = code.split(" ");
        int count = 0;

        // iterate through odd indexes, and count total number of coded zeroes or ones
        for (int i = 1; i < toArr.length; i += 2) {
            count += toArr[i].length();
        }

        // check if count is divisible by 7 DecodeMessage requirement
        return count % 7 == 0;
    }
}
