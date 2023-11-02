package me.kbh.elktoy.member.repository;

import me.kbh.elktoy.member.entity.CommercialProperty;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommercialPropertyRepository
    extends ElasticsearchRepository<CommercialProperty, Long> {}
