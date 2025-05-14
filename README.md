# Chuck Norris Cipher Encoder/Decoder

This project is an implementation of encoding and decoding messages using the so-called Chuck Norris Cipher. It was developed as part of my Java language studies on the Hyperskill.com platform. The project went through several development stages on Hyperskill, with new functionalities being added in each stage.

## Project Description

The program allows the user to enter a message, which is then encoded into the Chuck Norris Cipher. This cipher works by first converting each character of the input string into its 7-bit binary representation. Then, each bit of this binary representation is encoded in a specific way. The program also provides a function to decode such encoded messages back to their original form.

## Used Classes

The project is structured into several classes, each with a specific responsibility:

-   **`Main`**: The entry point of the program, which runs the application.
-   **`UserInterface`**: Handles interaction with the user. It displays prompts in the console, receives and validates user input. Based on successful validation, it decides on the next course of action or sends the validated data to the `CodeMessage` or `DecodeMessage` classes for processing. The resulting messages from these classes are then communicated to the user through the `UserInterface` class.
-   **`CodeMessage`**: Contains the logic for encoding the input string into the Chuck Norris Cipher.
-   **`DecodeMessage`**: Contains the logic for decoding a string encoded using the Chuck Norris Cipher.

## Learned Skills

During the development of this project, I gained and deepened my knowledge in the following areas:

-   Working with strings (String manipulation) in Java.
-   Designing and implementing algorithms for encoding and decoding.
-   Thinking about different approaches and problem-solving.
-   Basic structure of a multi-class application in Java.
-   User input validation.

## Further Development

With increasing experience in the Java language and its extensive libraries, I believe that it would be possible to improve this project in the future and write it more efficiently and elegantly.

## How to Run

1.  Make sure you have the Java Development Kit (JDK) installed.
2.  Download the project's source code.
3.  Open a terminal or command prompt and navigate to the root directory of the project.
4.  Compile the source code using the command: `javac src/*.java` (assuming the source files are in the `src` directory).
5.  Run the program using the command: `java Main`

## Contact

If you have any questions or suggestions, please do not hesitate to contact me.

---
