package me.kbh.elktoy.commercial.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.repository.CommercialPropertyRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyServiceImpl implements CommercialPropertyService {

  CommercialPropertyRepository commercialPropertyRepository;
  ElasticsearchClient elasticsearchClient;
  ElasticsearchOperations operations;

  @Override
  public void createDummyData() {
    System.out.println("asdf");
//    try (Reader reader = new BufferedReader(new FileReader("./csv/small/test.csv"))) {
//      Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
//      List<CommercialProperty> commercialPropertyList =
//          StreamSupport.stream(records.spliterator(), false).map(CommercialProperty::new).toList();
//
//      commercialPropertyRepository.saveAll(commercialPropertyList);
//
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
  }
}
