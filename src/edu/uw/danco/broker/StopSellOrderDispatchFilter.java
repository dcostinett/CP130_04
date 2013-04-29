package edu.uw.danco.broker;

import edu.uw.ext.framework.broker.OrderDispatchFilter;
import edu.uw.ext.framework.order.StopSellOrder;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 4/28/13
 * Time: 5:00 PM
 */
public class StopSellOrderDispatchFilter extends OrderDispatchFilter<Integer, StopSellOrder> {

    /** The initial price (threshold) */
    private int initPrice;


    /**
     * Cosntructor
     * @param initPrice - the initial price
     */
    public StopSellOrderDispatchFilter(int initPrice) {
        this.initPrice = initPrice;
    }


    /**
     * Test the provided order against the threshold
     * @param order - the order to be tested for dispatch
     * @return - true if the order to be tested is above or equal to the threshold
     */
    @Override
    public boolean check(StopSellOrder order) {
        return order.getPrice() >= initPrice;
    }
}
