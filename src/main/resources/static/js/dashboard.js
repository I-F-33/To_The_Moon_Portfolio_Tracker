
	var stocks = getStockList();
	
	autoComplete(stocks);
	
	function autoComplete(stocks) {
		$("#search-navbar").autocomplete({
                source: stocks,
            });
	}
	


 

async function getStockList() {
   try{ 
	var stockList = [];
	var stockNames = [];
    let response = await fetch(`/getStockList`);
    let stockList = await response.json();  
	stockList.push(jsonResponse); 
	 
	console.log(stockList);
	
	for(let i = 0; i < stockList.length; i++) {
		for(let j = 0; j < stockList[0].length; j++){
			stockNames.push(stockList[0][j].name)
		}
	}
	console.log(stockNames);
	return stockNames;
    }
    catch(error) {
        console.log(error)
    }
}