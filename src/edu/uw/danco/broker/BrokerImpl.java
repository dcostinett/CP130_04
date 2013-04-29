package edu.uw.danco.broker;

import edu.uw.danco.account.AccountFactoryImpl;
import edu.uw.danco.account.AccountManagerImpl;
import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.broker.Broker;
import edu.uw.ext.framework.broker.BrokerException;
import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.exchange.ExchangeEvent;
import edu.uw.ext.framework.exchange.ExchangeListener;
import edu.uw.ext.framework.exchange.StockExchange;
import edu.uw.ext.framework.exchange.StockQuote;
import edu.uw.ext.framework.order.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 4/28/13
 * Time: 2:14 PM
 */
public class BrokerImpl implements Broker, ExchangeListener {
    /** The logger */
    private static final Logger LOGGER = Logger.getLogger(BrokerImpl.class.getName());

    /** The name of this broker instance */
    private String brokerName;

    /** The account manager used by this broker */
    private AccountManager acctManager;

    /** The stock exchange used by this broker */
    private StockExchange exchange;


    /**
     * Constructor for sub classes
     */
    protected BrokerImpl() {
    }


    /**
     * Constructor
     * @param brokerName - name of the broker
     * @param acctManager - the account manager used by this broker
     * @param exchange - the stock exchange used by this broker
     */
    public BrokerImpl(final String brokerName, final AccountManager acctManager, final StockExchange exchange) {
        this.brokerName = brokerName;
        this.acctManager = acctManager;
        this.exchange = exchange;
    }

    /**
     * Returns the name of this broker
     * @return
     */
    @Override
    public String getName() {
        return brokerName;
    }

    /**
     * Create an account with this broker
     * @param username
     * @param password
     * @param balance
     * @return
     * @throws BrokerException
     */
    @Override
    public Account createAccount(String username, String password, int balance) throws BrokerException {
        Account account = null;
        try {
            account = acctManager.createAccount(username, password, balance);
        } catch (final AccountException e) {
            LOGGER.log(Level.SEVERE, "Unable to create account for " + username, e);
            throw new BrokerException(e);
        }

        return account;
    }

    @Override
    public void deleteAccount(String username) throws BrokerException {

    }

    @Override
    public Account getAccount(String username, String password) throws BrokerException {
        return null;
    }

    @Override
    public StockQuote requestQuote(String ticker) throws BrokerException {
        return null;
    }

    @Override
    public void placeOrder(MarketBuyOrder order) throws BrokerException {

    }

    @Override
    public void placeOrder(MarketSellOrder order) throws BrokerException {

    }

    @Override
    public void placeOrder(StopBuyOrder order) throws BrokerException {

    }

    @Override
    public void placeOrder(StopSellOrder order) throws BrokerException {

    }

    @Override
    public void close() throws BrokerException {

    }

    @Override
    public void exchangeOpened(ExchangeEvent event) {

    }

    @Override
    public void exchangeClosed(ExchangeEvent event) {

    }

    @Override
    public void priceChanged(ExchangeEvent event) {

    }

    /**
     * Sets the account manager.
     * @param accountManager
     */
    protected void setAccountManager(final AccountManager accountManager) {
        this.acctManager = accountManager;
    }


    /**
     * Sets the market order queue's dispatch filter.
     * @param marketDispatchFilter
     */
    protected void setMarketDispatchFilter(final MarketDispatchFilter marketDispatchFilter) {

    }


    /**
     * Sets the market order queue.
     * @param marketOrders
     */
    protected void setMarketOrderQueue(final OrderQueue<Order> marketOrders) {

    }


    /**
     * Sets the broker name.
     * @param name
     */
    protected void setName(final String name) {
        this.brokerName = name;
    }


    /**
     * Sets the stock exchange.
     * @param stockExchange
     */
    protected void setStockExchange(final StockExchange stockExchange) {
        this.exchange = stockExchange;
    }

}
