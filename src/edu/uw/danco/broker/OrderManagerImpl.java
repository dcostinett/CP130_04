package edu.uw.danco.broker;

import edu.uw.ext.framework.broker.OrderManager;
import edu.uw.ext.framework.broker.OrderProcessor;
import edu.uw.ext.framework.order.StopBuyOrder;
import edu.uw.ext.framework.order.StopSellOrder;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 4/28/13
 * Time: 2:50 PM
 */
public class OrderManagerImpl implements OrderManager {

    /** The stock ticker symbol being managed by this instance */
    private String symbol;

    /** The price of the current stock being managed */
    private int price;


    /**
     * Constructor to be used by sub classes to finish initialization.
     */
    public OrderManagerImpl() {
    }

    /**
     * Constructor
     * @param symbol - the ticker symbol of the stock this instance is manage orders for
     * @param price - the current price of stock to be managed
     */
    public OrderManagerImpl(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;
    }


    /**
     * Gets the stock ticker symbol for the stock managed by this stock manager
     * @return - the stock ticker symbol
     */
    @Override
    public String getSymbol() {
        return symbol;
    }


    /**
     * Respond to a stock price adjustment by setting threshold on dispatch filters.
     * @param price - the new price
     */
    @Override
    public void adjustPrice(int price) {
        this.price = price;
    }


    /**
     *
     * @param order
     */
    @Override
    public void queueOrder(final StopBuyOrder order) {

    }


    /**
     *
     * @param order
     */
    @Override
    public void queueOrder(final StopSellOrder order) {

    }


    /**
     *
     * @param processor
     */
    @Override
    public void setOrderProcessor(final OrderProcessor processor) {

    }
}
