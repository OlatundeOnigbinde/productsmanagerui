$(function () {
    let dataTable;
    let $submitBtn = $('#submit');

        $("#data-search-form").submit(function(event) {
            $submitBtn.hide();
            if ( $.fn.dataTable.isDataTable( '#reportDataTable' )) {
                dataTable.destroy();
            }
        // Stop form from submitting normally
        event.preventDefault();
        // Get some values from elements on the page:
        let $form = $(this);

        let category = $('#category').val();

        // Send the data using get
        let url = 'getallproducts';
        if(category !== ''){
            url= '/getproducts/'+category;
        }
        $.ajax(url, {
            type: 'GET',
            contentType: 'application/json',
            processData: false
        }).done(function(data) {
            if(data === null || data.productsList.length === 0){
                alert('No records found');
                location.href ='/products';
            }else{
                // var dataSet = JSON.stringify(data);
                // alert(dataSet);
                dataTable = $('#reportDataTable').DataTable( {
                    "iDisplayLength": 5,
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                    dom: 'Blfrtip',
                    data: data.productsList,
                    "aoColumns": [
                        {"data": null},
                        {"data": "name"},
                        {"data": "description"},
                        {"data": "category.name"},
                        {"data": "creationDate"},
                        {"data": "updateDate"},
                        {"data": "lastPurchasedDate"},
                        {
                            "data": null,
                            "render": function (data, type, row) {
                                let deletelink = '/deleteProduct/' + row.id;
                                let editlink = '/editproduct?ref=' + row.id;
                                return '<button class="btn btn-sm btn-primary delete-btn ml-1" data-action="'+deletelink+'" title="delete">delete</button> '+' <span class="text-center font-weight-bold"><a href="' + editlink + '" title="Edit">edit</a></span>';
                            }
                        }
                        ],
                    "columnDefs": [
                        {
                            "searchable": false,
                            "orderable": false,
                            "targets": 0
                        }],
                    buttons: [
                        {
                            text: "csv",
                            extend: 'csvHtml5',
                            exportOptions: {
                                columns: [1, 2, 3, 4, 5, 6]
                            }
                        },
                        {
                            text: "excel",
                            extend: 'excelHtml5',
                            exportOptions: {
                                columns: [1, 2, 3, 4, 5, 6]
                            }
                        },{
                            text: "pdf",
                            extend: 'pdfHtml5',
                            exportOptions: {
                                columns: [1, 2, 3, 4, 5, 6]
                            }
                        }
                    ]
                } );
                dataTable.on('order.dt search.dt', function () {
                    dataTable.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
                        cell.innerHTML = i + 1;
                    });
                }).draw();
                $submitBtn.show();
            }
        });

    });

     function deleteProduct(actionURL){
        if(!confirm('Are you sure you want to delete, click OK to continue')){
            return;
        }
        $.ajax(actionURL, {
            type: 'GET',
            contentType: 'application/json',
            processData: false
        }).done(function(data) {
             if(data !== 'success'){
                alert('Process failed');
            }else{
                alert('process was successful');
                location.href ='/products';
            }
        });
    }
    $('#reportDataTable').on('click', '.delete-btn', function(e) {
        let actionURL = $(this).attr('data-action');
        deleteProduct(actionURL);
    });


    $("#flag").change(function(event) {
        if ( $.fn.dataTable.isDataTable( '#reportDataTable' )) {
            $('#reportDataTable').DataTable().clear().draw();
        }
    });

    $.ajax('/getcategories', {
        type: 'GET',
        contentType: 'application/json',
        processData: false
    }).done(function(data) {
        if(data.categoryList === null || data.categoryList === ''){
            alert(data.message);
        }else{
            let $select = $('#category');
            let selectedCategory = $('#selectedCategory').val();
            $.each(data.categoryList, function(i, option) {
                let optionText = option.name;
                let optionValue = option.id;
                $select.append(`<option value="${optionValue}"> ${optionText} </option>`);
            });$select.val(selectedCategory);
        }
    });

    $("#portal-product-manage-form").submit(function(event) {
        // Stop form from submitting normally
        event.preventDefault();
        // Get some values from elements on the page:
        let $form = $(this);
        let productId = $form.find("input[id='productId']").val();
        let productName = $form.find("input[id='productname']").val();
        let desc = $form.find("input[id='description']").val();
        let categoryId = $('#category').val();
        let lastPurchasedDateStr = $('#lastPurchasedDate').val();
        // Send the data using post
        $.ajax('/saveproduct', {
            type: 'POST',
            data: JSON.stringify({productId: productId,productName: productName, description:desc,categoryId:categoryId,lastPurchasedDateStr:lastPurchasedDateStr}),
            contentType: 'application/json',
            processData: false
        }).done(function(data) {
            if(data.code === 0){
                alert(data.message);
                location.href ='/products';
            }else if(data.code === 1){
                alert(data.message);
            }else{
                alert('Process failed, pls try again later');
            }
        });
    });
    $('.datepick').datepicker({
        autoclose: true
    });
     $(".select2").select2();

});