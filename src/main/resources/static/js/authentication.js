$(function () {
    $("#login-form").submit(function(event) {
        // Stop form from submitting normally
        event.preventDefault();
        // Get some values from elements on the page:
        let $form = $(this);
        let username = $form.find("input[name='username']").val();
        let password = $form.find("input[name='password']").val();
        // Send the data using post

        $.ajax('/login', {
            type: 'POST',
            data: JSON.stringify({email: username, password:password}),
            contentType: 'application/json',
            processData: false
        }).done(function(resp) {
            if(resp === 'success'){
                location.href ='/welcome';
            }else{
                alert(resp);
            }
        });
    });
});
