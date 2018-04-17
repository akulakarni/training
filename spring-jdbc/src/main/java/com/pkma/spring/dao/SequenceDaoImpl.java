package com.pkma.spring.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SequenceDaoImpl implements SequenceDao {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer getPlayerId(final String sequenceName) {
        final StringBuilder sql = new StringBuilder();
        sql.append("select next value for ").append(sequenceName);

        final Map<String, Object> params = new HashMap<String, Object>();

        final Integer nextSequenceNumber = namedParameterJdbcTemplate.queryForObject(sql.toString(), params,
                Integer.class);

        System.out.println("{} Queried {} Next Sequence Number for Sequence name: {} ");
        return nextSequenceNumber;
    }

}
