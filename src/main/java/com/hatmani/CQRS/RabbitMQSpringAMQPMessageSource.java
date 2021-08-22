package com.hatmani.CQRS;

import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
import org.axonframework.extensions.amqp.eventhandling.AMQPMessageConverter;
import org.axonframework.extensions.amqp.eventhandling.spring.SpringAMQPMessageSource;
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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Slf4j
@Component("rabbitMQSpringAMQPMessageSource")
public class RabbitMQSpringAMQPMessageSource extends SpringAMQPMessageSource {
	private Logger logger = LoggerFactory.getLogger(BankingCqrsQueryApplication.class);
	@Bean
	public Exchange exchange() {
		return ExchangeBuilder.fanoutExchange("AccountEvent2").build();
	}

	@Bean
	public Queue queue() {
		return QueueBuilder.durable("AccountEvent2").build();
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
	}

	@Autowired
	public void configure(AmqpAdmin admin) {
		admin.declareExchange(exchange());
		admin.declareQueue(queue());
		admin.declareBinding(binding());

	}
	
	
    @Autowired
    public RabbitMQSpringAMQPMessageSource(final AMQPMessageConverter messageConverter) {
        super(messageConverter);
    }

   @RabbitListener(queues = "AccountEvent2")
    @Override
    public void onMessage(final Message message, final Channel channel) {
       
    	System.out.println("=========>Event Received<======= "+message);
    	//logger.debug("received message: message={}, channel={}", message, channel);
        super.onMessage(message, channel);
    }

}
