

(function ($) {
    "use strict";
    
    /*-----------Club page------------*/
    $('.club-edit-btn').on('click', function(){
    	var name = $(this).attr('id');
    	var w = window.open('/SpringFitnessProject/clubs/editClub.em?name='+name, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Edit Club"; }
    })
    
    $('.club-add-btn').on('click', function(){
    	var location = $(this).attr('id');
    	var w = window.open('/SpringFitnessProject/clubs/addClub.em?location='+location, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Add Club"; }
    })
    
    $('.club-delete-btn').on('click', function(){
    	var name = $(this).attr('id');
    	var w = window.open('/SpringFitnessProject/clubs/deleteClub.em?name='+name, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Delete Club"; }
    })
    
    $('.club-box').on('click', function(){
    	var club_name = $(this).attr('id');
    	window.location="/SpringFitnessProject/classes/classModal.em?club_name="+club_name;
    })
    

})(jQuery);





