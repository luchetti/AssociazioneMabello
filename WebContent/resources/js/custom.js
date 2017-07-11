$(document).ready(function(){
	displayFirstDiv();
});

$(window).scroll(function(){

	fadeAway();
});




//Custom Functions
function donateTo($name){
	if(sessionStorage.getItem("donateTo")===null){
			sessionStorage.setItem("donateTo","beni");
	}
	var $lastDivActive=sessionStorage.getItem("donateTo");
	
	if($lastDivActive !== $name){
		$("#"+$lastDivActive).fadeOut();
		$("#"+$name).fadeIn();
		sessionStorage.setItem("donateTo",$name);
	}
}
/*function menuToggle($name) {

	/*if($name=="socialMenu"){
		toggleSmallScreenMenu("socialMenu","linkMenu");
	}else{
		toggleSmallScreenMenu("linkMenu", "socialMenu");
	}*//*

	var x = document.getElementById($name);
	if (x.className.indexOf("w3-show") == -1) {
		x.className += " w3-show";
	} else { 
		x.className = x.className.replace(" w3-show", "");
	}
}
*/
function toggleSmallScreenMenu($choosenMenu,$otherMenu){
	$("."+$choosenMenu).toggleClass('w3-show');
	$("."+$otherMenu).removeClass('w3-show');

}

function fadeAway(){
	$divBottom=$("#firstDiv").offset().top + $("#firstDiv").outerHeight();
	$scrollBar=$(window).scrollTop();

	if($scrollBar>0){
		//if($scrollBar>($divBottom/4)){

		if($scrollBar>($divBottom-1)){
			//$("#firstDiv").hide();
			//$("#header").slideDown(1000);
		}else{
			$("#firstDiv").slideUp(1500);
			//$("#header").slideDown(1000);
		}
		$("#mainContainer").delay(1500).css('opacity', '100');
	}
}
function toggleMenu($name){
	$("#"+$name).fadeToggle("swing");
}
function menuOpen(){
	$("#sideBar").css('display', 'block');
}
function menuToggle(){
	$("#sideBar").fadeToggle("swing");
}

function menuClose(){
	$("#sideBar").css('display', 'none');
}

function displayFirstDiv(){
	if(typeof(Storage) !== "undefined") {
		var $visited=sessionStorage.getItem("visited");
		if ($visited == null || $visited == 0) {
			console.log("visited: "+$visited)
			sessionStorage.setItem("visited", 1);
			$('#firstDiv').css('display','block');
			$('#mainContainer').css('opacity','0');
		}
	}
}

function showNewArticleModal(){
	$("#newArticleSection").css('display','block');

}
