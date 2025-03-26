package command;

import static deck.DeckManager.createDeck;

import deck.Deck;
import exceptions.FlashCLIillegalArgumentException;
import ui.Ui;

public class CommandCreateDeck extends Command{
    public final String arguments;

    public CommandCreateDeck(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand() {
        try {
            Ui.showToUser(createDeck(arguments));
        } catch (FlashCLIillegalArgumentException e) {
            Ui.showError(e.getMessage());
        }
    }

}
