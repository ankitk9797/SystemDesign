package uber.payment;

public class CardPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment using credit card for amount: " + amount);
    }
}
