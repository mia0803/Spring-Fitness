(function($){
	
	
	/*------------member board----------*/
	
	$(window).on('load', function(){
		var selected_menu = $('body').attr('id');
		$('.side-bar > p#'+ selected_menu).addClass("selected-page");
	})
	
	$('.side-bar > p#main').on('click', function(){
    	window.location="/SpringFitnessProject/memberPage/memberBoard.em";
    })
    
    $('.side-bar > p#my-info').on('click', function(){
    	window.location="/SpringFitnessProject/memberPage/editMember.em";
    })
    
    $('.side-bar > p#payment-info').on('click', function(){
    	window.location="/SpringFitnessProject/memberPage/editPaymentInfo.em";
    })
    
    $('.side-bar > p#time-table').on('click', function(){
    	window.location="/SpringFitnessProject/memberPage/timetable.em";
    })
    
    
    $('.deactivate').on('click', function(){
    	var id = $(this).attr('id');
    	console.log(id);
    	var w = window.open("/SpringFitnessProject/memberPage/deactivateMePro.em?id="+id, 'toolbar=no, location=no, status=no, menubar=no, add_location', 'scrollbars=yes, resizable=yes, width=700, height=500');
    	w.onload = function() { this.document.title = "Close Account"; }
    })
	
	$('.change-membership-btn').on('click', function(){
		var id = $(this).attr('id');
		window.location="/SpringFitnessProject/registration/registration1.em?changeMembership=1";
	})
    
	
	/*--------------timetable page------------*/
	
	 $(window).on('load', function(){
		var today = $('.head-days').attr('id');
		showText(today);
	})
	
	$('.class-btn').on('click', function(){
    	var that_day = $(this).data('showingbutton');
    	showText(that_day);
    })
	
	function showText(day) {
		$('table').each(function(){
			$(this).hide();
			
		})
		$('[data-showingbutton]').removeClass('clicked');
		$('[data-showingbutton='+ day +']').addClass('clicked');
		$('table#'+ day).show();
    }
	

	
    
	
})(jQuery);



























