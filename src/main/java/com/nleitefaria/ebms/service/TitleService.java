package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Titles;
import com.nleitefaria.ebms.event.TitleEvent;
import com.nleitefaria.ebms.repository.TitleRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TitleService {

    private final TitleRepository titleRepository;
    private final ApplicationEventPublisher eventPublisher;

    public TitleService(TitleRepository titleRepository, ApplicationEventPublisher eventPublisher) {
        this.titleRepository = titleRepository;
        this.eventPublisher = eventPublisher;
    }

    public List<Titles> findAll() {
        return titleRepository.findAll();
    }

    public Optional<Titles> findById(Titles.Id id) {
        return titleRepository.findById(id);
    }

    @Transactional
    public Titles save(Titles title) {
        Titles savedTitle = titleRepository.save(title);
        eventPublisher.publishEvent(TitleEvent.saved(savedTitle));
        return savedTitle;
    }

    @Transactional
    public void deleteById(Titles.Id id) {
        titleRepository.deleteById(id);
        eventPublisher.publishEvent(TitleEvent.deleted(id));
    }
}
