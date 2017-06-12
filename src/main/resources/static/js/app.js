/**
 * Created Dursun Cimen 2017
 */

$(document)
		.ready(
				function() {

					var url ="http://"+$(location).attr('host')+"/clearsettleclient";
					$(function() {
						$('.dark-modal').modal({
							dismissible : false,
							opacity : 1,
							inDuration : 300,
							outDuration : 200,
							startingTop : '4%',
							endingTop : '10%',
						});
						
						$('.custom-modal').modal({
							dismissible : true,
							opacity : .5,
							inDuration : 300,
							outDuration : 200,
							startingTop : '4%',
							endingTop : '10%',
						});
						$('.datepicker').pickadate({
							selectMonths : true,
							selectYears : 17,
							format: 'yyyy-mm-dd' 
						});
						
						$('select').material_select();
						 
						$('.trigger-modal').modal();

						if (!checkIdendification()) {
							$('#loginUserModal').modal('open');
						} else {

						}

					});

					function setCookie(ckey, cvalue) {
						var d = new Date();
						d.setTime(d.getTime() + (10 * 60 * 1000));
						var expires = "expires=" + d.toGMTString();
						document.cookie = ckey + "=" + cvalue + ";" + expires
								+ ";path=/";
					}

					function getCookie(ckey) {
						var cvalue = ckey + "=";
						var decodedCookie = decodeURIComponent(document.cookie);
						var ca = decodedCookie.split(';');
						for (var i = 0; i < ca.length; i++) {
							var c = ca[i];
							while (c.charAt(0) == ' ') {
								c = c.substring(1);
							}
							if (c.indexOf(cvalue) == 0) {
								return c.substring(cvalue.length, c.length);
							}
						}
						return "";
					}

					function checkIdendification() {
						var token = getCookie("token");
						return (token != "" && token != "undefined");
					}
					
					function searchTraction(formData ){
						var settings = {
								"async" : true,
								"crossDomain" : true,
								"url" : url + "/api/transaction/list",
								"method" : "POST",
								"headers" : {
									"cache-control" : "no-cache",
									"token" : getCookie("token")
								},
								"processData" : false,
								"contentType" : false,
								"mimeType" : "multipart/form-data",
								"data" : formData
							}

							$.ajax(settings).done(function(response) {
												var response = JSON.parse(response);
												$(".table-body").empty();												
												$.each(response.data,function(i, transaction) {
															$(".table-body")
																	.append(
																			"<tr data-transactionId=\""
																					+  transaction.transaction.merchant.transactionId
																					+ "\"  >"
																					+ "<td>"
																					+ "<a class='details-transaction' href='#'>"+ transaction.transaction.merchant.transactionId+"</a>"
																					+ "</td>"
																					+ "<td>"
																					+( transaction.merchant != null ?  ("<a class='details-merchant' href='#'>"+ transaction.merchant.name +"</a>") : "")
																					+ "</td>"
																					+ "<td>"
																					+ "Details"
																					+ "</td>" 
																					+ "<td>"
																					+ (transaction.acquirer != null ? transaction.acquirer.name : "")
																					+ "</td>"
																					+ "<td>"
																					+ (transaction.customerInfo != null ? ("<a class='details-customer' href='#'>"+ transaction.customerInfo.billingFirstName +" "+ transaction.customerInfo.billingLastName +"</a>") : "")
																					+ "</td>"
																					+ "<td>"
																					+ transaction.created_at
																					+ "</td>"
																					+ "<td>"
																					+ transaction.updated_at
																					+ "</td>"
																					+ "</tr>");
														});
												
												if(response.prev_page_url !== "" && response.prev_page_url !== null ){
													$(".table-foot")
													.append("<a class='btn waves-effect waves-light prev-page' href='#'  >Prev"
															+"<i class='material-icons left'>skip_previous</i>"+
												            +"</a>");											        
													
												}
												if(response.next_page_url !== "" && response.next_page_url !== null ){
													$(".table-foot")
													.append("<a class='btn waves-effect waves-light right-align next-page' href='#'  >Next"
															+"<i class='material-icons right'>skip_next</i>"+
												            +"</a>");											        
													
												}
												closePreloaderForProgress();
												Materialize.toast('Successful Search!',4000);
											})
							.error(function(response) {
												console.log(response);
												if ( response.status == 406)
													Materialize.toast('Failed Search! ',4000);
												else
													Materialize.toast('Failed Search! Plese try again another time',4000);
												closePreloaderForProgress();
											});
						
					}
					
					function getTraction(formData ){
						var settings = {
								"async" : true,
								"crossDomain" : true,
								"url" : url + "/api/transaction/get",
								"method" : "POST",
								"headers" : {
									"cache-control" : "no-cache",
									"token" : getCookie("token")
								},
								"processData" : false,
								"contentType" : false,
								"mimeType" : "multipart/form-data",
								"data" : formData
							}

							$.ajax(settings).done(function(response) {
												var response = JSON.parse(response);	
												closePreloaderForProgress();
												Materialize.toast('Successful Get Transaction!',4000);
												$('#customModal .modal-head').empty();
												$('#customModal .row').empty();
												$('#customModal .modal-head').text("Transaction Details");
												
												if(response.customerInfo != null)
												$('#customModal .row').append("<div class='col s3'>"
														+"<h5>Customer Info</h5>"
														+"<div><span class=' red-text'>Id</span>: "+response.customerInfo.id+"</div>"
														+"<div><span class=' red-text'>Number</span>: "+response.customerInfo.number+"</div>"
														+"<div><span class=' red-text'>E-mail</span>: "+response.customerInfo.email+"</div>"
														+"<div><span class=' red-text'>Birthday</span>: "+response.customerInfo.birthday+"</div>"
														+"<div><span class=' red-text'>Billing FirstName</span>: "+response.customerInfo.billingFirstName+"</div>"
														+"<div><span class=' red-text'>Billing LastName</span>: "+response.customerInfo.billingLastName+"</div>"
														+"<div><span class=' red-text'>Billing Company</span>: "+response.customerInfo.billingCompany+"</div>"
														+"<div><span class=' red-text'>Billing Address1 </span>: "+response.customerInfo.billingAddress1+"</div>"
														+"<div><span class=' red-text'>Billing City </span>: "+response.customerInfo.billingCity+"</div>"
														+"<div><span class=' red-text'>Billing Postcode </span>: "+response.customerInfo.billingPostcode+"</div>"
														+"<div><span class=' red-text'>Billing Country </span>: "+response.customerInfo.billingCountry+"</div>"
														+"<div><span class=' red-text'>Billing Phone </span>: "+response.customerInfo.billingPhone+"</div>"
														+"<div><span class=' red-text'>Created Date</span>: "+response.customerInfo.created_at+"</div>"
														+"<div><span class=' red-text'>Updated Date</span>: "+response.customerInfo.updated_at+"</div>"														
												+"</div>"
												);
												if(response.fx != null)
												$('#customModal .row').append("<div class='col s3'>"
														+"<h5>FX</h5>"
														+"<div><span class=' red-text'>Original Currency</span>: "+response.fx.merchant.originalCurrency+"</div>"
														+"<div><span class=' red-text'>Original Amount</span>: "+response.fx.merchant.originalAmount+"</div>"
														+"<div><span class=' red-text'>Converted Currency</span>: "+response.fx.merchant.convertedCurrency+"</div>"
														+"<div><span class=' red-text'>Converted Amount</span>: "+response.fx.merchant.convertedAmount+"</div>"
												+"</div>"
												);
												if(response.transaction != null)
												$('#customModal .row').append("<div class='col s3'>"
														+"<h5>Transaction Merchant</h5>"
														+"<div><span class=' red-text'>Id</span>: "+response.transaction.merchant.id+"</div>"
														+"<div><span class=' red-text'>Parent Id</span>: "+response.transaction.merchant.parentId+"</div>"
														+"<div><span class=' red-text'>Name</span>: "+response.transaction.merchant.name+"</div>"
														+"<div><span class=' red-text'>Mcc</span>: "+response.transaction.merchant.mcc+"</div>"
														+"<div><span class=' red-text'>Ipn Url</span>: "+response.transaction.merchant.ipnUrl+"</div>"
														+"<div><span class=' red-text'>Api Key</span>: "+response.transaction.merchant.apiKey+"</div>"
														+"<div><span class=' red-text'>Cpg Key </span>: "+response.transaction.merchant.cpgKey+"</div>"
														+"<div><span class=' red-text'>Type</span>: "+response.transaction.merchant.type+"</div>"
														+"<div><span class=' red-text'>Descriptor</span>: "+response.transaction.merchant.descriptor+"</div>"
														+"<div><span class=' red-text'>Secret Key</span>: "+response.transaction.merchant.secretKey+"</div>"
														+"<div><span class=' red-text'>Com Type</span>: "+response.transaction.merchant.comType+"</div>"													
												+"</div>"
												);
												if(response.merchant != null)
												$('#customModal .row').append("<div class='col s3'>"
														+"<h5>Merchant</h5>"
														+"<div><span class=' red-text'>Id</span>: "+response.merchant.id+"</div>"
														+"<div><span class=' red-text'>Parent Id</span>: "+response.merchant.parentId+"</div>"
														+"<div><span class=' red-text'>Name</span>: "+response.merchant.name+"</div>"
														+"<div><span class=' red-text'>Mcc</span>: "+response.merchant.mcc+"</div>"
														+"<div><span class=' red-text'>Ipn Url</span>: "+response.merchant.ipnUrl+"</div>"
														+"<div><span class=' red-text'>Api Key</span>: "+response.merchant.apiKey+"</div>"
														+"<div><span class=' red-text'>Cpg Key </span>: "+response.merchant.cpgKey+"</div>"
														+"<div><span class=' red-text'>Type</span>: "+response.merchant.type+"</div>"
														+"<div><span class=' red-text'>Descriptor</span>: "+response.merchant.descriptor+"</div>"
														+"<div><span class=' red-text'>Secret Key</span>: "+response.merchant.secretKey+"</div>"
														+"<div><span class=' red-text'>Com Type</span>: "+response.merchant.comType+"</div>"													
												+"</div>"
												);
												
												$('#customModal').modal('open');
											})
							.error(function(response) {
												console.log(response);
												if ( response.status == 406)
													Materialize.toast('Failed Get Transaction! ',4000);
												else
													Materialize.toast('Failed Get Transaction! Plese try again another time',4000);
												closePreloaderForProgress();
											});
					}
					
					function getMerchant(formData ){
						var settings = {
								"async" : true,
								"crossDomain" : true,
								"url" : url + "/api/merchant/get",
								"method" : "POST",
								"headers" : {
									"cache-control" : "no-cache",
									"token" : getCookie("token")
								},
								"processData" : false,
								"contentType" : false,
								"mimeType" : "multipart/form-data",
								"data" : formData
							}

							$.ajax(settings).done(function(response) {
												var response = JSON.parse(response);	
												closePreloaderForProgress();
												Materialize.toast('Successful Get Merchant!',4000);
												$('#customModal .modal-head').empty();
												$('#customModal .row').empty();
												$('#customModal .modal-head').text("Merchant Details");												
											
												if(response != null)
												$('#customModal .row').append("<div class='col s3'>"
														+"<h4>Merchant</h4>"
														+"<div><span class=' red-text'>Id</span>: "+response.merchant.id+"</div>"
														+"<div><span class=' red-text'>Parent Id</span>: "+response.merchant.parentId+"</div>"
														+"<div><span class=' red-text'>Name</span>: "+response.merchant.name+"</div>"
														+"<div><span class=' red-text'>Mcc</span>: "+response.merchant.mcc+"</div>"
														+"<div><span class=' red-text'>Ipn Url</span>: "+response.merchant.ipnUrl+"</div>"
														+"<div><span class=' red-text'>Api Key</span>: "+response.merchant.apiKey+"</div>"
														+"<div><span class=' red-text'>Cpg Key </span>: "+response.merchant.cpgKey+"</div>"
														+"<div><span class=' red-text'>Type</span>: "+response.merchant.type+"</div>"
														+"<div><span class=' red-text'>Descriptor</span>: "+response.merchant.descriptor+"</div>"
														+"<div><span class=' red-text'>Secret Key</span>: "+response.merchant.secretKey+"</div>"
														+"<div><span class=' red-text'>Com Type</span>: "+response.merchant.comType+"</div>"													
												+"</div>"
												);
												
												$('#customModal').modal('open');
											})
							.error(function(response) {
												console.log(response);
												if ( response.status == 406)
													Materialize.toast('Failed Get Merchant! ',4000);
												else
													Materialize.toast('Failed Get Merchant! Plese try again another time',4000);
												closePreloaderForProgress();
											});
					}
					
					function getCustomerInfo(formData ){
						var settings = {
								"async" : true,
								"crossDomain" : true,
								"url" : url + "/api/customer/get",
								"method" : "POST",
								"headers" : {
									"cache-control" : "no-cache",
									"token" : getCookie("token")
								},
								"processData" : false,
								"contentType" : false,
								"mimeType" : "multipart/form-data",
								"data" : formData
							}

							$.ajax(settings).done(function(response) {
												var response = JSON.parse(response);	
												closePreloaderForProgress();
												Materialize.toast('Successful Get Customer!',4000);
												$('#customModal .modal-head').empty();
												$('#customModal .row').empty();
												$('#customModal .modal-head').text("Customer Details");												
											
												if(response != null)
													$('#customModal .row').append("<div class='col s3'>"
															+"<h4>Customer Info</h4>"
															+"<div><span class=' red-text'>Id</span>: "+response.customerInfo.id+"</div>"
															+"<div><span class=' red-text'>Number</span>: "+response.customerInfo.number+"</div>"
															+"<div><span class=' red-text'>E-mail</span>: "+response.customerInfo.email+"</div>"
															+"<div><span class=' red-text'>Birthday</span>: "+response.customerInfo.birthday+"</div>"
															+"<div><span class=' red-text'>Billing FirstName</span>: "+response.customerInfo.billingFirstName+"</div>"
															+"<div><span class=' red-text'>Billing LastName</span>: "+response.customerInfo.billingLastName+"</div>"
															+"<div><span class=' red-text'>Billing Company</span>: "+response.customerInfo.billingCompany+"</div>"
															+"<div><span class=' red-text'>Billing Address1 </span>: "+response.customerInfo.billingAddress1+"</div>"
															+"<div><span class=' red-text'>Billing City </span>: "+response.customerInfo.billingCity+"</div>"
															+"<div><span class=' red-text'>Billing Postcode </span>: "+response.customerInfo.billingPostcode+"</div>"
															+"<div><span class=' red-text'>Billing Country </span>: "+response.customerInfo.billingCountry+"</div>"
															+"<div><span class=' red-text'>Billing Phone </span>: "+response.customerInfo.billingPhone+"</div>"
															+"<div><span class=' red-text'>Created Date</span>: "+response.customerInfo.created_at+"</div>"
															+"<div><span class=' red-text'>Updated Date</span>: "+response.customerInfo.updated_at+"</div>"														
													+"</div>"
												);
												
												$('#customModal').modal('open');
											})
							.error(function(response) {
												console.log(response);
												if ( response.status == 406)
													Materialize.toast('Failed Get Customer! ',4000);
												else
													Materialize.toast('Failed Get Customer! Plese try again another time',4000);
												closePreloaderForProgress();
											});
					}
					
					$(document).on('click',"a.details-transaction",function() {
						var formData = new FormData();
						formData.append("transactionId", $(this).closest('tr').attr('data-transactionid'));
						getTraction(formData);
					});
					
					$(document).on('click',"a.details-merchant",function() {
						var formData = new FormData();
						formData.append("transactionId", $(this).closest('tr').attr('data-transactionid'));
						getMerchant(formData);
					});
					
					$(document).on('click',"a.details-customer",function() {
						var formData = new FormData();
						formData.append("transactionId", $(this).closest('tr').attr('data-transactionid'));
						getCustomerInfo(formData);
					});
					
					$("#loginForm").submit(	function(event) {
										event.preventDefault();
										$('#loginUserModal').modal('close');
										openPreloaderForProgress();
										var userData = new FormData();
										userData.append("email", $("#email").val());
										userData.append("password", $("#password").val());
										var settings = {
											"async" : true,
											"crossDomain" : true,
											"url" : url + "/api/login",
											"method" : "POST",
											"headers" : {
												"cache-control" : "no-cache"
											},
											"processData" : false,
											"contentType" : false,
											"mimeType" : "multipart/form-data",
											"data" : userData
										}

										$.ajax(settings).done(function(response) {
															var response = JSON.parse(response);
															Materialize.toast('Successful Login!',4000);
															setCookie("token",response.token);
															closePreloaderForProgress();
														});
										$.ajax(settings).error(function(response) {
															console.log(response);
															if (response.status == 401 || response.status == 406)
																Materialize.toast('Failed Login! Invalid username or password ',4000);
															else
																Materialize.toast('Failed Login! Plese try again another time',4000);
															closePreloaderForProgress();
															$('#loginUserModal').modal('open');
														});
									}); 
					
					
					$("#transacton-query").submit(function(event) {
								event.preventDefault();
								openPreloaderForProgress();
								var formData = new FormData();
								if($("#transaction-from-date").val() !=="")
									formData.append("fromDate", $("#transaction-from-date").val());
								if($("#trancation-to-date").val() !=="")
									formData.append("toDate", $("#trancation-to-date").val())
								if($("#transaction-status").val() !=="" &&  $("#transaction-status").val() !== null)
									formData.append("status", $("#transaction-status").val());
								if($("#transaction-operation").val() !=="" &&  $("#transaction-operation").val() !== null)
									formData.append("operation", $("#transaction-operation").val());
								if($("#transaction-merchant-id").val() !=="")
									formData.append("merchantId", $("#transaction-merchant-id").val());
								if($("#transaction-acquirer-id").val() !=="")
									formData.append("acquirerId", $("#transaction-acquirer-id").val());
								if($("#transaction-payment-method").val() !=="" &&  $("#transaction-payment-method").val() !== null)
									formData.append("paymentMethod", $("#transaction-payment-method").val());
								if($("#transaction-error-code").val() !==""  &&  $("#transaction-error-code").val() !== null)
									formData.append("errorCode", $("#transaction-error-code").val());
								if($("#transaction-filter-field").val() !==""  &&  $("#transaction-filter-field").val() !== null)
									formData.append("filterField", $("#transaction-filter-field").val());
								if($("#transaction-filter-value").val() !=="")
									formData.append("filterValue", $("#transaction-filter-value").val());	
								var a = formData;
								searchTraction(formData);
								
							});

					function openPreloaderForProgress() {
						$('body')
								.append(
										'<div class=\"modal-overlay\" style=\"z-index: 1002; display: block; opacity: 0.7;\"></div>');
						$('body')
								.append(
										'<div class=\"progress-message\"><h1>Please Wait!</h1></div>');
						$('body')
								.append(
										'<div class=\"progress\"><div class=\"indeterminate\"></div></div>');
					}

					function closePreloaderForProgress() {
						$(".modal-overlay").remove();
						$(".progress-message").remove();
						$(".progress").remove();
					}

				})