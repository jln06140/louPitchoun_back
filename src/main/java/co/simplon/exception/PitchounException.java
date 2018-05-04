package co.simplon.exception;

public class PitchounException extends RuntimeException {

    private final PitchounErrorEnum error;

    public PitchounException(PitchounErrorEnum error) {
        this.error = error;
    }

    public PitchounErrorEnum getError() {
        return error;
    }
}
