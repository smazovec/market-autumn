angular.module('app', []).controller('indexController',
    function ($scope, $http) {
      const contextPath = 'http://localhost:8082/app/api/v1';

      $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
        .then(function (response) {
          $scope.productList = response.data;
        });
      };

      $scope.createProductJson = function () {
        $http.post(contextPath + '/product/create', $scope.newProductJson)
        .then(function (response) {
          $scope.loadProducts();
        });
      }

      $scope.deleteProduct = function (productId) {
        $http({
          url: contextPath + '/product/delete',
          method: 'DELETE',
          params: {
            productId: productId
          }
        }).then(function (response) {
          $scope.loadProducts();
        });
      };

      $scope.loadProducts();

    });