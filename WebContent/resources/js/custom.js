$(document).ready(function(){
	displayFirstDiv();
});

$(window).scroll(function(){

	fadeAway();
});

//Custom Functions

function menuToggle($name) {
	var x = document.getElementById($name);
	if (x.className.indexOf("w3-show") == -1) {
		x.className += " w3-show";
	} else { 
		x.className = x.className.replace(" w3-show", "");
	}
}

function fadeAway(){
	$divBottom=$("#firstDiv").offset().top + $("#firstDiv").outerHeight();
	$scrollBar=$(window).scrollTop();

	if($scrollBar>0){
		//if($scrollBar>($divBottom/4)){

		if($scrollBar>($divBottom-1)){
			$("#firstDiv").hide();
			//$("#header").slideDown(1000);
		}else{
			$("#firstDiv").slideUp(1500);
			//$("#header").slideDown(1000);
		}
		$("#mainContainer").delay(1500).css('opacity', '100');
	}
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
