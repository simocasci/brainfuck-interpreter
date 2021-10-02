# Brainfuck Interpreter
I used [this Wikipedia page](https://en.wikipedia.org/wiki/Brainfuck) for reference.

The Interpreter is in `src/Interpreter.java`. A test program has been written in `program.txt` (you can change this if you want to interpret a different one).

I have tested the interpreter with all the [Wikipedia examples](https://en.wikipedia.org/wiki/Brainfuck#Examples), and in `program.txt` there's the [ROT-13 cipher](https://en.wikipedia.org/wiki/ROT13) one.

Two main ways to run the interpreter:
1. Open it in [IntelliJ IDEA](https://www.jetbrains.com/idea/), add `program.txt` as argument for the Run command and then click it
2. Open the folder in terminal, go to `out/production/BrainfuckInterpreter` and type `java Interpreter ../../../program.txt`

For the ROT-13 example: start writing characters one at the time and when finished use `CTRL-C` to terminate the program (you have to manually kill it because Brainfuck isn't complex enough to terminate it itself).
