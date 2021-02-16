
(function($){
	"use strict";
	
	
	/*---------------Location page-------------*/
	$('.add-btn').on('click', function(){
			var w = window.open('/SpringFitnessProject/region/addLocation.em', 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
	    	w.onload = function() { this.document.title = "Add Location"; }
	})
    
    $('.edit-btn').on('click', function(){
    	var location = $(this).attr('id');
    	var w = window.open('/SpringFitnessProject/region/editLocation.em?location='+location, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Edit Location"; }
    })
    
    $('.location-box').on('click', function(){
    	var location = $(this).attr('id');
    	window.location="/SpringFitnessProject/clubs/clubs.em?location="+location;
    })
    
    $('.delete-btn').on('click', function(){
    	var location = $(this).attr('id');
    	var w = window.open('/SpringFitnessProject/region/deleteLocationPro.em?location='+location, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Delete Location"; }
    })

	
	
	
})(jQuery)







