package chucknorris;
/*
 The class accepts a valid encoded string and returns its decoded version.
 */


public class DecodeMessage {
    private String decodedFromChuckNorris;

    public DecodeMessage() {
        decodedFromChuckNorris = "";
    }


    // encode chuck norris string (eg. 0 0 00 000) to "binary"

    public void decodeFromChuckNorris(String coded) {
        String[] splitted = coded.split(" ");


        for (int i = 0; i < splitted.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < splitted[i].length(); j++) {
                    decodedFromChuckNorris += splitted[i -1].equals("0")
                            ? "1"
                            : "0";
                }

            }
        }
    }

    // split encoded string to list, each element of list will be 7 digits long

    private String[] splitEncodeToSevenDigits() {

        String[] sevenDigits = new String[decodedFromChuckNorris.length() / 7];
        for (int i = 0; i < sevenDigits.length; i++) {
            sevenDigits[i] = decodedFromChuckNorris.substring(i * 7, (i * 7 + 7));
        }
        return sevenDigits;
    }

    // convert each 7 digit binary number from splitEncodeToSevenDigit to its char representation

    public String convertCodeToString() {
        String output = "";
        String[] charInBinary = splitEncodeToSevenDigits();
        for (String s : charInBinary) {
            int charBinary = Integer.parseInt(s, 2);
            output += (char)charBinary;

        }

        return output;
    }

}
