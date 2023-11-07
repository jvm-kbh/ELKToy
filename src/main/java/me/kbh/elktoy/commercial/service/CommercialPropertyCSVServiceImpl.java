package me.kbh.elktoy.commercial.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.model.CommercialProperty;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyCSVServiceImpl implements CommercialPropertyCSVService {
  @Override
  public void createDummyData() {
    try (Reader reader = new BufferedReader(new FileReader("./csv/small/test.csv"))) {
      Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
      List<CommercialProperty> commercialPropertyList =
          StreamSupport.stream(records.spliterator(), false).map(CommercialProperty::new).toList();


    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
