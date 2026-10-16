package com.nleitefaria.ebms.repository;

import com.nleitefaria.ebms.entity.Titles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Titles, Titles.Id> {
}
