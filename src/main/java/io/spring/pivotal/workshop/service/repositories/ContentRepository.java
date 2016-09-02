package io.spring.pivotal.workshop.service.repositories;

import org.springframework.data.repository.CrudRepository;

import io.spring.pivotal.workshop.service.domain.Content;

public interface ContentRepository extends CrudRepository<Content, String> {
}
