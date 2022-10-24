angular.module('app', []).controller('indexController',
    function ($scope, $http) {
      const contextPath = 'http://localhost:8082/app';

      $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
        .then(function (response) {
          $scope.productList = response.data;
        });
      };

      $scope.deleteProduct = function (productId) {
        $http({
          url: contextPath + '/product/delete',
          method: 'GET',
          params: {
            productId: productId
          }
        }).then(function (response) {
          $scope.loadProducts();
        });
      };

      $scope.loadProducts();

    });