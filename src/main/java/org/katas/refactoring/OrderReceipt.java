package org.katas.refactoring;

import java.util.List;

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

        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.getTotalAmount()).append('\n');

            double salesTax = lineItem.getTotalAmount() * .10;
            totalAmount += lineItem.getTotalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(getTotalSalesTax(order.getLineItems()));
        output.append("Total Amount").append('\t').append(totalAmount);

        return output.toString();
    }

    private double getTotalSalesTax(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::getTotalAmount)
                .map(subTotalAmount -> subTotalAmount * 0.10)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}