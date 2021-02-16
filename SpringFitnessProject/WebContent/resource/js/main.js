

(function ($) {
    "use strict";
    
    /*---------home page and top banner----------*/
    $('.go-to-main').on('click', function(){
		window.location="/SpringFitnessProject/homepage/main.em"
    })

    $('.go-to-classpage').on('click', function(){
		window.location="/SpringFitnessProject/homepage/classPage.em"
    })

	$('.go-to-pt').on('click', function(){
		window.location="/SpringFitnessProject/homepage/ptPage.em"
    })

	$('.go-to-pilates').on('click', function(){
		window.location="/SpringFitnessProject/homepage/pilates.em"
    })

    $('.go-to-login').on('click', function(){
		window.location="/SpringFitnessProject/login/loginForm.em"
    })
    
    $('.go-to-location').on('click', function(){
		window.location="/SpringFitnessProject/region/region.em"
    })
    
    $('.go-to-qboard').on('click', function(){
		window.location="/SpringFitnessProject/community/messageBoard.em"
    })
    
    $('.to-my-account').on('click', function(){
    	var user = $(this).attr('id');
    	if(user=="admin"){
    		window.location="/SpringFitnessProject/adminPage/adminBoard.em";
    	} else if(user=="teacher"){
    		window.location="/SpringFitnessProject/memberPage/memberBoard.em";
    	} else if(user=="member"){
    		window.location="/SpringFitnessProject/memberPage/memberBoard.em";
    	}
    })
    
    $('.log-out-btn').on('click', function(){
		window.location="/SpringFitnessProject/login/logoutPro.em";
	})
    
    $('.close-btn').on('click', function(){
		window.close();
    })
    
    
    $(window).on('unload', function(){
			window.opener.location.reload();
	})
	
	/*-------main slideshow-------*/
	
	var slideIndex = 0;
    $(window).on('load', function(){
    	showSlides();
    })
	
    function showSlides() {
    	
	    $('.mySlides').each(function() {
	    	$( this ).hide();
	    });
	    
		slideIndex++;
		if (slideIndex > $('.mySlides').length) {slideIndex = 1}  
		
		var num = slideIndex-1
		var slide = $(".mySlides:eq(" + num + ")").show();
		
		setTimeout(showSlides, 2000); // Change image every 2 seconds
	}
	
    
    
})(jQuery);


























