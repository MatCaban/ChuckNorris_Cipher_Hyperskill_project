package chucknorris;

import java.util.Arrays;

public class CodeMessage {
    private String messageToCode;
    private char[] splitMessageToCode;


    public CodeMessage() {}

    public void setMessageToCode(String message){
        this.messageToCode = message;
    }

    public String getMessageToCode() {
        return this.messageToCode;
    }

    public char[] getSplitMessageToCode() {
        return splitMessageToCode;
    }

    // split string to char array

    private void setSplitMessageToCode() {
        this.splitMessageToCode = this.messageToCode.toCharArray();
    }

    // convert each charr to 7 digit binary and output as string

    private String charactersToBinary() {
        setSplitMessageToCode();
        String binary = "";
        for (char letter : this.splitMessageToCode) {
             binary += Integer.toBinaryString(letter).length() == 7
                    ? Integer.toBinaryString(letter)
                    : "0"+Integer.toBinaryString(letter);


        }
        return binary;
    }

    // encrypt string with 7 digits binary representing each charr to chuck norris encrypt
    public String toChuckNorrisEncrypt(){
        String[] binary = charactersToBinary().split("");
        String output = "";
        int index = 1;
        String previous = binary[0];

        output += binary[0].equals("0")
                ? "00 0"
                : "0 0";

        while (index < binary.length) {

            if (binary[index].equals(previous)) {
                output += "0";
            } else {
                output += binary[index].equals("0")
                        ? " 00 0"
                        : " 0 0";
                previous = binary[index];
            }


            index++;
        }



        return output;
    }

}
