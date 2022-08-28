
	getCryptoList();
	getStockList();
	
	// Catagory elements

const catagoryBtn = document.getElementById("dropdown-button");
const stockCatagory = document.getElementById("stock-category");
const cryptoCatagory = document.getElementById("crypto-category");
const dropdownDiv = document.getElementById("dropdown");
//Event listeners for catagorys

// Changes main dropdown button text and makes dropdown menu hidden again
stockCatagory.addEventListener("click", () => {
  catagoryBtn.textContent = "Stock";
  dropdownDiv.classList.add("hidden");
  dropdownDiv.classList.remove("block");
});
// Changes main dropdown button text and makes dropdown menu hidden again
cryptoCatagory.addEventListener("click", () => {
  catagoryBtn.textContent = "Crypto";
  dropdownDiv.classList.add("hidden");
  dropdownDiv.classList.remove("block");
});
	
	
	
async function getCryptoList() {
	var cryptoList = [];
	var cryptoNames =[];
	
	let response = await fetch(`/getCryptoList`)
	let cryptoResponse = await response.json();
	
	cryptoList.push(cryptoResponse);
	console.log(cryptoList);
}
	
async function getStockList() {
   try{ 
	var stockList = [];
	var stockNames = [];
    let response = await fetch(`/getStockList`);
    let jsonResponse = await response.json();  
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