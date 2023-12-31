package com.capella.facade.bomitemsubcode;
import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;

public interface BoMItemSubCodeFacade {
    void save(BoMItemSubCodeData bomItemSubCodeData);
    void delete(String code);
    BoMItemSubCodeData get(String code);
}
