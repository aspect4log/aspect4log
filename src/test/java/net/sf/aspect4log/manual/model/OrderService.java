package net.sf.aspect4log.manual.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.foo.service.FooService;
import org.slf4j.Logger;

import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Exceptions;
import net.sf.aspect4log.Log.Level;
import net.sf.aspect4log.slf4j.LoggerFactory;

@Log
public class OrderService {

	private final Logger logger = LoggerFactory.getLogger(FooService.class);

	AtomicInteger nextOrderId = new AtomicInteger(0);

	@Log(enterLevel = Level.INFO, exitLevel = Level.INFO,
			argumentsTemplate = "${args[0].id}", resultTemplate = "${result.id}",
			mdcKey = "customerId", mdcTemplate = "${args[0].id}")
	public Order createOrder(Customer customer, String address, Item... items) throws BusinessException, SecurityException {
		validateCustomer(customer);
		validateAddress(address);
		for (Item item : items) {
			validateItem(item);
		}
		return storeOrder(new Order(customer, address, items));
	}

	@Log(enterLevel = Level.INFO, exitLevel = Level.INFO,
			argumentsTemplate = "customerId=${args[0].id}, order=${args[1].id}",
			mdcKey = "customerId", mdcTemplate = "${args[0].id}",
			on = {
					@Exceptions(exceptions = { RuntimeException.class }, stackTrace = true),
					@Exceptions(exceptions = { PaymentException.class, SecurityException.class }, level = Level.WARN, stackTrace = false)
			})
	public void pay(Customer customer, Order order, String cardNumber) throws SecurityException, PaymentException {
		validateCustomer(customer);
		withdrawFunds(cardNumber, order.getPrice());
	}

	@Log(argumentsTemplate = "${args[1]}")
	private void withdrawFunds(String cardNumber, BigDecimal price) throws PaymentException {
		// we don't want to show a card number in a log
	}

	@Log(resultTemplate = "${result.id}")
	private Order storeOrder(Order order) {
		// we want to print only the order id in the result log
		order.setId(nextOrderId.getAndIncrement());
		saveToDb(order);
		return order;
	}

	private void saveToDb(Order order) {
		// TODO Auto-generated method stub

	}

	private void validateItem(Item item) throws BusinessException {
		if (getItemCount(item.getName()) > 0) {
			throw new BusinessException("store has no more items of type" + item.getName());
		}
	}

	private int getItemCount(String name) {
		// lets pretend there was an actual db request here
		return name.length() - 5;
	}

	private void validateAddress(String address) throws BusinessException {
		if (address.isEmpty()) {
			throw new BusinessException("address is empty");
		}
	}

	private void validateCustomer(Customer customer) throws SecurityException {
		if (customer.getId() < 0) {
			throw new SecurityException("Customer with negative id are prohibited to place orders");
		}
	}

	@Log(enterLevel = Level.NONE, exitLevel = Level.NONE, on = @Exceptions(level = Level.NONE), indent = false)
	public List<Item> recursiveItemSearch(Item itemExample) {
		// ..some comparison and search code goes here
		return recursiveItemSearch(itemExample);
	}

	public void canelOrder(Customer customer, Order order) throws SecurityException, OrderAlreadySentException, PaymentException {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("↓refund(" + customer + "," + order + ")");
			}
			try {
				validateCustomer(customer);
				checkIfNotSent(order);
				refund(customer, order);
			} catch (SecurityException e){
				if (logger.isWarnEnabled()) {
					logger.warn("↑refund(" + customer + "," + order + ")" + " => " + e);
				}
				throw e;
			} catch (OrderAlreadySentException e){
				if (logger.isWarnEnabled()) {
					logger.warn("↑refund(" + customer + "," + order + ")" + " => " + e);
				}
				throw e;
			} catch( PaymentException e) {
				if (logger.isWarnEnabled()) {
					logger.warn("↑refund(" + customer + "," + order + ")" + " => " + e);
				}
				throw e;
			}
			if (logger.isDebugEnabled()) {
				logger.debug("↑refund(" + customer + "," + order + ")");
			}
		} catch (RuntimeException e) {
			if (logger.isErrorEnabled()) {
				logger.error("↑refund(" + customer + "," + order + ")" + " => " + e);
			}
			throw e;
		}
	}

	@Log
	public void canel0der(Customer customer, Order order) throws SecurityException, OrderAlreadySentException, PaymentException {
		validateCustomer(customer);
		checkIfNotSent(order);
		refund(customer, order);
	}

	private void checkIfNotSent(Order order) throws OrderAlreadySentException {
		// .. here goes implementation code
	}

	private void refund(Customer customer, Order order) throws PaymentException {
		// .. here goes implementation code
	}
}
