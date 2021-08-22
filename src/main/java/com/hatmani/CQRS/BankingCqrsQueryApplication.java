package com.hatmani.CQRS;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.extensions.amqp.eventhandling.AMQPMessageConverter;
import org.axonframework.extensions.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.hatmani.commands.events.AccountCreatedEvent;
import com.rabbitmq.client.Channel;

/*import javax.websocket.OnMessage;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
//import org.axonframework.extensions.amqp.eventhandling.DefaultAMQPMessageConverter;
//import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
//import org.axonframework.extensions.amqp.eventhandling.spring.SpringAMQPMessageSource;
//import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.hatmani.CQRS.events.AccountCreatedEvent;
import com.rabbitmq.client.Channel;

*/

@SpringBootApplication
public class BankingCqrsQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingCqrsQueryApplication.class, args);
	}

	private Logger log = LoggerFactory.getLogger(BankingCqrsQueryApplication.class);

	/*
	 * @Bean SpringAMQPMessageSource inputMessageSource(final AMQPMessageConverter
	 * messageConverter) { log.info("**********inputMessageSource"); return new
	 * SpringAMQPMessageSource(messageConverter) {
	 * 
	 * @RabbitListener(queues = "AccountEvent2")
	 * 
	 * @Override public void onMessage(final Message message, final Channel channel)
	 * { log.debug("**********received external message: {}, channel: {}", message,
	 * channel); super.onMessage(message, channel); } }; }
	 */
	/*
	 * @ProcessingGroup(value = "amqpEvents")
	 * 
	 * @RestController public class eventss {
	 * 
	 * @EventHandler public void on(Object event) { System.out.
	 * println("!!!!!!!!!BOOOOOM AccountCreatedEvent Message received from command part"
	 * ); System.out.
	 * println("!!!!!!!!!BOOOOOM AccountCreatedEvent Message received from command part"
	 * +event.getClass()); System.out.
	 * println("!!!!!!!!!BOOOOOM AccountCreatedEvent Message received from command part"
	 * +event.toString()); }
	 * 
	 * @EventHandler public void on(AccountCreatedEvent event) { System.out.
	 * println("#######!!!!!!!!!BOOOOOM AccountCreatedEvent Message received from command part"
	 * ); System.out.println("#######!!!!!!!!!BOOOOOM"+event.getId());
	 * System.out.println("#######!!!!!!!!!BOOOOOM"+event.toString());
	 * 
	 * log.debug("event: {}", event); //String orderId = event.getOrderId();
	 * 
	 * } }
	 */
	/*
	 * @Bean // org.axonframework.messaging.StreamableMessageSource public
	 * SpringAMQPMessageSource springAMQPMessageSource(Serializer serializer) {
	 * //Builder builder = new Builder(); //DefaultAMQPMessageConverter
	 * defaultconverter = new DefaultAMQPMessageConverter(serializer); //new
	 * SpringAMQPMessageSource() SpringAMQPMessageSource springAMQPMessageSource;
	 * springAMQPMessageSource= new SpringAMQPMessageSource(serializer) {
	 * 
	 * @RabbitListener(queues="AccountEvent2")
	 * 
	 * @Override public void onMessage(Message message, Channel channel) { // TODO
	 * Auto-generated method stub
	 * System.out.println("Message received from command part");
	 * super.onMessage(message, channel); }
	 * 
	 * 
	 * };
	 * 
	 * 
	 * 
	 * System.out.println("++++++++++++++++++++");
	 * System.out.println(springAMQPMessageSource.getClass()); return
	 * springAMQPMessageSource; }
	 */

	/*
	 * @Bean public SpringAMQPMessageSource testdemo(Serializer serializer) {
	 * System.out.println("--- On Message Call ---");
	 * 
	 * return new SpringAMQPMessageSource(serializer) {
	 * 
	 * @RabbitListener(queues = "AccountEvent2")
	 * 
	 * @Override public void onMessage(Message message, Channel channel) {
	 * System.out.println("############");
	 * System.out.println(message.getMessageProperties());
	 * System.out.println("channel == "+channel); super.onMessage(message, channel);
	 * } }; }
	 */

	/*
	 * @Autowired public void configure(EventHandlingConfiguration ehConfig,
	 * SpringAMQPMessageSource myMessageSource) {
	 * ehConfig.registerSubscribingEventProcessor("myProcessor", c ->
	 * myMessageSource); }
	 */

}
