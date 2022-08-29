
// Catagory elements
const categoryBtn = document.getElementById("dropdown-button");
const stockCategory = document.getElementById("stock-category");
const cryptoCategory = document.getElementById("crypto-category");
const dropdownDiv = document.getElementById("dropdown");
const searchInput = document.getElementById("search-dropdown").innerText;
const searchBtn = document.getElementById("search");

	
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
