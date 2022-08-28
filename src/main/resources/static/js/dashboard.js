
// Catagory elements
const categoryBtn = document.getElementById("dropdown-button");
const stockCategory = document.getElementById("stock-category");
const cryptoCategory = document.getElementById("crypto-category");
const dropdownDiv = document.getElementById("dropdown");
const searchInput = document.getElementById("search-dropdown").innerText;
const searchBtn = document.getElementById("search");



//Event listeners for categorys
// Changes main dropdown button text and makes dropdown menu hidden again
stockCategory.addEventListener("click", () => {
  categoryBtn.textContent = "Stock";
  dropdownDiv.classList.add("hidden");
  dropdownDiv.classList.remove("block");
});
// Changes main dropdown button text and makes dropdown menu hidden again
cryptoCategory.addEventListener("click", () => {
  categoryBtn.textContent = "Crypto";
  dropdownDiv.classList.add("hidden");
  dropdownDiv.classList.remove("block");
});
	
//posts to search mapping returns table of matching assests
searchBtn.addEventListener("click", () =>{
	let search = {
		searchString : searchInput,
		searchType : categoryBtn.textContent
	}
	fetch("/dashboard/results", {
    		method: "POST",
    		headers: {
    			"Content-Type": "application/json"
    		},
    		body: JSON.stringify(search)
    	})
			.then(response => response.json())
			.then(jsonResponse => console.log(jsonResponse));
	
})
