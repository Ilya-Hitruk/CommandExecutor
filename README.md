# CommandExecutor

This project is a library for parsing command-line arguments and subsequently executing entered commands.

Tasks for this project:

-Given a package path, find all classes annotated with the "Command" annotation that implement the Runnable interface.
-Parse command-line arguments:
-Get the command name (1-st argument).
-Parse all parameters (name-value pairs).
-Based on the command name, find the class responsible for that command.
-Find all fields annotated as "Param" and match them with the passed arguments.
-Create an instance of the class.
-Set all parameters.
-Execute the method of that class (command classes must implement the Runnable interface).
