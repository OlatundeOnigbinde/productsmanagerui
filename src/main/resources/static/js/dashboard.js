$(function () {
    const $productsCountContainer = $('#productsCount');
    const $categoriesCountContainer = $('#categoriesCount');

    //get Products pending review count
    $.ajax('/getproductscount', {
        type: 'GET',
        //contentType: 'application/json',
        processData: false
    }).done(function(data) {
        $productsCountContainer.html(numberWithCommas(data.value));
    });

    //get Categories pending review count
    $.ajax('/getcategoriescount', {
        type: 'GET',
        //contentType: 'application/json',
        processData: false
    }).done(function(data) {
        $categoriesCountContainer.html(numberWithCommas(data.value));
    });

    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
});