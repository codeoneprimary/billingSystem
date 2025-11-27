<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>SS billing</title>
</head>

<body class="theme-red">
	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-red">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->

	<%@ include file="header.jsp"%>

	<%@ include file="menu.jsp"%>

	<section class="content">
		<div class="container-fluid">

			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">

							<div class="header">
								<h2>Bill</h2>
							</div>
							<div class="row clearfix">
								<div class="col-md-2">
									<p>
										<b>Customer Name</b><span
											style="color: red; font-weight: bold;"> *</span>
									</p>
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username" name="customerName" id="customerName">
									</div>
								</div>
								<div class="col-md-2">
									<p>
										<b>Mobile NO</b><span style="color: red; font-weight: bold;">
											*</span>
									</p>
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username" name="mobileNo" id="mobileNo">
									</div>
								</div>

								<div class="col-md-2">
									<p>
										<b>Email Id</b>
									</p>
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username" name="emailId" id="emailId">
									</div>
								</div>

								<div class="col-md-2">
									<p>
										<b>Address</b>
									</p>
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username" name="address" id="address">
									</div>
								</div>

							</div>


							<div class="row clearfix">

								<div class="col-md-2">
									<p>
										<b>Item</b>
									</p>
									<select class="form-control show-tick" data-live-search="true"
										onchange="itemChanged(this.value)" name="itemId" id="itemId">
										<option value="">-- Select Item --</option>

										<c:forEach var="item" items="${itemList}">
											<option value="${item.itemId}">${item.itemName}</option>
										</c:forEach>
									</select>
									<p id="errormsgAddItem" style="color: red; text-align: right;"></p>
								</div>
								<div class="col-md-2">
									<p>
										<b>Brand</b>
									</p>
									<input type="text" class="form-control date"
										placeholder="itemCode" name="itemCode" id="itemCode"
										style="display: none;">
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Brand" name="itemCompany" id="itemCompany"
											disabled>
									</div>
								</div>


								<div class="col-md-1">
									<p>
										<b>Unit</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Unit" name="itemCompany" name="itemUnit"
											id="itemUnit" disabled>
									</div>
								</div>


								<div class="col-md-1">
									<p>
										<b>A. Stock</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Stock" name="itemStock" id="itemStock" disabled>
									</div>
								</div>

								<div class="col-md-1">
									<p>
										<b>Rate</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Rate" name="itemRate" id="itemRate"
											onkeyup="calculateTotal()"
											onkeypress="return allowDigitDecimal(event)">
									</div>
								</div>
								<div class="col-md-1">
									<p>
										<b>Qty</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date" placeholder="Qty"
											name="itemQuantity" id="itemQuantity"
											onkeyup="calculateTotal()"
											onkeypress="return allowDigitDecimal(event)">
									<p id="errormsgQty" style="color: red; text-align: right;"></p>
									</div>
								</div>

								<div class="col-md-1">
									<p>
										<b>GST</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date" placeholder="GST"
											name="gstRate" id="gstRate" style="display: none;"> <input
											type="text" class="form-control date" placeholder="GST"
											name="gst" id="gst" onkeyup="calculateTotalOnGST()"
											onkeypress="return allowDigitDecimal(event)">
									</div>
								</div>


								<div class="col-md-2">
									<p>
										<b>T. Price</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Price" name="totalPrice" id="totalPrice"
											disabled>
									</div>
								</div>

								<div class="col-md-1" style="text-align: center;">
									<p>
										<b>.</b>
									</p>
									<button class="btn btn-primary waves-effect" type="submit"
										onclick="addRow()">ADD</button>
								</div>
								
							</div>

						</div>
						<div class="header">
							<h2>EXPORTABLE TABLE</h2>
							<ul class="header-dropdown m-r--5">
								<li class="dropdown"><a href="javascript:void(0);"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"> <i
										class="material-icons">more_vert</i>
								</a>
									<ul class="dropdown-menu pull-right">
										<li><a href="javascript:void(0);">Action</a></li>
										<li><a href="javascript:void(0);">Another action</a></li>
										<li><a href="javascript:void(0);">Something else here</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="body">
							<div class="table-responsive">
								<table
									class="table table-bordered table-striped table-hover js-basic-example dataTable"
									id="itemTable">
									<thead>
										<tr>
											<th>Item Id</th>
											<th>Item code</th>
											<th>Name</th>
											<th>Brand Name</th>
											<th>Unit</th>
											<th>Rate</th>
											<th>Qty</th>
											<th>GST</th>
											<th style="width:110px;">Total</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th colspan="6" style="text-align: right">Total:</th>
											<th id="grandQty">0.00</th>
											<th id="grandGST">0.00</th>
											<th id="grandTotalPrice" style="width:110px;">0.00</th>
										</tr>
										<tr>
											<th colspan="6" style="text-align: right">Discount:</th>
											<th></th>
											<th></th>
											<th><input type="text" class="form-control date"
												name="discount" id="discount" style="width:110px;" onkeyup="calculateTotalBillAmount()"></th>
										</tr>
										<tr>
											<th colspan="6" style="text-align: right">Total Bill
												Amount:</th>
											<th></th>
											<th></th>
											<th><input type="text" class="form-control date"
												name="totalBillAmount" id="totalBillAmount" disabled style="width:110px;"></th>
										</tr>
									</tfoot>
									<tbody id="itemTableBody">
									</tbody>
								</table>
							</div>
						</div>

						<div class="body">
							<div class="row clearfix">
								<div class="col-md-10">
									<p id="errorMsg" style="color: red; text-align: right;"></p>
								</div>
								<div class="col-md-2">

									<button class="btn btn-primary btn-lg waves-effect"
										type="submit" onclick="savePurchaseOrder()">Submit</button>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- #END# Exportable Table -->
		</div>
	</section>

	<%@ include file="footer.jsp"%>

	<script>
	
	window.onload = function () {

	    let table = $('#itemTable').DataTable(); 
		 // hide first column
		 table.column(0).visible(false);
	};
		function itemChanged(itemId) {
			let itemList = ${itemListJson};
			let item = itemList.find(u => u.itemId == itemId);
			document.getElementById("itemCode").value = item.itemCode;
			document.getElementById("itemUnit").value = item.itemUnit.unit;
			document.getElementById("itemStock").value = item.itemStock;
			document.getElementById("itemCompany").value = item.itemCompany;
			document.getElementById("itemRate").value = item.itemRate;
			document.getElementById("gstRate").value = item.gst;
		}

		function calculateTotal() {
			let itemStock = parseInt(document.getElementById("itemStock").value);
			let itemQuantity = parseInt(document.getElementById("itemQuantity").value);
			if(!isNaN(itemQuantity)){
				if(itemStock>=itemQuantity){
					 let itemRate = parseInt(document.getElementById("itemRate").value);
					 let totalWithOutGST = itemQuantity*itemRate;
					 let gstRate = parseInt(document.getElementById("gstRate").value);
					 let gstTotal = (totalWithOutGST / 100)* gstRate;
					 gstTotal = parseFloat(gstTotal.toFixed(2));
					 document.getElementById("gst").value = gstTotal;
					 let totalWithGST= totalWithOutGST+gstTotal;
					 document.getElementById("totalPrice").value = totalWithGST;
				 }else {
					 document.getElementById("itemQuantity").value = "";
					 document.getElementById("totalPrice").value = "";
					 document.getElementById("gst").value = "";
				     document.getElementById("errormsgQty").innerHTML = "Stock not enough";
				 }
		  }else{
			  document.getElementById("totalPrice").value = "";
			  document.getElementById("gst").value = "";
		  }
		}

		function calculateTotalOnGST() {
			let itemStock = parseInt(document.getElementById("itemStock").value);
			let itemQuantity = parseInt(document.getElementById("itemQuantity").value);
			if(!isNaN(itemQuantity)){
				if(itemStock>=itemQuantity){
					 let itemRate = parseInt(document.getElementById("itemRate").value);
					 let totalWithOutGST = itemQuantity*itemRate;
					 let gst = parseInt(document.getElementById("gst").value);
					 let gstTotal =0;
					 if(!isNaN(gst)){
						 gstTotal = (totalWithOutGST / 100)* gst;
						 gstTotal = parseFloat(gstTotal.toFixed(2));
					 }
					 let totalWithGST= totalWithOutGST+gstTotal;
					 document.getElementById("totalPrice").value = totalWithGST;
				 }else {
					 document.getElementById("itemQuantity").value = "";
					 document.getElementById("totalPrice").value = "";
					 document.getElementById("gst").value = "";
				     document.getElementById("errormsgQty").innerHTML = "Stock not enough";
				 }
		  }else{
			  document.getElementById("totalPrice").value = "";
			  document.getElementById("gst").value = "";
		  }
		}
		
		function addRow() {
		    let itemCode = document.getElementById("itemCode").value;
		    let itemIdElement = document.getElementById("itemId");
		    let itemId = itemIdElement.value; 
		    let itemName  = itemIdElement.options[itemIdElement.selectedIndex].text; 
		    let itemCompany = document.getElementById("itemCompany").value;
		    let itemUnit = document.getElementById("itemUnit").value;
		    let itemRate = document.getElementById("itemRate").value;
		    let itemQuantity = document.getElementById("itemQuantity").value;
		    let gst = document.getElementById("gst").value;
		    
		    if (itemIdElement.value === "") {
		        document.getElementById("errormsgAddItem").innerHTML = "Please select Item";
		        return false;
		    }

		    if (itemQuantity === "") {
		        document.getElementById("errormsgQty").innerHTML = "Please add Qty";
		        return false;
		    }
		    
		    
		    
		    if(gst==""){
		    	gst=0;
		    }
		    let totalPrice = document.getElementById("totalPrice").value;

		    let table = $('#itemTable').DataTable(); 
		    table.row.add([
		    	itemId,
		    	itemCode,
		    	itemName,
		    	itemCompany,
		    	itemUnit,
		    	itemRate,
		    	itemQuantity,
		    	gst,
		    	totalPrice
		    ]).draw();

			 // hide first column
			 table.column(0).visible(false);
			 calculateTotalBillAmount();
		
		}
		function allowDigitDecimal(e) {
		    let char = e.key;
		    let value = e.target.value;

		    // Allow digits 0-9
		    if (/^[0-9]$/.test(char)) {
		        return true;
		    }

		    // Allow ONE decimal point
		    if (char === "." && !value.includes(".")) {
		        return true;
		    }

		    // Allow control keys (optional)
		    if (["Backspace", "Delete", "ArrowLeft", "ArrowRight", "Tab"].includes(char)) {
		        return true;
		    }

		    // Block all other characters
		    return false;
		}
		
		function calculateTotalBillAmount(){

		    let table = $('#itemTable').DataTable(); 
			 // calculate total
			 let grandTotal = 0;
			 let grandQty = 0;
			 let grandGST = 0;
			 table.rows().every(function () {
			     let row = this.data();
			     grandQty += parseFloat(row[6]) || 0; 
			     grandGST += parseFloat(row[7]) || 0; 
			     grandTotal += parseFloat(row[8]) || 0; 
			 });
			 document.getElementById("grandTotalPrice").innerText = grandTotal.toFixed(2);
			 document.getElementById("grandQty").innerText = grandQty.toFixed(2);
			 document.getElementById("grandGST").innerText = grandGST.toFixed(2);
			 

			 let discount = document.getElementById("discount").value;
			 let totalBillAmount =  Math.round(grandTotal- discount); 

			 document.getElementById("totalBillAmount").value = totalBillAmount;
		}
		function savePurchaseOrder(){
			
			let customerName=document.getElementById("customerName").value;
			let mobileNo=document.getElementById("mobileNo").value;
			let emailId=document.getElementById("emailId").value;
			let address=document.getElementById("address").value;
			
			
			if (customerName === "") {
				document.getElementById("errorMsg").innerHTML = "Customer Name is required";
			    return false;
			}

		    let mobilePattern = /^[0-9]{10}$/;
		    if (!mobilePattern.test(mobileNo)) {
		        document.getElementById("errorMsg").innerHTML = "Enter 10 digit Customer mobile number";
		        return false;
		    }
		    
		    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		    if(emailId!=""){
			    if (!emailPattern.test(emailId)) {
			        document.getElementById("errorMsg").innerHTML = "Enter a valid email";
			        return false;
			    }
		    }
		    if (address === "") {
				document.getElementById("errorMsg").innerHTML = "Customer address is required";
			    return false;
			}
			    			
			
		    let itemDto = [];
			 
		    let table = $('#itemTable').DataTable();
		    let data = table.rows().data();  // all row data

		    for (let i = 0; i < data.length; i++) {
		        let row = data[i];   // row = array [id, name, qty, rate]

		        itemDto.push({
		        	itemId: row[0],
		        	itemCode: row[1],
		        	itemName: row[2],
		        	itemCompany: row[3],
		        	unit: row[4],
		        	itemRate: row[5],
		        	itemQuantity: row[6],
		        	gst: row[7],
		        	totalPrice: row[8]
		        });
		    }
		    
		    const customeDetails = {
		    		customerName: customerName,
		    		mobileNo: mobileNo,
		    		emailId: emailId,
		    		address: address,
		    		discount: document.getElementById("discount").value,
		    		totalBillAmount: document.getElementById("totalBillAmount").value
		        };
		    const requestData = {
		            ...customeDetails,
		            itemDto: itemDto
		        };
		    fetch("http://localhost:8089/billingSystem/api/purchaseorders", {
		        method: "POST",
		        headers: { "Content-Type": "application/json" },
		        body: JSON.stringify(requestData)
		    })
		    .then(res => res.json())
		    .then(data => {
		        console.log("Response:", data);
		        alert("Purchase Order Saved!");
		    })
		    .catch(err => console.error(err));
		    
		}
	</script>
</body>

</html>