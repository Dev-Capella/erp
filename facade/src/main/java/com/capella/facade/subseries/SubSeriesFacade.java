package com.capella.facade.subseries;

import com.capella.domain.data.subseries.SubSeriesData;

public interface SubSeriesFacade {
    void save(SubSeriesData subSeriesData);
    void delete(String code);
    SubSeriesData get(String code);
}
