# argument
ARG ELK_VERSION

# Elasticsearch Dockerfile
FROM docker.elastic.co/elasticsearch/elasticsearch:${ELK_VERSION}

# 플러그인 설치를 위한 스크립트 추가
RUN elasticsearch-plugin install analysis-nori