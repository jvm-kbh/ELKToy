package me.kbh.elktoy.member.repository;

import me.kbh.elktoy.member.entity.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MemberRepository extends ElasticsearchRepository<Member, Long> {

}
