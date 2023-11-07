var resultEvent = (function () {
  var _generate = function(data){
    var template = $('#commercial-property-template').html();

    template = template.split("{%name%}").join("data.name");
    template = template.split("{%branchName%}").join("data.branchName");
    template = template.split("{%majorCategoryName%}").join("data.majorCategoryName");
    template = template.split("{%middleCategoryName%}").join("data.middleCategoryName");
    template = template.split("{%subCategoryName%}").join("data.subCategoryName");
    template = template.split("{%industryName%}").join("data.industryName");
    template = template.split("{%cityName%}").join("data.cityName");
    template = template.split("{%districtName%}").join("data.districtName");
    template = template.split("{%administrativeDistrictName%}").join("data.administrativeDistrictName");
    template = template.split("{%legalDistrictName%}").join("data.legalDistrictName");
    template = template.split("{%landCategoryName%}").join("data.landCategoryName");
    template = template.split("{%parcelCode%}").join("data.parcelCode");
    template = template.split("{%parcelAddress%}").join("data.parcelAddress");
    template = template.split("{%parcelMainNumber%}").join("data.parcelMainNumber");
    template = template.split("{%parcelSubNumber%}").join("data.parcelSubNumber");
    template = template.split("{%roadCode%}").join("data.roadCode");
    template = template.split("{%roadName%}").join("data.roadName");
    template = template.split("{%roadAddress%}").join("data.roadAddress");
    template = template.split("{%buildingMainNumber%}").join("data.buildingMainNumber");
    template = template.split("{%buildingSubNumber%}").join("data.buildingSubNumber");
    template = template.split("{%buildingManagementNumber%}").join("data.buildingManagementNumber");
    template = template.split("{%buildingName%}").join("data.buildingName");
    template = template.split("{%oldZipCode%}").join("data.oldZipCode");
    template = template.split("{%newZipCode%}").join("data.newZipCode");
    template = template.split("{%dongInfo%}").join("data.dongInfo");
    template = template.split("{%floorInfo%}").join("data.floorInfo");
    template = template.split("{%unitInfo%}").join("data.unitInfo");
    template = template.split("{%longitude%}").join("data.longitude");
    template = template.split("{%latitude%}").join("data.latitude");

    $("#data-component").append(template);
  }
  return {
    generate : _generate
  }
})();