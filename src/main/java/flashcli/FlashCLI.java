package flashcli;

import static constants.CommandConstants.EXIT;

import command.Command;
import parser.Parser;
import static ui.Ui.getUserCommand;

public class FlashCLI {
    /**
     * Main entry-point for the java.flashcli.FlashCLI application.
     */
    public static void main(String[] args) {
        //assert false : "dummy assertion set to fail";
        System.out.println("Welcome to FlashCLI!");
        String fullInputLine = getUserCommand();

        while (!(fullInputLine.equals(EXIT))) {
            try {
                Command c = Parser.parseInput(fullInputLine);
                c.executeCommand();
            } catch (IllegalArgumentException e) {
                System.out.println("Possible commands are: add, view_qn, view_ans, edit, list, delete and exit");
            } finally {
                fullInputLine = getUserCommand();
            }
        }

        System.out.println("Thank you for using FlashCLI!");
    }
}
