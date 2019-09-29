app.config(function ($routeProvider) {
    $routeProvider.when("/page_one/:e_no/:e_name/:e_sal",{
        templateUrl:"templates/page_one.html",
        controller:"page_one"
    })
        .when("/page_two/:e_no/:e_name/:e_sal",{
            templateUrl:"templates/page_two.html",
            controller:"page_two"
        })
        .otherwise("/page_one",{
            templateUrl:"templates/page_one.html",
            controller:"page_one"
        });
});