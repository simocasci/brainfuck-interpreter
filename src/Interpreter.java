import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Interpreter {
    String program; // string representation of the commands
    BufferedReader bufferedReader;

    public Interpreter(String filePath) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(filePath));
        program = readFile();
    }

    private String readFile() throws IOException {
        // reads the file and returns the string of commands

        StringBuilder fileContent = new StringBuilder();
        char c;
        while (bufferedReader.ready()) {
            c = (char) bufferedReader.read();
            if (c != '\n' && c != ' ') fileContent.append(c);
        }
        return fileContent.toString();
    }

    public void interpret() {
        byte[] cells = new byte[30000]; // 30000 according to Wikipedia
        // if the data pointer goes over the maximum size of the cells, an error occurs (ArrayIndexOutOfBoundsException)
        int dataPointer = 0;
        int instructionPointer = 0;
        int instructionPointerMaxSize = program.length();
        while (instructionPointer < instructionPointerMaxSize) {
            char c = program.charAt(instructionPointer);
            switch (c) {
                case '>':
                    dataPointer++;
                    break;
                case '<':
                    dataPointer--;
                    break;
                case '+':
                    cells[dataPointer]++;
                    break;
                case '-':
                    cells[dataPointer]--;
                    break;
                case '.':
                    System.out.print((char) cells[dataPointer]);
                    break;
                case ',':
                    Scanner sc = new Scanner(System.in);
                    char userInput = sc.next().charAt(0);
                    cells[dataPointer] = (byte) userInput; // no error is necessary, the byte class handles them
                    break;
                case '[': {
                    // stacks are boring
                    if (cells[dataPointer] == 0) {
                        int i = -1;
                        while (true) {
                            if (instructionPointer == instructionPointerMaxSize) break;
                            if (program.charAt(instructionPointer) == '[') i++;
                            if (program.charAt(instructionPointer) == ']') {
                                if (i == 0) break;
                                else i--;
                            }
                            instructionPointer++;
                        }
                    }
                    break;
                }
                case ']': {
                    // stacks are boring pt. 2
                    if (cells[dataPointer] != 0) {
                        int i = -1;
                        while (true) {
                            if (instructionPointer == 0) break;
                            if (program.charAt(instructionPointer) == ']') i++;
                            if (program.charAt(instructionPointer) == '[') {
                                if (i == 0) break;
                                else i--;
                            }
                            instructionPointer--;
                        }
                    }
                    break;
                }
                default:
                    // it doesn't give an error, it just continues
                    break;
            }
            instructionPointer++;
        }
    }

    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory + "/" + args[0];
        Interpreter interpreter = new Interpreter(path);
        interpreter.interpret();
    }
}