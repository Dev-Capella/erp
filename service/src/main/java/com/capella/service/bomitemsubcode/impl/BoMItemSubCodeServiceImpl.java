package com.capella.service.bomitemsubcode.impl;

import com.capella.domain.model.bomitemsubcode.BoMItemSubCodeModel;
import com.capella.persistence.dao.bomitemsubcode.BoMItemSubCodeDao;
import com.capella.service.bomitemsubcode.BoMItemSubCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BoMItemSubCodeServiceImpl implements BoMItemSubCodeService {

    private final BoMItemSubCodeDao bomItemSubCodeDao;
    @Override
    public BoMItemSubCodeModel getBoMItemSubCodeModel(String code) {
        var bomItemSubCodeModel = bomItemSubCodeDao.getByCode(code);
        return bomItemSubCodeModel;
    }
}
