# ELKToy

## 개요
* 소상공인시장진흥공단에서 제공하는 공공데이터인 서울 상가 정보를 활용하여 ELK 스택을 활용한 프로젝트

## 프로젝트 구조
* 업데이트 예정

## Setting

* 기초적인 테스트를 위해 1000개 정도의 데이터를 프로젝트 루트 경로 내 csv 디렉토리에서 제공합니다.
  * ![small_test_data.png](src%2Fmain%2Fresources%2Freadme%2Fsmall_test_data.png)
* 더 많은 데이터를 활용하여 진행해보기
    * http://naver.me/G1swn8Ui (전체 데이터 파일, 분할 파일로 구성)


## Quick Start

### Spring Boot
```
./gradlew clean build -x test -x testClasses bootRun
```

### docker-compose
```bash
  $ docker-compose up --build -d
```

## Project Practice List
* Case 1
  * docker-compose.yml E,K config
  * spring data elasticsearch test
    * @Field
      * Elasticsearch Insert, search 구성
    * @Mapping
        * json file mapping
        * Elasticsearch Insert, search 구성  
* Case 2
  * with out spring data elasticsearch
  * Sample Search Page (thymeleaf)
  * 공공기관 실제 데이터 활용