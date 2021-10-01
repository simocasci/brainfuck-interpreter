# Brainfuck Interpreter
I used [this Wikipedia page](https://en.wikipedia.org/wiki/Brainfuck) for reference.

The Interpreter is in `src/Interpreter.java`. A test program has been written in `program.txt` (you can change this if you want to interpret a different one).

I have tested the interpreter with all the [Wikipedia examples](https://en.wikipedia.org/wiki/Brainfuck#Examples), and in `program.txt` there's the [ROT-13 cipher](https://en.wikipedia.org/wiki/ROT13) one. To use it just execute the Interpreter class by typing  `java Interpreter program.txt` in the command line (it will automatically move into the parent class and get the full path needed for the FileReader java class), and start writing characters one at the time; when finished use `CTRL-C` to terminate the program.