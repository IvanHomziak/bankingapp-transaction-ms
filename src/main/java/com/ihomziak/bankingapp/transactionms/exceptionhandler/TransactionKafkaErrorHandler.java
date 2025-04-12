package com.ihomziak.bankingapp.transactionms.exceptionhandler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.ihomziak.bankingapp.transactionms.exception.TransactionCancellationException;
import com.ihomziak.bankingapp.transactionms.exception.TransactionNotFoundException;

@Component("kafkaListenerErrorHandler")
public class TransactionKafkaErrorHandler implements KafkaListenerErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(TransactionKafkaErrorHandler.class);
	private final GlobalExceptionHandler globalExceptionHandler;

	@Autowired
	public TransactionKafkaErrorHandler(GlobalExceptionHandler globalExceptionHandler) {
		this.globalExceptionHandler = globalExceptionHandler;
	}

	@Override
	public TransactionKafkaErrorHandler handleError(Message<?> message, ListenerExecutionFailedException exception) {
		// Отримуємо ConsumerRecord із повідомлення
		ConsumerRecord<?, ?> consumerRecord = (ConsumerRecord<?, ?>) message.getPayload();

		// Логуємо деталі помилки
		log.error("Error processing Kafka message: topic={}, partition={}, offset={}, error={}",
			consumerRecord.topic(),
			consumerRecord.partition(),
			consumerRecord.offset(),
			exception.getMessage());

		// Додаємо базову логіку обробки винятків
		// Виклик логіки з GlobalExceptionHandler
		if (exception.getCause() instanceof TransactionNotFoundException transactionNotFoundException) {
			globalExceptionHandler.handleException(transactionNotFoundException, null); // Логується через GlobalExceptionHandler
			return this;
		}
		return this;
	}
}