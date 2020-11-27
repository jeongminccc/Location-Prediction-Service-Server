package com.chamjik.dbserver.mapper;

import com.chamjik.dbserver.domain.RawVO;

import java.util.List;

public interface RawMapper {

    public List<RawVO> findAll() throws Exception;

    public List<RawVO> findByAuthor(String author) throws Exception;

    public void insertRaw(List<RawVO> raws) throws Exception;

    public void deleteRaw(List<RawVO> raws) throws Exception;

    public void deleteAuthor(String author) throws Exception;
}