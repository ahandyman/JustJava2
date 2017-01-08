package com.example.vizcarradeveloper.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 1;
    int price;
    String customerName = "Ramon Vizcarra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the decrease button is clicked
     */
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method is called when the increase button is clicked
     */
    public void increment(View view) {
        quantity += 1;
        display(quantity);
    }


    /**
     * Calculates the price of the order
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * pricePerCup;


    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        instead of createOrderSummary(calculatePrice())
//        varibale price was used
        price = calculatePrice();

        //        IMPORTANT
//          I don't know why this works but the method createOrder summary needs to be in a string
//          and that string needs to be in the displayMessage() method
//        OR
//        displayMessage(createOrderSummary(price));
//        OR
//        displayMessage(createOrderSummary(calculatePrice()));

        String orderMessage = createOrderSummary(price);
        displayMessage(orderMessage);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * @param priceOfOrder
     * @return text summary
     */
    private String createOrderSummary(int priceOfOrder) {

        String orderName = "Name: " + customerName;
        String orderQuantity = "\n \n Quantity " + quantity;
        String orderTotal = "\n \n Total: $" + priceOfOrder;
        String orderSummary = orderName + orderQuantity + orderTotal + "\n \n Thank you!";

        return orderSummary;
    }


}