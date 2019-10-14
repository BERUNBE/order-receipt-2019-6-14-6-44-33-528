package org.katas.refactoring;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.getTotalAmount()).append('\n');

            double salesTax = lineItem.getTotalAmount() * .10;
            totalSalesTax += salesTax;
            totalAmount += lineItem.getTotalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);

        return output.toString();
    }
}