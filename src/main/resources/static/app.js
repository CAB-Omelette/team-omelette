"use strict";

    $('#login-modal').on('show.bs.modal', function (event) {
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
//
// var lastFocus;
//
// function modalShow () {
//     lastFocus = document.activeElement;
// }
//
// function modalClose () {
//     lastFocus.focus(); // place focus on the saved element
// }


// var modal = document.getElementById('your-modal-id-here');
//
// function modalShow () {
//     modal.setAttribute('tabindex', '0');
//     modal.focus();
// }


// function modalClose ( e ) {
//     if ( !e.keyCode || e.keyCode === 27 ) {
//         // code to close modal goes here
//     }
// }
//
// document.addEventListener('keydown', modalClose);


// mOverlay.addEventListener('click', function( e )
// if (e.target == modal.parentNode)
//     modalClose( e );
// }
// }, false);

// https://www.smashingmagazine.com/2014/09/making-modal-windows-better-for-everyone/

// https://www.w3schools.com/bootstrap/bootstrap_ref_js_modal.asp

// https://github.com/kylefox/jquery-modal

// https://jqueryui.com/dialog/

// http://jquerymodal.com/

// $("#custom-close").modal({
//     closeClass: 'icon-remove',
//     closeText: '!'
// });

// $('#myModal').modal({
//     backdrop: 'static',
//     keyboard: true
// })

// http://i-like-robots.github.io/jQuery-Modal/

// https://www.sitepoint.com/14-jquery-modal-dialog-boxes/

// http://www.jacklmoore.com/notes/jquery-modal-tutorial/