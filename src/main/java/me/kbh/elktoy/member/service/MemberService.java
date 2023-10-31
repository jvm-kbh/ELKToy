package me.kbh.elktoy.member.service;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import me.kbh.elktoy.member.entity.Member;
import me.kbh.elktoy.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MemberService {

  MemberRepository memberRepository;

  public void createUserByFakerLimit100() {
    Faker faker = new Faker(new Locale("ko"));

    List<Member> memberList =
        Stream.iterate(1, i -> i + 1)
            .limit(100)
            .map(
                i ->
                    Member.builder()
                        .id(i)
                        .name(faker.name().fullName())
                        .city(faker.address().city())
                        .phoneNumber(faker.phoneNumber().cellPhone())
                        .build())
            .collect(Collectors.toList());

    memberRepository.saveAll(memberList);
  }

  public void findAll() {
    List<Member> memberList = StreamSupport.stream(memberRepository.findAll().spliterator(),false)
        .collect(Collectors.toList());

    memberList.forEach(member -> log.info(member.toString()));
  }
}
