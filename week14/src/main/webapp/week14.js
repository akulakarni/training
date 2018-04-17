var app = angular.module('myModule', []);

app.controller('MainController', function($scope, $http) {
  $scope.userDetails = {};
  $scope.userDetail = [];
  $scope.radioButtonValue;

  $http({
    method: "GET",
    url: "http://localhost:9090/week14/rest/getUsers/",
    params: {}
  }).then(function success(response) {
    $scope.userDetail = response.data;
    $scope.statuscode = response.status;
  }, function myError(response) {
    $scope.myRes = response.statusText
  });
  $scope.getRadioButtonIndex = function(radioButtonValue) {
    $scope.userDetails = $scope.userDetail[$scope.radioButtonValue];
  }
  $scope.addUser = function() {
    $scope.userDetail.push($scope.userDetails);
    //$scope.userDetails = {};
  }

  $scope.addToDb = function() {
    $http({
        method: 'POST',
        url: 'http://localhost:9090/week14/rest/addUser',
        data: $scope.userDetails
      })
      .then(function mySuccess(response) {
      }, function myError(response) {

      });
    $scope.userDetails = {};
  }

  $scope.AddTable = false;
  $scope.Add = function() {
    $scope.AddTable = !$scope.AddTable;
  }

  $scope.EditTable = false;
  $scope.Edit = function() {
    $scope.EditTable = !$scope.EditTable;
  }

  $scope.editUser = function() {
    $http({
        method: 'POST',
        url: 'http://localhost:9090/week14/rest/editUser',
        data: $scope.userDetails
      })
      .then(function mySuccess(response) {


      }, function myError(response) {

      });
    $scope.userDetail[$scope.radioButtonValue] = $scope.userDetails
    $scope.userDetails = {};
  }

  $scope.delete = function() {
    $http({
        method: 'POST',
        url: 'http://localhost:9090/week14/rest/deleteUser',
         data: $scope.userDetails
      })
      .then(function mySuccess(response) {

      }, function myError(response) {

      });
    $scope.userDetail.splice($scope.radioButtonValue, 1);
    $scope.userDetails = {};
    $scope.radioButtonValue=null;
  }
});