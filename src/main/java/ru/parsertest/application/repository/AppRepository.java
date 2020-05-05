package ru.parsertest.application.repository;

import ru.parsertest.model.DocumentType;

import java.util.List;

public interface AppRepository {

    boolean save(String value);

    boolean delete(String value);

    DocumentType get(String value);

    List<DocumentType> findByType(String value);

    List<DocumentType> getAll();
}