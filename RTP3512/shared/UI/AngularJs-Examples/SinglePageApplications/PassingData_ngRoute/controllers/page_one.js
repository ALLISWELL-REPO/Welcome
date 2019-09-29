app.controller("page_one",function ($scope,$routeParams) {
    $scope.var_one = $routeParams.e_no+"...."+$routeParams.e_name+"..."+$routeParams.e_sal;
});