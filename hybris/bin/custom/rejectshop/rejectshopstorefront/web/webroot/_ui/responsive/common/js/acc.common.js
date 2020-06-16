	ACC.common = {
	
	processingMessage: $("<img src='" + ACC.config.commonResourcePath + "/images/spinner.gif'/>"),

	
	blockFormAndShowProcessingMessage: function (submitButton)
	{
		var form = submitButton.parents('form:first');
		form.block({ message: ACC.common.processingMessage });
	},

	refreshScreenReaderBuffer: function ()
	{
		// changes a value in a hidden form field in order
		// to trigger a buffer update in a screen reader
		$('#accesibility_refreshScreenReaderBufferField').attr('value', new Date().getTime());
	}

};



/* Extend jquery with a postJSON method */

jQuery.extend({
	postJSON: function (url, data, callback)
	{
		return jQuery.post(url, data, callback, "json");
	}
});

// add a CSRF request token to POST ajax request if its not available
$.ajaxPrefilter(function (options, originalOptions, jqXHR)
{
	// Modify options, control originalOptions, store jqXHR, etc
	if (options.type === "post" || options.type === "POST")
	{
		var noData = (typeof options.data === "undefined");
		if (noData || options.data.indexOf("CSRFToken") === -1)
		{
			options.data = (!noData ? options.data + "&" : "") + "CSRFToken=" + ACC.config.CSRFToken;
		}
	}
});
/** validation functions for SendAFriendEmail From.*/
		function validateEmailFieldsSF(e) {
			
			var recipientEmail = $('#recipientEmailSF').val();
			var email = $('#emailSF').val();
			var name = $('#nameSF').val();
			var message = $('#messageSF').val();
			var yourName = $('#yourNameSF').val();
			if (!validateEmail(email)) {
				e.preventDefault();
				$(".emailError").show();
			$("#emailSF").css({'border':'1px solid #e2001a'});
			}
			else {
				$(".emailError").hide();
				$("#emailSF").css({'border':''});
			}
			if (!validateEmail(recipientEmail)) {
				e.preventDefault();
				$(".recipientMailError").show();
				$("#recipientEmailSF").css({'border':'1px solid #e2001a'});
			} else {
				$(".recipientMailError").hide();
				$("#recipientEmailSF").css({'border':''});
			}
			if (name == '') {
				e.preventDefault();
				$(".nameError").show();
				$("#nameSF").css({'border':'1px solid #e2001a'});
			} else {
				$(".nameError").hide();
				$("#nameSF").css({'border':''});
			}
			if (message == '') {
				e.preventDefault();
				$(".messageError").show();
				$("#messageSF").css({"border-color": "#e2001a"});
			} else {
				$(".messageError").hide();
				$("#messageSF").css({"border-color": ""});
			}
			if (yourName == '') {
				e.preventDefault();
				$(".recipientError").show();
				$("#yourNameSF").css({"border-color": "#e2001a"});
			} else {
				$(".recipientError").hide();
				$("#yourNameSF").css({"border-color": ""});
			}
			if (!validateEmail(email) || !validateEmail(recipientEmail) || (name == '')
					|| (message == '')) {
				e.preventDefault();
				return false;
			} else {
				return true;
			}
		}
		function validateEmail(email) {
			var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			return re.test(email);
		}
/** End of the function */	
/**
 * Removal of added CSS on close.
 */
	function resetSFCss(){
		$(".emailError").hide();$(".recipientMailError").hide();$(".recipientError").hide();$(".nameError").hide();$(".messageError").hide();
		$("#recipientEmailSF").css({'border':''});
		$("#emailSF").css({'border':''});
		$("#nameSF").css({'border':''});
		$("#messageSF").css({"border-color": ""});
		$('#recipientEmailSF').val("");
		$('#emailSF').val("");
		$('#yourNameSF').val("");
		$('#messageSF').val("");
		
		return true;
	}
/** Done resetting changes*/
/**Validating SendReminder Fields */
	function validateEmailFieldsSR(e) {
		var email= $("#emailReminderSR").val();
		var date = $("#dateReminderSR").val();
		//var time = $("#timeRemidnerSR").val();
		if (!validateEmail(email)) {
			e.preventDefault();
		$(".emailSRError").show();
		$("#emailReminderSR").css({'border':'1px solid #e2001a'});
		}
		else{
			$(".emailSRError").hide();
			$("#emailReminderSR").css({'border':''});
		}
		if(date == ""){
			e.preventDefault();
			$(".dateSRError").show();
			$("#dateReminderSR").css({'border':'1px solid #e2001a'});
		}
		else{
			$(".dateSRError").hide();
			$("#dateReminderSR").css({'border':''});
		}
		/*if(time == ""){
			e.preventDefault();
			$(".timeSRError").show();
			$("#timeRemidnerSR").css({'border':'1px solid #e2001a'});
		}
		else{
			$(".timeSRError").hide();
			$("#timeRemidnerSR").css({'border':''});
		}*/
		if (!validateEmail(email)||(date == "")) {
			e.preventDefault();
			return false;
		} else {
			return true;
		}
	}
/**Done validating */
/**Resetting SendReminder Fields*/
	function resetSRCss(){
		$(".timeSRError").add(".dateSRError").add(".emailSRError").hide();
		return true;
	}
		
/**Done resetting Fields*/
	     /*Start of terms check */
	      function termsCheckChanged() {
	     if ($('#termsCheck').is(':checked')) {
	         $('#acceptTermsAndconditionsLink').css("opacity", '1');
	     }
	     if (!$('#termsCheck').is(':checked')) {
	         $('#acceptTermsAndconditionsLink').css("opacity", '0.6');
	     }
	}
	     function acceptGiftCardsTermsAndConditions() {
	         if ($('#termsCheck').is(':checked')) {
	             $(document)
	                     .on(
	                             "click",
	                             ".notaccepted",
	                             function(el) {
	                                 ACC.colorbox.close();
	                                 $
	                                         .ajax({
	                                             dataType : "html",
	                                             contentType : "text/html",
	                                             method : "GET",
	                                             data : {
	                                                 termsCheck : true
	                                             },
	                                             url : ACC.config.contextPath
	                                                     +
	'/giftcards/acceptGiftCardsTermsAndConditions',
	                                             success : function(response) {
	                                               
	  ACC.colorbox.open('CheckGiftCardBalance', {
	                                                     html : response,
	                                                     width : "30%",
	                                                     height : "60%",
	                                                     title : 'Check Gift Card Balance'
	                                                 });
	                                             }
	                                         });

	                             });
	         }
	     }
	        /* end of terms check for gift card*/

	$(document).ready(function() {
		
		/* $(".imagezooming").hover(function(){
		 
			$(this).spzoom();
		});
		*/
		 $(".iframeClass").colorbox({iframe:true, innerWidth:350, innerHeight:150,onComplete: function(){
             $('#cboxTitle').text("SAVVY SHOPPER");
         }});

		 jQuery.fn.popupPositionCenter =function () {
			this.css("position","absolute");
			this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
					$(window).scrollTop()) + "px");
			this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +
					$(window).scrollLeft()) + "px");
			return this;
		}
		var pdfpropertyLoading = $(".cmsimage img[src*='TRS-Landlord-Presentation-16-04-2013.pdf']").attr("src");
		 $(".cmsimage img[src*='TRS-Landlord-Presentation-16-04-2013.pdf']").attr("style","display:none");
		
		$(".cms_pdf_image").attr("href",pdfpropertyLoading);
		var pdfsupplierLoading = $(".cmsimage img[src*='TRS-Ethical-Sourcing-Policy-2013.pdf']").attr("src");
		 $(".cmsimage img[src*='TRS-Ethical-Sourcing-Policy-2013.pdf']").attr("style","display:none");
		
		$(".cms_pdf_image").attr("href",pdfsupplierLoading);
		$("ul.inner-nav li").each(function(){ if($(this).find("a").attr("href") == window.location.pathname) $(this).addClass("active1");});

	    //$(".carouselImage .lazyOwl").on("click",function(){ var newImage = $(this).attr("data-new"); $(this).parents(".imageZoom").children(".newimage").find(".lazyOwl").attr("src",newImage);$(this).parents(".imageZoom").children(".newimage").find(".newUrl").attr("href",newImage); $('.easyzoom').easyZoom(); }); 
		//var $easyzoom = $('.easyzoom').easyZoom();
		/*$(".rating-stars").rate();*//*for rating star*/

		
	    $(".newClassGallery .lazyOwl").on("click",function(){
	    	var newImage = $(this).attr("data-new"); 
	    	$(this).parents(".imageZoom").children(".newImage").find(".lazyOwl").attr("src",newImage);
	    	$(this).parents(".imageZoom").children(".newImage").find(".newUrl").attr("href",newImage);  
	    }); 
		
		$(".rating-stars").rate();/*for rating star*/
		
		$(document).on("click",".submitRemoveProduct",function(){
		 
			 
			$('.arrow_button').removeClass("valueAddedImage");	
		});
		
		
		$("#dateVisited").on("click",function(){
 			$(this).datepicker().datepicker("show");
		});
	 
	
		
		$(".drop").click(function(){
			 
			$("#menudropdown").toggle();
		});
		
		$("<span class='newtoggle glyphicon glyphicon-chevron-down'></span>").insertAfter(".nav-pills .has-sub>a");
		$("span.newtoggle").click(function(){
		
		if($(this).next().is(":visible")){
			$(".sub-navigation").slideUp();
			
		}
		else{
			$(".sub-navigation").slideUp();
				$(this).next().slideDown();
		}
		});
		
		$(".reportdetails").next().addClass('financialreportlist');
		 
	 
		$(".termsAndConditionsPopup").colorbox({width:"45%", height:"620px"});
		$(".termsAndConditionsvoucherPopup").colorbox({width:"45%", height:"620px"});
		
		var owl = $("#owl-demo");
		 
		  owl.owlCarousel({
			  loop:true,
		      items : 3
		  });
		  
		  var owl3 = $("#owl-demo3");
		  owl3.owlCarousel({
			  loop:true,
		      items : 4
		  });
		  
		// Custom Navigation Events
		  $(".next").click(function(){
		    owl3.trigger('owl.next');
		  });
		  $(".prev").click(function(){
		    owl3.trigger('owl.prev');
		  });
		  $(".play").click(function(){
		    owl3.trigger('owl.play',1000); //owl.play event accept autoPlay speed as second parameter
		  });
		  $(".stop").click(function(){
		    owl3.trigger('owl.stop');
		  });
		  
		  // Custom Navigation Events
		  $(".next").click(function(){
		    owl.trigger('owl.next');
		  });
		  $(".prev").click(function(){
		    owl.trigger('owl.prev');
		  });
		  $(".play").click(function(){
		    owl.trigger('owl.play',1000); //owl.play event accept autoPlay speed as second parameter
		  });
		  $(".stop").click(function(){
		    owl.trigger('owl.stop');
		  });
		 
		  $('#back_to_top').click(function(){
			    $("html, body").animate({ scrollTop: 0 }, 600);
			    return false;
			 });
			/*$(document).on("click","#submitButton",function(el){
				 $.ajax({
						dataType: "json",
						method: "POST",
						url: /sendemailMsg,
						success: function (data)
						{
							alert(data);
						}
					});
				 
			 });*/
		$(document).on("click",".printButton",function(){
			  $(".mini-cart-item .thumb").css("display","none");
			  window.print();
			  $(".mini-cart-item .thumb").css("display","block");
		});
		$(document).on("click",".printWithImageButton",function(){
				window.print();
		});


		$('#dayofReminderSR').datetimepicker({
		         pickTime: false
		     });
			
			$('#dayofReminderSR').on('changeDate', function(ev){
				$('#dayofReminderSR').datetimepicker('hide')
			});




		     $('#timeSR').datetimepicker({
		          pickDate: false,
				 pickSeconds: false,
				 pick12HourFormat: true,
		     });
		     $('#timeSR').on('changeDate', function(ev){
					$('#timeSR').datetimepicker('hide')
				});
		     
		     $(".emailReminderListButton").on("click",function(){
					$('#popup2').show();
				    $('#popup2').popupPositionCenter();


				});
		     $(".emailFriendListButton").on("click",function(){
				$('#popup1').show();
				 $('#popup1').popupPositionCenter();
			});
				$('#my-welcome-message').firstVisitPopup({
					cookieName : 'homepage',
					showAgainSelector: '#show-message'
				});
				
				
				
				var appendthis =  ("<div class='modal-overlay js-modal-close'></div>");

				$('a[data-modal-id]').click(function(e) {
					e.preventDefault();
			    $("body").append(appendthis);
			    $(".modal-overlay").fadeTo(500, 0.7);
			    //$(".js-modalbox").fadeIn(500);
					var modalBox = $(this).attr('data-modal-id');
					$('#'+modalBox).fadeIn($(this).data());
				});  
			  
			  
			$(".js-modal-close, .modal-overlay").click(function() {
			    $(".modal-box, .modal-overlay").fadeOut(500, function() {
			        $(".modal-overlay").remove();
			    });
			 
			});
			
			/*if($(".page-productList").length>0 && $(".top .pagination > li").length>4 && window.innerWidth<481){
				$(".pagination").parent().addClass("w100p");
			}*/
			
			/*$(window).resize(function() {
				if($(".page-productList").length>0 && $(".top .pagination > li").length>4 && window.innerWidth<481){
					$(".pagination").parent().addClass("w100p");
				}
			    $(".modal-box").css({
			        top: 100,
			        left: ($(window).width() - $(".modal-box").outerWidth()) / 2
			    });
			});*/
			 
			$(window).resize();
			
			var pageURL = $(location).attr("href");
			var newClass = pageURL.replace("https://localhost:9002/","/");
			
			$("a[href='"+newClass+"']").parents("#drpdowm").show();
			
			
			$(".managementTeamPagesection1 .inner-nav .childnode").on("click",function(){
					$(".managementTeamPagesection1 .inner-nav #drpdowm").css("display","none");
					$(this).next("#drpdowm").toggle();
			});
			
			
		
	 
				 $(document).on("click", ".termsAndConditionsPopup", function () {
			   		  var myBookId = $(this).data('id');
			    
			     	$(".modal-body #bookId").val( myBookId );
				 });
				 
				 $(".accheader").click(function(){
					
				 //$("#accordionitems .content").removeClass("faqtoggle");	 
				 
				 	$("#accordionitems .accheader").removeClass("ui-state-default");
				 	$(this).addClass("ui-state-default");
				 	
				 	if($(this).next().hasClass("faqtoggle")){
				 
					 $(this).next(".content").removeClass("faqtoggle");
					 $("#accordionitems .content").addClass("cls");	 
						$("#accordionitems .accheader").removeClass("ui-state-default");
				 	}
				 	else{
				 
				
					 $("#accordionitems .content").removeClass("faqtoggle");
					 $("#accordionitems .content").addClass("cls");	 
					 $(this).next(".content").toggleClass("faqtoggle");
					
				 }
					
				
				 });

				 /* Restric character count to 40 for each item name */
				 function cutString(){    
						var allNames = document.getElementsByClassName('item-desc');         
						var charsToCutTo = 40;
						Array.prototype.forEach.call(allNames, function(el) {
							var text = el.innerHTML;
							if(text.length > charsToCutTo){
								var strShort = "";
								for(i = 0; i < charsToCutTo; i++){
									strShort += text[i];
								}
								el.innerHTML = strShort + "...";
							}            
						});

					  allNames = document.getElementsByClassName('item-name');
					 charsToCutTo =30;
					 Array.prototype.forEach.call(allNames, function(el) {
						 var text = el.innerHTML;
						 if(text.length > charsToCutTo){
							 var strShort = "";
							 for(i = 0; i < charsToCutTo; i++){
								 strShort += text[i];
							 }
							 el.innerHTML = strShort + "...";
						 }
					 });
					}
					cutString();

				 
			if($(".page-homepage").length>0){
				if($("#Horizontalbanner1 li").length == 1) $("#Horizontalbanner1").addClass("single");
			}
			$("#footerNavigation ul li a.heading").click(function(){
				$(this).find("span").toggleClass("glyphicon-chevron-right glyphicon-chevron-down").closest("h3").next("ul").toggle();
			});
			$("#accordionitems div:first-child").addClass("ui-state-default");
			$("#accordionitems div:nth-child(2)").addClass("faqtoggle");

		if ($("#feedbackType").length>0){
			var v =$("#feedbackType").val().toLowerCase();
			if (v=='store experience'|| v=='store customer service'){
				$('#customerFeedbackSubType').show();
			}else{$('#customerFeedbackSubType').hide();}
		}
		/**
		 * falling stars for home page 
		if (window.innerWidth>800) {
			if ($(".page-homepage").length > 0) {
				snowDrop(250, randomInt(1180, 1680));
				snow(50, 100);
			}
		}*/

	});

	/**Falling starts for Home page
	 * function snow(num, speed) {
		if (num > 0) {
			setTimeout(function () {
				$('#drop_' + randomInt(1, 250)).addClass('animate');
				num--;
				snow(num, speed);
			}, speed);
		}
	};

	function snowDrop(num, position) {
		if (num > 0) {
			var drop = '<div class="snowdrop snow" id="drop_' + num + '"></div>';

			$('body').append(drop);
			$('#drop_' + num).css('left', position);
			num--;
			snowDrop(num, randomInt(60, 1680));
		}
	};

	function randomInt(min, max) {
		return Math.floor(Math.random() * (max - min + 1) + min);
	};*/
	
	function publicNoticOnclickTracking(){
		window.mediator.publish('publicNoticeClick',{});
	}

	$("#feedbackType").on('change', function(){
		var v =$(this).val().toLowerCase();
		if (v=='store experience'|| v=='store customer service'){
			$('#customerFeedbackSubType').show();
		}else{$('#customerFeedbackSubType').hide();}
	});
/*
	$("#SpringGardenNavNode")
		.mouseover(function(){$("#SpringGardenNavNodeLink").css("display","block");})
		.mouseout(function(){$("#SpringGardenNavNodeLink").css("display","none");});

	$("#SpringGardenNavNodeLink")
		.mouseover(function(){$("#SpringGardenNavNodeLink").css("display","block");})
		.mouseout(function(){$("#SpringGardenNavNodeLink").css("display","none");});


	$("#SpringStorageNavNode")
		.mouseover(function(){$("#SpringStorageNavNodeLink").css("display","block");})
		.mouseout(function(){$("#SpringStorageNavNodeLink").css("display","none");});

	$("#SpringStorageNavNodeLink")
		.mouseover(function(){$("#SpringStorageNavNodeLink").css("display","block");})
		.mouseout(function(){$("#SpringStorageNavNodeLink").css("display","none");});

        $("#NHomeOfChristmasNav")
                .mouseover(function(){$("#NHomeOfChristmasNavLink").css("display","block");})
                .mouseout(function(){$("#NHomeOfChristmasNavLink").css("display","none");});

        $("#NHomeOfChristmasNavLink")
                .mouseover(function(){$("#NHomeOfChristmasNavLink").css("display","block");})
                .mouseout(function(){$("#NHomeOfChristmasNavLink").css("display","none");});


        $("#HalloweenNavNode")
                .mouseover(function(){$("#HalloweenNavNodeLink").css("display","block");})
                .mouseout(function(){$("#HalloweenNavNodeLink").css("display","none");});

        $("#HalloweenNavNodeLink")
                .mouseover(function(){$("#HalloweenNavNodeLink").css("display","block");})
                .mouseout(function(){$("#HalloweenNavNodeLink").css("display","none");});
*/
//Dynamically Add Dropdown Nodes
$('.has-sub').each(function(i, obj) {
        if($('#'+obj.id+'Link').length){
                //console.log('Applying to ' + obj.id)
                $('#'+obj.id)
                        .mouseover(function(){$('#'+obj.id+'Link').css("display","block");})
                        .mouseout(function(){$('#'+obj.id+'Link').css("display","none");});

                $('#'+obj.id+'Link')
                        .mouseover(function(){$('#'+obj.id+'Link').css("display","block");})
                        .mouseout(function(){$('#'+obj.id+'Link').css("display","none");});
        //}else{
        //      console.log('NOT Applying to ' + obj.id)
        }
});
