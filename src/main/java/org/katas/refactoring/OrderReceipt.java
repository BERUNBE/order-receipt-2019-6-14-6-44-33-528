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

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.getTotalAmount()).append('\n');
        }

        double totalSalesTax = getTotalSalesTax();
        double totalAmountWithTax = getTotalAmount() + totalSalesTax;
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmountWithTax);

        return output.toString();
    }

    private double getTotalSalesTax() {
        return order.getLineItems().stream()
                .map(LineItem::getTotalAmount)
                .map(subTotalAmount -> subTotalAmount * 0.10)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private double getTotalAmount() {
        return order.getLineItems().stream()
                .map(LineItem::getTotalAmount)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}