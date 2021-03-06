package edu.uw.danco;

import edu.uw.danco.broker.OrderQueueImpl;
import edu.uw.danco.broker.StopBuyOrderComparator;
import edu.uw.danco.broker.StopSellOrderComparator;
import edu.uw.ext.framework.broker.OrderDispatchFilter;
import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.order.Order;
import edu.uw.ext.framework.order.StopBuyOrder;
import edu.uw.ext.framework.order.StopSellOrder;

/*****************************************************************************
 * Replace these imports with the import of your implementing classes.       *
 *****************************************************************************/

import test.AbstractOrderQueueTest;

/**
 * Concrete subclass of AbstractQueueTest, provides implementations of the 
 * createStopBuyOrderQueue, createStopSellOrderQueue and createAnyOrderQueue
 * methods which create instances of "my" OrderQueue implementation class, using
 * "my" Comparator implementations.
 */
public class OrderQueueTest extends AbstractOrderQueueTest {
    /**
     * Creates an instance of "my" OrderQueue implementation class, using
     * an instance of "my" implementation of Comparator that is intended to
     * order StopBuyOrders.
     *
     * @param filter the OrderDispatch filter to be used
     * 
     * @return a new OrderQueue instance
     */
    protected final OrderQueue<StopBuyOrder> createStopBuyOrderQueue(
                        final OrderDispatchFilter<?, StopBuyOrder> filter) {
        /*********************************************************************
         * This needs to be an instance of your OrderQueue and Comparator.   *
         *********************************************************************/
        return new OrderQueueImpl<StopBuyOrder>(StopBuyOrderComparator.INSTANCE, filter);
    }

    /**
     * Creates an instance of "my" OrderQueue implementation class, using
     * an instance of "my" implementation of Comparator that is intended to
     * order StopSellOrders.
     *
     * @param filter the OrderDispatch filter to be used
     * 
     * @return a new OrderQueue instance
     */
    protected final OrderQueue<StopSellOrder> createStopSellOrderQueue(
                          final OrderDispatchFilter<?, StopSellOrder> filter) {
        /*********************************************************************
         * This needs to be an instance of your OrderQueue and Comparator.   *
         *********************************************************************/
        return new OrderQueueImpl<StopSellOrder>(StopSellOrderComparator.INSTANCE, filter);
    }
    
    /**
     * Creates an instance of "my" OrderQueue implementation class, the queue
     * will order the Orders according to their natural ordering.
     *
     * @param filter the OrderDispatch filter to be used
     * 
     * @return a new OrderQueue instance
     */
    protected final OrderQueue<Order> createAnyOrderQueue(
                            final OrderDispatchFilter<?, Order> filter) {
        /*********************************************************************
         * This needs to be an instance of your OrderQueue.                  *
         *********************************************************************/
        return new OrderQueueImpl<Order>(filter);
    }

}
