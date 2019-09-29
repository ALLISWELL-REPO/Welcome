function getTransactionDetails() {
	var httpRequest = null;
	if (window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var cardNum = document.getElementById("cardNum").value;
	var cvv = document.getElementById("cvv").value;
	var nameOnCard = document.getElementById("nameOnCard").value;
	alert(nameOnCard);
	
	httpRequest.open("POST", "./StatementServiceServlet", true);
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			 alert(httpRequest.responseText);
			var response = JSON.parse(httpRequest.responseText);
			console.log(response);
			if (response.responseCode == "0000") {
				var table = "";
				table = table
						+ "<table border='1'><tr bgcolor='yellow'><th>TransID</th><th>Date</th><th>Merchantname</th><th>Desc</th><th>Amount</th><th>Status</th><th>Remarks</th></tr>";
				for (var i = 0; i < response.transactions.length; i++) {
					if (i % 2 == 0) {
						table = table + "<tr style='background-color:yellow'>";
					} else {
						table = table + "<tr style='background-color:orange'>"
					}
					table = table + "<td>" + response.transactions[i].transid
							+ "</td>";
					table = table + "<td>" + response.transactions[i].date
							+ "</td>";
					table = table + "<td>"
							+ response.transactions[i].merchantname + "</td>";
					table = table + "<td>" + response.transactions[i].desc
							+ "</td>";
					table = table + "<td>" + response.transactions[i].amount
							+ "</td>";
					table = table + "<td>" + response.transactions[i].status
							+ "</td>";
					table = table + "<td>" + response.transactions[i].remarks
							+ "</td>";
				}
				table = table + "</table>";
				document.getElementById("trans").innerHTML = table;
			} else {
				document.getElementById("trans").innerHTML = "Sorry No Record Found";

			}
		} else {
			// alert("please wait request processing")
		}
	}
	httpRequest.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	httpRequest.send("cardNum=" + cardNum + "&cvv=" + cvv + "&NameOnCard="
			+ nameOnCard);
	return false;
}