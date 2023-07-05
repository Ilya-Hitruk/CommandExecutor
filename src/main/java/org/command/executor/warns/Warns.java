package org.command.executor.warns;

public enum Warns {

    TEMPLATE("Check correctness of arguments input. Example: METHOD_NAME --ARG1 VALUE1 --ARG2 VALUE2 ..."),
    NOT_VALID_ARGUMENTS("Not valid arguments"),
    NO_DECLARED_METHOD("Class with specified method wasn't found"),
    NO_SUCH_PACKAGE("Package wasn't found"),
    INVALID_OPERATION_WITH_CLASS("Invalid operation with class"),
    SPECIFIED_METHOD_CANT_BE_INVOKED("Specified method cant be invoked");


    final String message;

    Warns(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
