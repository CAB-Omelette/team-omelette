"use strict";

//login modal//
function showModal() {
    $('#login-modal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
    });


$('#chef-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
});

$('#rest-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
});


// $('#login-modal').modal({
//     backdrop: 'static',
//     keyboard: false
// });
//
}

//chef sign up modal//
$('#chef-sign-up-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var recipient = button.data('whatever'); // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
    modal.find('.modal-body input').val(recipient)
});

// $('#login-modal').on('submit', function(e) {
//     var username = $('#username');
//     var password = $('#password');
//
//     // Check if there is an entered value
//     if(username === null || password === null ) {
//         // Add errors highlight
//         username.closest('.form-group').removeClass('has-success').addClass('has-error');
//         password.closest('.form-group').removeClass('has-success').addClass('has-error');
//         // Stop submission of the form
//         e.preventDefault();
//     } else {
//
//         username.closest('.form-group').removeClass('has-error').addClass('has-success');
//         password.closest('.form-group').removeClass('has-error').addClass('has-success');
//     }
// });

// $('#myModal').modal({
//     backdrop: 'static',
//     keyboard: true
// })

// https://www.smashingmagazine.com/2014/09/making-modal-windows-better-for-everyone/
// https://www.w3schools.com/bootstrap/bootstrap_ref_js_modal.asp
// https://github.com/kylefox/jquery-modal
// https://jqueryui.com/dialog/
// http://jquerymodal.com/

// $("#custom-close").modal({
//     closeClass: 'icon-remove',
//     closeText: '!'
// });

// http://i-like-robots.github.io/jQuery-Modal/
// https://www.sitepoint.com/14-jquery-modal-dialog-boxes/
// http://www.jacklmoore.com/notes/jquery-modal-tutorial/


