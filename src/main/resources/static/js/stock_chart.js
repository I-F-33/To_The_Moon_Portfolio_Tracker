	
	 var jsonBom = $('#stock-asset').val();
console.log(jsonBom);






	console.log(stockSymbol);
	
	async function getData() {
	var stockSymbol = document.getElementById("stock-asset");
	let response = await fetch("/fetchDailyData/stock/"+stockSymbol);
    let stockData = await response.json();  
    console.log(stockData);
}