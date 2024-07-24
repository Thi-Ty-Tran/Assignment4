import java.util.Date;
import java.text.SimpleDateFormat;

public class PerishableProduct extends Product {
    private Date expiryDate;

    // Parameterized constructor
    public PerishableProduct(String sku,
                             String name,
                             double unitCost,
                             double salePrice,
                             int quantity,
                             int quantityNeeded,
                             String specialInstructions,
                             Date expiryDate) {
        super(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions);
        setExpiryDate(expiryDate);
    }

    public final void setExpiryDate(Date expiryDate) {
        if (expiryDate != null) {
            this.expiryDate = expiryDate;
        } else {
            throw new IllegalArgumentException("Expiry date cannot be null.");
        }
    }

    // Overridden display function
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() + "\n" +
                "Expiry Date: " + sdf.format(expiryDate);
    }
}