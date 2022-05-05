package testDoubles.dummy;

public class EmailServiceRepository implements EmailService {
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("method not implemented");
    }
}
