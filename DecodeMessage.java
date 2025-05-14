package chucknorris;

import java.util.ArrayList;
import java.util.Arrays;

public class DecodeMessage {
    String encodedFromChuckNorris;

    public DecodeMessage() {
        encodedFromChuckNorris = "";
    }


    // encode chuck norris string (eg. 0 0 00 000) to "binary"

    public void encodeFromChuckNorris(String coded) {
        String[] splitted = coded.split(" ");


        for (int i = 0; i < splitted.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < splitted[i].length(); j++) {
                    encodedFromChuckNorris += splitted[i -1].equals("0")
                            ? "1"
                            : "0";
                }

            }
        }
    }

    // split encoded string in binary to parts of 7 digits

    private String[] splitEncodeToSevenDigits() {

        String[] sevenDigits = new String[encodedFromChuckNorris.length() / 7];
        for (int i = 0; i < sevenDigits.length; i++) {
            sevenDigits[i] = encodedFromChuckNorris.substring(i * 7, (i * 7 + 7));
        }
        return sevenDigits;
    }

    public String sevenDigitToChar() {
        String output = "";
        String[] charInBinary = splitEncodeToSevenDigits();
        for (String s : charInBinary) {
            int charBinary = Integer.parseInt(s, 2);
            output += (char)charBinary;

        }

        return output;
    }

}
