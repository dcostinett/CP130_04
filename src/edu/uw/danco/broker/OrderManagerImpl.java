package edu.uw.danco.broker;

import edu.uw.ext.framework.broker.OrderDispatchFilter;
import edu.uw.ext.framework.broker.OrderManager;
import edu.uw.ext.framework.broker.OrderProcessor;
import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.order.StopBuyOrder;
import edu.uw.ext.framework.order.StopSellOrder;

import java.util.Comparator;

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

    /** The processor that executes orders through the broker. */
    private OrderProcessor processor;

    /** The OrderQueue in which to place stop buy orders */
    private OrderQueue<StopBuyOrder> stopBuyOrderQueue;

    /** The OrderQueue in which to place stop sell orders */
    private OrderQueue<StopSellOrder> stopSellOrderQueue;

    /** The StopBuyOrder filter */
    private OrderDispatchFilter<Integer, StopBuyOrder> stopBuyOrderFilter;

    /** The StopSellOrder filter */
    private OrderDispatchFilter<Integer, StopSellOrder> stopSellOrderFilter;

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
    public OrderManagerImpl(final String symbol, int price) {
        this.symbol = symbol;
        this.price = price;

        stopBuyOrderFilter = new StopBuyOrderDispatchFilter(price);
        stopSellOrderFilter = new StopSellOrderDispatchFilter(price);

        stopBuyOrderQueue = new OrderQueueImpl<StopBuyOrder>(new StopBuyOrderComparator(), stopBuyOrderFilter);
        stopSellOrderQueue = new OrderQueueImpl<StopSellOrder>(new StopSellOrderComparator(), stopSellOrderFilter);
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
        stopBuyOrderFilter.setThreshold(price);
        stopBuyOrderQueue.dispatchOrders();
        stopSellOrderFilter.setThreshold(price);
        stopSellOrderQueue.dispatchOrders();
    }


    /**
     * Queue a stop buy order.
     * @param order - the order to queue
     */
    @Override
    public void queueOrder(final StopBuyOrder order) {
        stopBuyOrderQueue.enqueue(order);
        processor.process(order);
    }


    /**
     * Queue a stop sell order.
     * @param order - the order to queue
     */
    @Override
    public void queueOrder(final StopSellOrder order) {
        stopSellOrderQueue.enqueue(order);
        processor.process(order);
    }


    /**
     * Registers the processor to be used during order processing. This will be passed on to the order queues as the
     * dispatch callback.
     * @param processor - the callback to be registered
     */
    @Override
    public void setOrderProcessor(final OrderProcessor processor) {
        this.processor = processor;
    }


    /**
     * Sets the stock ticker symbol
     * @param stockTickerSymbol - the stockTickerSymbol to set
     */
    protected void 	setStockTickerSymbol(final String stockTickerSymbol) {
        symbol = stockTickerSymbol;
    }


    /**
     *
     * @param stopBuyOrderFilter
     */
    protected void 	setStopBuyOrderFilter(final OrderDispatchFilter<Integer,StopBuyOrder> stopBuyOrderFilter) {
        this.stopBuyOrderFilter = stopBuyOrderFilter;
    }


    /**
     *
     * @param stopBuyOrderQueue
     */
    protected void 	setStopBuyOrderQueue(final OrderQueue<StopBuyOrder> stopBuyOrderQueue) {
        this.stopBuyOrderQueue = stopBuyOrderQueue;
    }


    /**
     *
     * @param stopSellOrderFilter
     */
    protected void 	setStopSellOrderFilter(final OrderDispatchFilter<Integer, StopSellOrder> stopSellOrderFilter) {
        this.stopSellOrderFilter = stopSellOrderFilter;
    }


    /**
     *
     * @param stopSellOrderQueue
     */
    protected void 	setStopSellOrderQueue(final OrderQueue<StopSellOrder> stopSellOrderQueue) {
        this.stopSellOrderQueue = stopSellOrderQueue;
    }
}
