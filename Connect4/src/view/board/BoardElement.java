package view.board;

public enum BoardElement {
	SQUARE("%s"),
    COLUMN_HEADER("%s \n"),
    EDGE_SEPARATOR("|"),
    FINAL_EDGE_SEPARATOR("|\n"),
    LINE_SEPARATOR("_______________\n");

    private final String value;

    BoardElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void print() {
        System.out.print(getValue());
    }

    public void print(String variable) {
        System.out.print(String.format(this.getValue(), variable));
    }

}
