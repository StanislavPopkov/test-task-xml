package ru.parsertest.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.parsertest.model.DocumentType;

import java.util.List;
import java.util.Objects;

@Repository
public class DocumentRepository implements AppRepository {

    private static final RowMapper<DocumentType> ROW_MAPPER = BeanPropertyRowMapper.newInstance(DocumentType.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    @Autowired
    public DocumentRepository(JdbcTemplate jdbcTemplate) {
        this.insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("documents_type")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean save(String value) {
        Objects.requireNonNull(value);
        DocumentType existingValue = get(value);
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("type", value.toUpperCase());
        if (existingValue == null) {
            return insert.execute(map) != 0;
        } else {
            return jdbcTemplate.update("UPDATE documents_type SET type=? WHERE id=?", value.toUpperCase(), existingValue.getId()) != 0;
        }
    }

    @Override
    public boolean delete(String value) {
        Objects.requireNonNull(value);
        return jdbcTemplate.update("DELETE FROM documents_type WHERE type=?", value) != 0;
    }

    @Override
    public DocumentType get(String value) {
        Objects.requireNonNull(value);
        List<DocumentType> documentTypeList = jdbcTemplate.query(
                "SELECT * FROM documents_type WHERE type=?", ROW_MAPPER, value.toUpperCase());
        return DataAccessUtils.singleResult(documentTypeList);
    }

    @Override
    public List<DocumentType> findByType(String value) {
        Objects.requireNonNull(value);
        StringBuilder str = new StringBuilder(value).append("%");
        return jdbcTemplate.query(
                "SELECT * FROM documents_type WHERE type ILIKE ?", ROW_MAPPER, str.toString());
    }

    @Override
    public List<DocumentType> getAll() {
        return jdbcTemplate.query("SELECT * FROM documents_type ORDER BY type", ROW_MAPPER);
    }
}
