var mapEvent = (function () {
  var markers = [];
  var _makerLat = 0;
  var _makerLot = 0;
  var _init = function () {
    markers = [];
    _getCurrentLocation();
  }, _getCurrentLocation = function (successCallback, errorCallback) {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
          function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            _successCallback(latitude, longitude);
          },
          function (error) {
            _errorCallback(error);
          }
      );
    } else {
      errorCallback(new Error("Geolocation is not supported by this browser."));
    }
  }, _successCallback = function (latitude, longitude) {
    var mapContainer = document.getElementById('map'),
        mapOption = {
          center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
          level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
      var latlng = mouseEvent.latLng;

      _setMakerPoint(latlng.getLat(), latlng.getLng());

      var markerPosition = new kakao.maps.LatLng(latlng.getLat(),
          latlng.getLng());

      var marker = new kakao.maps.Marker({
        position: markerPosition
      });

      for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
      }

      marker.setMap(map);
      markers.push(marker);

      pageEvent.searchByCondition();
    });
  }, _errorCallback = function () {
    console.error("Error getting location:", error.message);
  }, _setMakerPoint = function (lat, lot) {
    _makerLat = lat;
    _makerLot = lot;
  }, _getMakerLat = function () {
    return _makerLat;
  }, _getMakerLot = function () {
    return _makerLot;
  }

  return {
    init: _init,
    setMakerPoint: _setMakerPoint,
    getMakerLat: _getMakerLat,
    getMakerLot: _getMakerLot
  }
})();