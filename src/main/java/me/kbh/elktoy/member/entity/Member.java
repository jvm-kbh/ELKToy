package me.kbh.elktoy.member.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@Document(indexName = "member")
@ToString
@EqualsAndHashCode
public class Member {

  @Id
  @Field(type = FieldType.Keyword)
  long id;

  @Field(type = FieldType.Text)
  String name;

  @Field(type = FieldType.Text)
  String city;

  @Field(type = FieldType.Text)
  String phoneNumber;
}
