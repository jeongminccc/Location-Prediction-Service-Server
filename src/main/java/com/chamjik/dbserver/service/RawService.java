package com.chamjik.dbserver.service;

import com.chamjik.dbserver.domain.RawVO;
import com.chamjik.dbserver.mapper.RawMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RawService {

    private final RawMapper rawMapper;

    @Transactional
    public List<RawVO> findAll() throws Exception {
        return rawMapper.findAll();
    }

    @Transactional
    public List<RawVO> findByAuthor(String author) throws Exception {
        return rawMapper.findByAuthor(author);
    }

    @Transactional
    public void insertRaw(List<RawVO> raws) throws Exception {
        rawMapper.insertRaw(raws);
    }

    @Transactional
    public void deleteRaw(List<RawVO> raws) throws Exception {
        rawMapper.deleteRaw(raws);
    }

    @Transactional
    public void deleteUser(String author) throws Exception {
        rawMapper.deleteAuthor(author);
    }
}
