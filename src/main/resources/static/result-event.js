var resultEvent = (function () {
  var _generate = function (dataList) {
    $.each(dataList, function (index, item) {
      var template = $('#commercial-property-template').html();

      template = template.split("{%name%}").join(item.name);
      template = template.split("{%branchName%}").join(item.branchName);
      template = template.split("{%majorCategoryName%}").join(
          item.majorCategoryName);
      template = template.split("{%middleCategoryName%}").join(
          item.middleCategoryName);
      template = template.split("{%subCategoryName%}").join(
          item.subCategoryName);
      template = template.split("{%industryName%}").join(item.industryName);
      template = template.split("{%cityName%}").join(item.cityName);
      template = template.split("{%districtName%}").join(item.districtName);
      template = template.split("{%administrativeDistrictName%}").join(
          item.administrativeDistrictName);
      template = template.split("{%legalDistrictName%}").join(
          item.legalDistrictName);
      template = template.split("{%landCategoryName%}").join(
          item.landCategoryName);
      template = template.split("{%parcelCode%}").join(item.parcelCode);
      template = template.split("{%parcelAddress%}").join(item.parcelAddress);
      template = template.split("{%parcelMainNumber%}").join(
          item.parcelMainNumber);
      template = template.split("{%parcelSubNumber%}").join(
          item.parcelSubNumber);
      template = template.split("{%roadCode%}").join(item.roadCode);
      template = template.split("{%roadAddress%}").join(item.roadAddress);
      template = template.split("{%buildingMainNumber%}").join(
          item.buildingMainNumber);
      template = template.split("{%buildingSubNumber%}").join(
          item.buildingSubNumber);
      template = template.split("{%buildingManagementNumber%}").join(
          item.buildingManagementNumber);
      template = template.split("{%buildingName%}").join(item.buildingName);
      template = template.split("{%oldZipCode%}").join(item.oldZipCode);
      template = template.split("{%newZipCode%}").join(item.newZipCode);
      template = template.split("{%dongInfo%}").join(item.dongInfo);
      template = template.split("{%floorInfo%}").join(item.floorInfo);
      template = template.split("{%unitInfo%}").join(item.unitInfo);
      template = template.split("{%longitude%}").join(item.longitude);
      template = template.split("{%latitude%}").join(item.latitude);

      $("#data-component").append(template);
    });
  }, _clearPage = function () {
    $("#data-component").empty();
  }, _generateAggregation = function (data) {
    function findDataByAggregationTitle(aggregationTitle) {
      var foundData = null;
      $.each(data.commercialPropertyAggregationList, function (index, data) {
        if (data.aggregationTitle === aggregationTitle) {
          foundData = data;
          return false; // 반복 중단
        }
      });
      return foundData;
    }

    var majorData = findDataByAggregationTitle("major");
    var middleData = findDataByAggregationTitle("middle");
    var subData = findDataByAggregationTitle("sub");

    function generateRadioHtml(aggregationTitle, aggregationDataMap) {
      var radioHtml = '';
      var index = 0;
      $.each(aggregationDataMap, function (index, data) {
        var radioTemplate = $('#radio-template-for-aggregation').html();
        radioTemplate = radioTemplate.split("{%category%}").join(aggregationTitle);
        radioTemplate = radioTemplate.split("{%index%}").join(index++);
        radioTemplate = radioTemplate.split("{%aggregationName%}").join(data.key.replace('"','').replace('"',''));
        radioTemplate = radioTemplate.split("{%aggregationCount%}").join(data.count);
        radioTemplate = radioTemplate.split("{%aggregationCode%}").join(data.code.replace('"','').replace('"',''));
        radioHtml += radioTemplate;
      });
      return radioHtml;
    }

    var majorHtml = generateRadioHtml(majorData.aggregationTitle, majorData.aggregationDataMap);
    var middleHtml = generateRadioHtml(middleData.aggregationTitle, middleData.aggregationDataMap);
    var subHtml = generateRadioHtml(subData.aggregationTitle, subData.aggregationDataMap);

    $(".major-check-group").append(majorHtml);
    $(".middle-check-group").append(middleHtml);
    $(".sub-check-group").append(subHtml);

    $(".condition-wrapper input[type=radio]").on("change",function (){
      var categoryType = $(this).closest('div').find('input[name=category-type]').val();
      var categoryCode = $(this).closest('div').find('input[name=category-code]').val();

    });
  }
  return {
    clearPage: _clearPage,
    generate: _generate,
    generateAggregation: _generateAggregation
  }
})();