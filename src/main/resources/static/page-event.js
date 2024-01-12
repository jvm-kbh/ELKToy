var pageEvent = (function () {
  var _pageSize = 10;
  var _pageElement = 5;
  var _currentPage = 1;
  var _pagenator;
  var _init = function () {
    $("#spinner-div").show();
    $.ajax({
      type: "GET",
      url: "/commercial-property/count",
      dataType: "json",
      success: function (response) {
        $("#count").val(response);
        _initSimplePaginator(response);
      },
      complete: function () {
        $("#spinner-div").hide();
      }
    });
  }, _initSimplePaginator = function (count) {
    _pagenator = $('#pagination').simplePaginator({
      totalPages: (count / (_pageSize * _pageSize)) - (_pageSize - 1),
      maxButtonsVisible: _pageElement,
      currentPage: _currentPage,
      nextLabel: '>',
      prevLabel: '<',
      firstLabel: '<<',
      lastLabel: '>>',
      clickCurrentPage: true,

      pageChange: function (page) {
        var conditon = _getCondtionByElement(page);

        var searchName = conditon.searchName;
        var lat = conditon.lat;
        var lot = conditon.lot;
        var categoryType = conditon.categoryType;
        var categoryCode = conditon.categoryCode;

        var isCondtionEmtpy = _isCondtionEmpty();

        if (isCondtionEmtpy) {
          _defaultSearch(page)
        } else {
          _searchNextPage(page)
        }
      }
    });
  }, _initAggregation = function () {
    $.ajax({
      type: "GET",
      url: "/commercial-property/aggregation-list",
      success: function (data) {
        resultEvent.generateAggregation(data);
      }
    });
  }, _searchNextPage = function (page) {
    var condition = _getCondtionByElement(page);

    $.ajax({
      type: "GET",
      url: "/commercial-property/condition",
      data: {
        searchName: condition.searchName,
        lat: condition.lat,
        lot: condition.lot,
        categoryType: condition.categoryType,
        categoryCode: condition.categoryCode,
        from: condition.from
      },
      success: function (data) {
        resultEvent.clearPage();
        resultEvent.generate(data.commercialPropertyDtoList);
      }
    });
  }, _searchByCondition = function (page) {
    var condition = _getCondtionByElement(page);

    $.ajax({
      type: "GET",
      url: "/commercial-property/condition",
      data: {
        searchName: condition.searchName,
        lat: condition.lat,
        lot: condition.lot,
        categoryType: condition.categoryType,
        categoryCode: condition.categoryCode,
        from: condition.from
      },
      success: function (data) {
        resultEvent.clearPage();
        resultEvent.generate(data.commercialPropertyDtoList);
        _initPagenationByCondition(data.count);
      }
    });
  }, _defaultSearch = function (page) {
    $.ajax({
      type: "GET",
      url: "/commercial-property/all/" + page,
      success: function (data) {
        resultEvent.clearPage();
        resultEvent.generate(data.commercialPropertyDtoList);
      }
    });
  }, _initPagenationByCondition = function (count) {
    _pagenator.simplePaginator('setTotalPages', Math.floor(count/_pageSize));

    var currentPage = 0;
    var firstJQueryProperty = $.each(_pagenator[0], function(attrName, attrValue){
      if (attrName.startsWith("jQuery")) {
        currentPage = attrValue.plugin_simplePaginator.options.currentPage;
      }
    });

    _pagenator.simplePaginator('changePage',1);
  }, _getCondtionByElement = function (page) {
    var searchName = $("#search-input").val();
    var lat = mapEvent.getMakerLat();
    var lot = mapEvent.getMakerLot();
    var categoryType = storeTypeEvent.getCategoryType();
    var categoryCode = storeTypeEvent.getCategoryCode();
    var from = page;

    if (typeof page !== "number") {
      from = 1;
    }

    var condition = {
      searchName: searchName,
      lat: lat,
      lot: lot,
      categoryType: categoryType,
      categoryCode: categoryCode,
      from: from
    }

    return condition;
  }, _isCondtionEmpty = function () {
    var conditon = _getCondtionByElement();

    var searchName = conditon.searchName;
    var lat = conditon.lat;
    var lot = conditon.lot;
    var categoryType = conditon.categoryType;
    var categoryCode = conditon.categoryCode;

    var isSearchNameEmtpy = searchName == '';
    var isZeroLat = lat == 0;
    var isZeroLot = lot == 0;
    var isCategoryTypeEmpty = categoryType == '';
    var isCategoryCodeEmpty = categoryCode == '';

    return isSearchNameEmtpy
        && isZeroLat && isZeroLot
        && isCategoryTypeEmpty && isCategoryCodeEmpty;
  }
  return {
    init: _init,
    initAggregation: _initAggregation,
    searchByCondition: _searchByCondition
  }
})();