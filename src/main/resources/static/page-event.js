var pageEvent = (function () {
  var _pageSize = 10;
  var _pageElement = 5;
  var _currentPage = 1;
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
    $('#pagination').simplePaginator({
      totalPages: (count / (_pageSize * _pageSize)) - (_pageSize - 1),
      maxButtonsVisible: _pageElement,
      currentPage: _currentPage,
      nextLabel: '>',
      prevLabel: '<',
      firstLabel: '<<',
      lastLabel: '>>',
      clickCurrentPage: true,

      pageChange: function (page) {
        $.ajax({
          type: "GET",
          url: "/commercial-property/all/" + page,
          success: function(data) {
            resultEvent.clearPage();
            resultEvent.generate(data.commercialPropertyDtoList);
          }
        });
      }

    });
  }, _initAggregation = function () {
    $.ajax({
      type: "GET",
      url: "commercial-property/aggregation-list",
      success: function(data) {
        resultEvent.generateAggregation(data);
      }
    });
  }
  return {
    init: _init,
    initAggregation: _initAggregation
  }
})();