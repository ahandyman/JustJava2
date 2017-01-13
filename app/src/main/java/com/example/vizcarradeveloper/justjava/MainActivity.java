package com.example.vizcarradeveloper.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 * Resulting in a Summary of the Order
 * Name
 * Quantity
 * Total Price
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 1;
    int price;
    String customerName = "Ramon Vizcarra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/**
 * Practice calling object methods
 *
 TextView helloWorld = new TextView(this);
 helloWorld.setText("I love the match");
 helloWorld.setTextSize(18);
 helloWorld.setTextColor(Color.RED);
 setContentView(helloWorld);
 *
 */

        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
     * @return quantity * pricePerCup = total price
     */
    private int calculatePrice() {
        return quantity * pricePerCup;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox_toppings1);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox_toppings2);
        boolean hasChocolate = chocolate.isChecked();

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

        String orderMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
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
    private String createOrderSummary(int priceOfOrder, boolean topping_WC, boolean topping_choc) {

        String orderName = "Name: " + customerName;
        String orderToppings = "\n \nWhipped Cream: " + topping_WC;
        String orderToppings2 = "\n \nChocolate: " + topping_choc;
        String orderQuantity = "\n \nQuantity: " + quantity;
        String orderTotal = "\n \nTotal: $" + priceOfOrder;
        String orderSummary = orderName + orderToppings + orderToppings2 + orderQuantity + orderTotal + "\n \n Thank you!";

        return orderSummary;
    }


}