app.controller("page_one",function ($scope,$stateParams) {
    $scope.var_one = $stateParams.e_id+"...."+$stateParams.e_name+"...."+$stateParams.e_sal;
});