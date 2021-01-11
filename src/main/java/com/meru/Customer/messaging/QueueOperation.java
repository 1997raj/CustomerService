package com.meru.Customer.messaging;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.meru.Customer.service.CustomerService;

@Component
public class QueueOperation {
	
	private final String CART_CREATE_QUEUE= "cart.CREATE";
	private final String CART_DELETE_QUEUE = "cart.DELETE";
	private final String ADD_CUSTOMER_TO_ORDER_REQUEST = "order.request.new.SET_CUSTOMER";
	private final String ADD_CART_TO_ORDER_REQUEST = "order.request.new.SET_CART";
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void createEmptyCartForCustomerId(long custID)
	{
		jmsTemplate.send(CART_CREATE_QUEUE, new MessageCreator() {
			@Override
			public MapMessage createMessage(Session session) throws JMSException {
				MapMessage msg=session.createMapMessage();
				msg.setLongProperty("customerID", custID);
				return msg;
			}
		});
	}
	
	public void deleteCartForCustomerId(long custID)
	{
		jmsTemplate.send(CART_DELETE_QUEUE,new MessageCreator() {
			
			@Override
			public MapMessage createMessage(Session session) throws JMSException {
				MapMessage msg = session.createMapMessage();
				msg.setLongProperty("customerID", custID);
				return msg;
			}
		});
	}
	
	@JmsListener(destination = ADD_CUSTOMER_TO_ORDER_REQUEST)
	@SendTo(ADD_CART_TO_ORDER_REQUEST)
	public String addCustomerToOrderRequest(String jsonOrderRequest)
	{
		return this.service.addCustomerToOrderRequest(jsonOrderRequest);
	}
}
