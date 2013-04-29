package edu.uw.danco.broker;

import edu.uw.ext.framework.broker.OrderDispatchFilter;
import edu.uw.ext.framework.order.StopBuyOrder;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 4/28/13
 * Time: 4:51 PM
 *
 * Dispatch filter that dispatches any orders having a price below the current market price (threshold).
 */
public class StopBuyOrderDispatchFilter extends OrderDispatchFilter<Integer, StopBuyOrder> {

    /** Price of the StopBuyOrder */
    private int initPrice;


    /**
     * Constructor
     * @param initPrice - the initial price
     */
    public StopBuyOrderDispatchFilter(int initPrice) {
        this.initPrice = initPrice;
    }


    /**
     * Test the provided order against the threshold
     * @param order - the order to be tested for dispatch
     * @return - true if the order price is below or equal to the threshold
     */
    @Override
    public boolean check(StopBuyOrder order) {
        return order.getPrice() <= initPrice;
    }
}
