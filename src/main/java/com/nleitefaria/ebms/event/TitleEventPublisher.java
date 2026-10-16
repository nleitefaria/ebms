package com.nleitefaria.ebms.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TitleEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(TitleEventPublisher.class);

    private final KafkaTemplate<String, TitleEvent> kafkaTemplate;
    private final String titleEventsTopic;

    public TitleEventPublisher(
            KafkaTemplate<String, TitleEvent> kafkaTemplate,
            @Value("${app.kafka.topics.title-events}") String titleEventsTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.titleEventsTopic = titleEventsTopic;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publish(TitleEvent event) {
        kafkaTemplate.send(titleEventsTopic, event.employeeId().toString(), event)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        LOGGER.error(
                                "Failed to publish {} event for title {} of employee {}",
                                event.eventType(),
                                event.title(),
                                event.employeeId(),
                                error);
                    }
                });
    }
}
