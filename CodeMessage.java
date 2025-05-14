package chucknorris;
/*
The class handles the encoding of a given string. The string is split into individual characters,
and each character is converted to its 7-bit binary value. If it doesn't have 7 bits, a 0 is added at the beginning.
Subsequently, it is encrypted, and the class returns the encrypted string.
 */

public class CodeMessage {
    private String messageToCode;
    private char[] splitMessageToCode;


    public CodeMessage() {}

    public void setMessageToCode(String message){
        this.messageToCode = message;
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

    // encrypt binary string to chuck norris encrypt
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
