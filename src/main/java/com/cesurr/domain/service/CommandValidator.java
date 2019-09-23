package com.cesurr.domain.service;

import org.springframework.stereotype.Component;

/** To validate formats and application contraints 
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
@Component
public final class CommandValidator {

	public String[] format(String subCommand, CommandType commandType) throws Exception {
        String[] argumentsLine;

        if (subCommand == null || subCommand.trim().length() == 0) {
            throw new Exception("Unespected empty row Command!");
        }

        argumentsLine = subCommand.trim().split("\\s+");

        switch (commandType) {
            case NUMCASES:

                if (argumentsLine.length != 1) {
                    throw new Exception("Unexpected number of command-line arguments! [" + subCommand + "]");
                }
                if (!isNumber(argumentsLine[0])) {
                    throw new Exception("Bad Arguments Type! [" + subCommand + "]");
                }
                if (!(Integer.valueOf(argumentsLine[0]) >= 1 && Integer.valueOf(argumentsLine[0]) <= 50)) {
                    throw new Exception("Constraint Violation! [1<=Number of Cases<=50]");
                }
                break;
            case MATRIXPARMS:
                if (argumentsLine.length != 2) {
                    throw new Exception("Unexpected number of command-line arguments! [" + subCommand + "]");
                }

                for (int i = 0; i < 2; i++) {
                    if (!isNumber(argumentsLine[i])) {
                        throw new Exception("Bad Arguments Type! [" + subCommand + "]");
                    }

                    int parm = Integer.valueOf(argumentsLine[i]);

                    if (i == 0) {
                        if (!(parm > 1 && parm <= 100)) {
                            throw new Exception("Constraint Violation! [1<=Matriz Size<=50]");
                        }

                    } else {
                        if (!(parm > 1 && parm <= 1000)) {
                            throw new Exception("Constraint Violation! [1<=Number of Operations<=50]");
                        }
                    }
                }

                break;
            case OPERATIONS:
                int numParms;

                if (argumentsLine[0].equals("UPDATE")) {
                    numParms = 5;
                } else if (argumentsLine[0].equals("QUERY")) {
                    numParms = 7;
                } else {
                    throw new Exception("Unknown Operation! [" + argumentsLine[0] + "]");
                }

                if (argumentsLine.length != numParms) {
                    throw new Exception("Unexpected number of command-line arguments! [" + subCommand + "]");
                }

                for (int i = 1; i < numParms; i++) {
                    if (!isNumber(argumentsLine[i])) {
                        throw new Exception("Bad Arguments Type! [" + subCommand + "]");
                    }

                }

                break;

        }

        return argumentsLine;

    }

    public boolean isNumber(String parm) {
        try {
            Integer.valueOf(parm);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public enum CommandType {

        NUMCASES, MATRIXPARMS, OPERATIONS
    }
}
