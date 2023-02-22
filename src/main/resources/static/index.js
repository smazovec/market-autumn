angular.module('app', ['ngStorage']).controller('indexController',
    function ($scope, $rootScope, $http, $localStorage) {

      if ($localStorage.springWebUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
      }

      const contextPath = 'http://localhost:8082/app/api/v1';

      $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
        .then(function (response) {
          $scope.productList = response.data;
        });
      };

      $scope.loadUsers = function () {
        $http.get(contextPath + '/user/all')
        .then(function (response) {
          $scope.userList = response.data;
        });
      };

      $scope.loadBasket = function () {
        $http.get(contextPath + '/basket/getBasket')
        .then(function (response) {
          $scope.basket = response.data;
        });
      };

      $scope.inBasketJson = function (product) {
        console.log(product);
        $http.post(contextPath + '/basket/inBasket', product)
        .then(function (response) {
          $scope.loadBasket();
        });
      }

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

      $scope.tryToAuth = function () {
        $http.post('http://localhost:8082/app/auth', $scope.user)
        .then(function successCallback(response) {
          if (response.data.token) {
            $http.defaults.headers.common.Authorization = 'Bearer '
                + response.data.token;
            $localStorage.springWebUser = {
              username: $scope.user.username,
              token: response.data.token

            };
            $scope.loadProducts();
            $scope.user.username = null;
            $scope.user.password = null;
          }
        }, function errorCallback(response) {

        });
      };

      $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user && $scope.user.username) {
          $scope.user.username = null;
        }
        if ($scope.user && $scope.user.password) {
          $scope.user.password = null;
        }
      };

      $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
      };

      $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
          return true;
        } else {
          return false;
        }
      };

      $scope.loadProducts();
      $scope.loadUsers();
      $scope.loadBasket();

    });