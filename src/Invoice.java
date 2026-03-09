import java.util.ArrayList;

public class Invoice {
    private Customer customer;
    private ArrayList<LineItem> items;

    public Invoice(Customer customer) {
        this.customer = customer;
        items = new ArrayList<>();
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public String generateInvoice() {
        String result = "===== INVOICE =====\n";
        result += customer.getInfo() + "\n\n";

        for (LineItem item : items) {
            result += item.toString() + "\n";
        }

        result += "\nTotal Due: $" + getTotalAmount();
        return result;
    }
}
