package view.output;

public enum Message {
	START_GAME("####   START GAME    ####\n"),
    END_GAME("\n####   END GAME   ####\n"),
    RESULT_GAME("Game result: "),
    RESULT_WINNER("The winner is "),
    HEADER_SEPARATOR("----------------------"),
    PLAYER_TURN("Turn "),
    CHOOSE_COLUMN("Choose a column:"),
    CHOSEN_COLUMN("Column played: "),
    INPUT_ERROR("ERROR! This column is not valid, choose another column: ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void print() {
        System.out.println(getValue());
    }

    public void print(String variable) {
        System.out.println(getValue() + variable);
    }
    
    public static void printLine(String message) {
        System.out.println(message);
    }
}
