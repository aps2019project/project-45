package model;

public enum PlayingMode {
    FIRST("Killing opponent hero"),
    SECOND("Holding flag for 6 turns"),
    THIRD("Obtaining half of the flags");

    private String message;

    public String getMessage() {
        return message;
    }

    PlayingMode(String message) {
        this.message = message;
    }
}
