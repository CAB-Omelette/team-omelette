"use strict";

//login modal//
    $('#login-modal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
    });

$('#chef-sign-up-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var recipient = button.data('whatever'); // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
    modal.find('.modal-body input').val(recipient)
});


// $('#login-modal').modal({
//     show: 'false',
//     keyboard: true
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