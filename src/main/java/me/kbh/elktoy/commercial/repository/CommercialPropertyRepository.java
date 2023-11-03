package me.kbh.elktoy.commercial.repository;

import me.kbh.elktoy.commercial.model.CommercialProperty;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommercialPropertyRepository
    extends ElasticsearchRepository<CommercialProperty, Long> {}
