window.onload = rotate;

var thisAd = 0;

function rotate() {
	var adImages = new Array("/images/ad-image-one.jpg", "/images/ad-image-two.jpg", "/images/ad-image-three.jpg", "/images/ad-image-four.jpg");
	
	thisAd++;
	
	if(thisAd == adImages.length) {
		thisAd = 0;
	}
	document.getElementById("cycling-banner").src = adImages[thisAd];
	
	setTimeout(rotate, 4 * 1000)
	
}