package bank.domain;

public class BookReturnEvent {

    private String message;

    public BookReturnEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BookReturnEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
