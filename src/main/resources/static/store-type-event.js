var storeTypeEvent = (function () {
  var categoryType = "";
  var categoryCode = "";
  var _selectOnlyOneType = function () {
    var selectedAggregationTypeRadio =
        $("input[name='aggregation-radio']:checked")
        .closest('div')
        .find('label');

    categoryType = selectedAggregationTypeRadio.find(
        'input[name="category-type"]').val();

    categoryCode = selectedAggregationTypeRadio.find(
        'input[name="category-code"]').val();

    pageEvent.searchByCondition();

  }, _getCategoryType = function () {
    return categoryType;
  }, _getCategoryCode = function () {
    return categoryCode;
  }
  return {
    selectOnlyOne: _selectOnlyOneType,
    getCategoryType: _getCategoryType,
    getCategoryCode: _getCategoryCode
  }
})();