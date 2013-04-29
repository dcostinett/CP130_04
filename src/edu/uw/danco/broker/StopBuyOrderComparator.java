package edu.uw.danco.broker;

import edu.uw.ext.framework.order.StopBuyOrder;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 4/28/13
 * Time: 4:37 PM
 */
public class StopBuyOrderComparator implements Comparator<StopBuyOrder> {


    /**
     * Performs the comparison
     * @param o1 - first of two orders to be compared
     * @param o2 - second of two orders to be compared
     * @return - a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
     * greater than the second. Where the lesser order has the the lowest price, if prices are equal the lesser order
     * will have the highest order quantity, finally if price and quantity are equal the lesser order will have the
     * lower order id.
     */
    @Override
    public int compare(StopBuyOrder o1, StopBuyOrder o2) {
        int result;

        result = o1.getPrice() > o2.getPrice() ? 1 : o1.getPrice() < o2.getPrice() ? -1 : 0;

        if (result == 0) {
            result = o1.getNumberOfShares() > o2.getNumberOfShares() ? 1 :
                             o1.getNumberOfShares() < o2.getNumberOfShares() ? -1 : 0;
        }

        if (result == 0) {
            result = o1.getOrderId() > o2.getOrderId() ? 1 :
                             o1.getOrderId() < o2.getOrderId() ? -1 : 0;
        }

        return result;
    }
}
