package com.nleitefaria.ebms.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EmployeeEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeEventPublisher.class);

    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;
    private final String employeeEventsTopic;

    public EmployeeEventPublisher(
            KafkaTemplate<String, EmployeeEvent> kafkaTemplate,
            @Value("${app.kafka.topics.employee-events}") String employeeEventsTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.employeeEventsTopic = employeeEventsTopic;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publish(EmployeeEvent event) {
        kafkaTemplate.send(employeeEventsTopic, event.employeeId().toString(), event)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        LOGGER.error(
                                "Failed to publish {} event for employee {}",
                                event.eventType(),
                                event.employeeId(),
                                error);
                    }
                });
    }
}
