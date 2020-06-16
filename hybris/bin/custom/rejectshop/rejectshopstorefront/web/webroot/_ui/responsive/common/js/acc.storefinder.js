	ACC.storefinder = {

	_autoload: [
		["init", $(".js-store-finder").length != 0],
		["bindStoreChange", $(".js-store-finder").length != 0],
		["bindSearch", $(".js-store-finder").length != 0],
		"bindPagination",
		"findStoreOnStartup",
		"initGoogleMap"
	],
	
	storeData:"",
	storeId:"",
	coords:{},
	storeSearchData:{},

	createListItemHtml: function (data,id){
		var item="";
		var contextRoot = ACC.config.encodedContextPath;
		if(data.closed != "false")
		{
			item+='<li class="store-finder-navigation-list-entry">';
			item+='<input type="radio" name="storeNamePost" value="'+data.closed+'" id="store-filder-entry-'+id+'" class="js-store-finder-input" data-id="'+id+'">';
			item+='<label for="store-filder-entry-'+id+'" class="js-select-store-Nolabel">';
			item+='<span class="store-finder-navigation-list-entry-info">';
			item+='<span class="store-finder-navigation-list-entry-name"> <a href="#"> '+data.displayName+' </a> </span>';
			item+='<span class="store-finder-navigation-list-entry-city"> This store is not available </span>';
			item+='</span>';
			item+='</label>';
			item+='</li>';
		}
		else
		{
			var storeTealiumEvent="return tealiumTagEvent('storeDetail','"+data.displayName+"','"+data.town+"','"+data.postalCode+"')";
			item+='<li class="store-finder-navigation-list-entry">';
			item+='<input type="radio" name="storeNamePost" value="'+data.closed+'" id="store-filder-entry-'+id+'" class="js-store-finder-input" data-id="'+id+'">';
			item+='<label for="store-filder-entry-'+id+'" class="js-select-store-label">';
			item+='<span class="store-finder-navigation-list-entry-info">';
			item+='<span class="store-finder-navigation-list-entry-name"> <a href="'+data.url+'" onclick="'+storeTealiumEvent+'"> '+data.displayName+' </a></span>';
			item+='<span class="store-finder-navigation-list-entry-address"> <a href="'+data.url+'" onclick="'+storeTealiumEvent+'"> '+data.line1+' '+data.line2+' </a> </span>';
			
			//item+='<span class="store-finder-navigation-list-entry-city">'+data.town+'</span>';
			//item+='<span class="store-finder-navigation-list-entry-state">'+data.state+'</span>';
			item+='</span>';
			item+='<span class="store-finder-navigation-list-entry-distance">';
			item+='<span> <a href='+ contextRoot + '/' + data.url+' onclick="'+storeTealiumEvent+'">'+data.formattedDistance+'</a></span>';
			item+='</span>';
			item+='</label>';
			item+='</li>';
		
		}
		
		
		
		return item;
		

	
	},

	refreshNavigation: function (){
		var listitems = "";
		data = ACC.storefinder.storeData
		
		if(data){
			for(i = 0;i < data["data"].length;i++){
				listitems += ACC.storefinder.createListItemHtml(data["data"][i],i)
			}
	
			$(".js-store-finder-navigation-list").html(listitems);
	
			// select the first store
			var firstInput= $(".js-store-finder-input")[0];
			$(firstInput).click();
		}


		var page = ACC.storefinder.storeSearchData.page;
		$(".js-store-finder-pager-item-from").html(page*15+1);

		var to = ((page*15+15)>ACC.storefinder.storeData.total)? ACC.storefinder.storeData.total : page*15+15 ;
		$(".js-store-finder-pager-item-to").html(to);
		$(".js-store-finder-pager-item-all").html(ACC.storefinder.storeData.total);
		$(".js-store-finder").removeClass("show-store");

	},


	bindPagination:function ()
	{		
		$(document).on("click",".js-store-finder-details-back",function(e){
			e.preventDefault();
			$(".js-store-finder").removeClass("show-store");
			
		})
		



		$(document).on("click",".js-store-finder-pager-prev",function(e){
			e.preventDefault();
			var page = ACC.storefinder.storeSearchData.page;
			ACC.storefinder.getStoreData(page-1)
			checkStatus(page-1);
		})

		$(document).on("click",".js-store-finder-pager-next",function(e){
			e.preventDefault();
			var page = ACC.storefinder.storeSearchData.page;
			ACC.storefinder.getStoreData(page+1)
			checkStatus(page+1);
		})

		function checkStatus(page){
			if(page==0){
				$(".js-store-finder-pager-prev").attr("disabled","disabled")
			}else{
				$(".js-store-finder-pager-prev").removeAttr("disabled")
			}
			
			if(page == Math.floor(ACC.storefinder.storeData.total/15)){
				$(".js-store-finder-pager-next").attr("disabled","disabled")
			}else{
				$(".js-store-finder-pager-next").removeAttr("disabled")
			}
		}

	},


	bindStoreChange:function()
	{
		$(document).on("change",".js-store-finder-input",function(e){
			e.preventDefault();
			storeData=ACC.storefinder.storeData["data"];
			/*console.log(storeData);*/
			var storeId=$(this).data("id");
			var storeClosed = $(this).data("js-store-closed");
			var $ele = $(".js-store-finder-details");
			$.each(storeData[storeId],function(key,value){
				if(key=="image"){
					if(value!=""){
						$ele.find(".js-store-image").html('<img src="'+value+'" alt="" />');
					}else{
						$ele.find(".js-store-image").html('');
					}
				}else if(key=="productcode"){
					$ele.find(".js-store-productcode").val(value);
				}
				else if(key=="openings"){
					if(value!=""){
						var $oele = $ele.find(".js-store-"+key);
						var openings = "";
						$.each(value,function(key2,value2){
							openings += "<dt>"+key2+"</dt>";
							openings += "<dd>"+value2+"</dd>";
						});

						$oele.html(openings);

					}else{
						$ele.find(".js-store-"+key).html('');
					}

				}
 				else if (key == "specialOpenings") {

							if (value != "") {
								var $oele = $ele.find(".js-store-" + key);
								var openings = "";
								$.each(value, function(key2, value2) {

									openings += "<dt>" + key2 + "</dt>";
									openings += "<dd>" + value2 + "</dd>";
								});

								$oele.html(openings);

							} else {
								$ele.find(".js-store-" + key).html('');
							}

						}

				else if(key=="features"){
					var features="";
					$.each(value,function(key2,value2){
						features += "<li>"+value2+"</li>";
					});

					$ele.find(".js-store-"+key).html(features);

				}
				else{
					if(value!=""){
						$ele.find(".js-store-"+key).html(value);
					}else{
						$ele.find(".js-store-"+key).html('');
					}
				}

			})
				

		
			ACC.storefinder.storeId = storeData[storeId];
			ACC.storefinder.initGoogleMap();
		
			

		})

		$(document).on("click",".js-select-store-label",function(e){
			$(".js-store-finder").addClass("show-store");
			$(".js-store-finder-details").attr("style","display:block");
			$(".dispaly_name").remove();
		})

		$(document).on("click",".js-back-to-storelist",function(e){
			$(".js-store-finder").removeClass("show-store");
		});

		$(document).on("click",".js-select-store-Nolabel",function(e){
		
			$(".js-store-finder-details").attr("style" +
					"","display:none");
			$(".dispaly_name").remove();
			
			var displayName = $(this).find(".store-finder-navigation-list-entry-name").text();
			
			$(".store-finder-panel").append("<b class='dispaly_name'> The Store"+displayName+" details are not avaliable</b>");
		});
		
	},



	initGoogleMap:function(){

		if($(".js-store-finder-map").length > 0){
			ACC.global.addGoogleMapsApi("ACC.storefinder.loadGoogleMap");
		}
		
		if($(".page-storefinderPage").length > 0){
			
			ACC.global.addGoogleMapsApi("ACC.storefinder.loadOnNextPage");
		}
		
	},
 
	loadGoogleMap: function(){

		storeInformation = ACC.storefinder.storeId;
	
		var store_datas=ACC.storefinder.storeData.data;
/*		console.log(store_datas);*/
		
		if($(".js-store-finder-map").length > 0)
		{			
			$(".js-store-finder-map").attr("id","store-finder-map")
			var centerPoint = new google.maps.LatLng(storeInformation.latitude,storeInformation.longitude);
/*			console.log(centerPoint+ "Center");*/
			var mapOptions = {
				zoom:10,
				zoomControl: true,
				panControl: true,
				streetViewControl: false,
				mapTypeId: google.maps.MapTypeId.ROADMAP,
				center: centerPoint
			}
			
			var map = new google.maps.Map(document.getElementById("store-finder-map"), mapOptions);
			//console.log(store_datas);
			if (store_datas){
				$.each( store_datas, function( k, v ) {

					var marker = new google.maps.Marker({
						position: new google.maps.LatLng(v.latitude, v.longitude),
						map: map,
						title: v.displayName,
						icon: "https://maps.google.com/mapfiles/marker" + 'ABCDE'.charAt(i) + ".png"
					});
					var contentInformation = "<div class='markerDialog'>"+"<span style='font-size: 16px;font-weight: bold;margin-bottom:0px;display: inline-block;margin-right: 6px;'>"+v.displayName +"</span>"+"<span style='color: #15C!important;text-decoration: none;line-height: normal;font-size: 13px;'>"+"</span>"+" </br>"+"<div class='markerAddress' style='display: inline-block;vertical-align: top;'>"+ v.line1+"</br>"+ v.line2+ "</br>" + v.town +","+v.state+","+ v.postalCode+ ",</br>" +v.phone+"</div>";
					var infowindow = new google.maps.InfoWindow({
						content: contentInformation,
						disableAutoPan: true
					});
					google.maps.event.addListener(marker, 'click', function (){
							/*infowindow.open(map, marker);*/
					  if($('.gm-style-iw').length) {
						 $('.gm-style-iw').parent().remove();
						 }
					  infowindow.open(map, marker);

					});
				});
			}

		
		
		}
		
	},


	bindSearch:function(){

		$(document).on("submit",'#storeFinderForm', function(e){
			e.preventDefault()
			var q = $(".js-store-finder-search-input").val();

			if(q.length>0){ 
				$("footer").css("position","relative");
				ACC.storefinder.getInitStoreData(q);
			}else{
				if($(".js-storefinder-alert").length<1){
					var emptySearchMessage = $(".btn-new-store").data("searchEmpty")
					$(".js-store-finder").hide();
					$("footer").css("position","absolute");
					$("#storeFinder").before('<div class="js-storefinder-alert alert alert-danger alert-dismissable" ><button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>' + emptySearchMessage + '</div>');
				}
			}
		});


		$(".js-store-finder").hide();
		$('#findStoresNearMe').on('click',function(e){
			e.preventDefault();
			$("footer").css("position","relative");
			ACC.storefinder.getInitStoreData(null,ACC.storefinder.coords.latitude,ACC.storefinder.coords.longitude);
		});
		


	},


	getStoreData: function(page){
		ACC.storefinder.storeSearchData.page = page;
		url= $(".js-store-finder").data("url");
		$.ajax({
			url: url,
			data: ACC.storefinder.storeSearchData,
			type: "get",
			success: function (response){
				tealiumTagEvent('storeFinder');
				if (response != '' && response.indexOf('html')<0){
				  $(".js-store-finder").show();	
				  ACC.storefinder.storeData = $.parseJSON(response);
				}else{
					var noresult="Check that you entered a valid postcode or place name.";
					var message="<div class='alert alert-danger alert-dismissable'>"+
					"<button class='close'aria-hidden='true' data-dismiss='alert' type='button'>&times;</button>"+noresult+"	</div>";
					$("#globalMessages").html(message);
					ACC.storefinder.storeData="";
					$(".js-store-finder").hide();
				}
				ACC.storefinder.refreshNavigation();
			}
		});
	},

	getInitStoreData: function(q,latitude,longitude){
		
		$(".alert").remove();
		data ={
			"q":"" ,
			"page":0
		}
		if(q != null){
			data.q = q;
		}

		if(latitude != null){
			data.latitude = latitude;
		}

		if(longitude != null){
			data.longitude = longitude;
		}

		ACC.storefinder.storeSearchData = data;
	
		ACC.storefinder.getStoreData(data.page);
		//$(".js-store-finder").show();
		$(".js-store-finder-pager-prev").attr("disabled","disabled")
		$(".js-store-finder-pager-next").removeAttr("disabled");
		
		if($("div").hasClass("" +
				""))
		{
		
			$("footer").css("position","relative");
		}
	},

	findStoreOnStartup: function(){
			var q = $("#query").attr("data-q");
			if(q != undefined && q != ''){
			  ACC.storefinder.getInitStoreData(q);
			}	
	},
	
	
	init:function(){
		$("#findStoresNearMe").removeAttr("disabled","disabled");
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(
				function (position){
					ACC.storefinder.coords = position.coords;
					//console.log(ACC.storefinder.coords);
					
				},
				function (error)
				{
					console.log("An error occurred... The error code and message are: " + error.code + "/" + error.message);
				}
			);
		}
	},
	loadOnNextPage : function()
{
		
		
		if($(".store_map_details").length > 0)
		{			
			
			/*console.log($("#map_canvas").data("stores"));*/
			var centerPoint = new google.maps.LatLng($("#map_canvas").data("latitude"),$("#map_canvas").data("longitude"));			
			var mapOptions = {
				zoom: 13,
				zoomControl: true,
				panControl: true,
				streetViewControl: false,
				mapTypeId: google.maps.MapTypeId.ROADMAP,
				center: centerPoint
			}
			
			var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
			
			
			var marker = new google.maps.Marker({
				position: centerPoint,
				map: map,
				title: $("#map_canvas").data("name"),
				icon: "https://maps.google.com/mapfiles/marker" + 'A' + ".png"
			});
			//var contentInformation = $("#map_canvas").data("stores").name;
			var name = $("#map_canvas").data("stores").name;
			var address1 = $("#map_canvas").data("stores").addressLine1;
			var address2 = $("#map_canvas").data("stores").addressLine2;
			var town = $("#map_canvas").data("stores").town;
			var state = $("#map_canvas").data("stores").state;
			var pin = $("#map_canvas").data("stores").postalCode;
			var mapsQuery = name + "," + address1 + "," + town;
			var contentInformation = "<div class='markerDialog'><b>"+name+"<b></br><div>"+address1+"</div><div>"+address2+"</div><div>"+town+"</div><div>"+state+" "+pin+"</div><div><a href='https://www.google.com.au/maps/dir//"+mapsQuery+"' target='_blank'>Get Directions</a></div></div>";
			var infowindow = new google.maps.InfoWindow({
				content: contentInformation,
				disableAutoPan: true
			});
			google.maps.event.addListener(marker, 'click', function (){
				infowindow.open(map, marker);
			});
		}
	}
	
};

$('.store-finder-search').ready(function(){
if(localStorage.getItem('back')=='true'){	

	
		ACC.storefinder.bindSearch();
		$('#storelocator-query').val(localStorage.getItem('lastPin'));			
				$("#storeFinderForm .btn-new-store").click();
				$('#storelocator-query').css({'color':'#fff !important'});
				localStorage.setItem('back',false);
		
}	

});

if($("a").hasClass("getdirection"))
{
	$("footer").css("position","relative");
}

