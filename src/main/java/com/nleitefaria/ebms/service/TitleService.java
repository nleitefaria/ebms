package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Titles;
import com.nleitefaria.ebms.repository.TitleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TitleService {

    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public List<Titles> findAll() {
        return titleRepository.findAll();
    }

    public Optional<Titles> findById(Titles.Id id) {
        return titleRepository.findById(id);
    }

    @Transactional
    public Titles save(Titles title) {
        return titleRepository.save(title);
    }

    @Transactional
    public void deleteById(Titles.Id id) {
        titleRepository.deleteById(id);
    }
}
