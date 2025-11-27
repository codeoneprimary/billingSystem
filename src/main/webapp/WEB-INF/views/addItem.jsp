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
	<!-- Overlay For Sidebars -->
	<div class="overlay"></div>
	<!-- #END# Overlay For Sidebars -->
	<!-- Search Bar -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="START TYPING...">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #END# Search Bar -->

	<%@ include file="header.jsp"%>

	<%@ include file="menu.jsp"%>

	<section class="content">
		<div class="container-fluid">

			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">

							<div class="header">
								<h2>Item</h2>
							</div>
							<div class="row clearfix">
								<div class="col-md-2">
									<p>
										<b>Code</b>
									</p>
									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username">
									</div>
								</div>
								<div class="col-md-3">
									<p>
										<b>Item Category</b>
									</p>
									<select class="form-control show-tick" data-live-search="true">
										<option>Hot Dog, Fries and a Soda</option>
										<option>Burger, Shake and a Smile</option>
										<option>Sugar, Spice and all things nice</option>
									</select>

								</div>
								<div class="col-md-3">
									<p>
										<b>Item Name</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username">
									</div>

								</div>
								<div class="col-md-3">
									<p>
										<b>GST Category</b>
									</p>

									<select class="form-control show-tick" data-live-search="true">
										<option>Hot Dog, Fries and a Soda</option>
										<option>Burger, Shake and a Smile</option>
										<option>Sugar, Spice and all things nice</option>
									</select>

								</div>
								<div class="col-md-2">
									<p>
										<b>Price</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username">
									</div>
								</div>
								<div class="col-md-2">
									<p>
										<b>current stock</b>
									</p>

									<div class="form-line">
										<input type="text" class="form-control date"
											placeholder="Username">
									</div>
								</div>

								<div class="col-md-2" style="text-align: center;">
									<p>
										<b>.</b>
									</p>
									<button class="btn btn-primary waves-effect" type="submit">SUBMIT</button>
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
									class="table table-bordered table-striped table-hover dataTable js-exportable">
									<thead>
										<tr>
											<th>Code</th>
											<th>Category</th>
											<th>Name</th>
											<th>GST Category</th>
											<th>Price</th>
											<th>Stock</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Name</th>
											<th>Position</th>
											<th>Office</th>
											<th>Age</th>
											<th>Start date</th>
											<th>Salary</th>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<td>Tiger Nixon</td>
											<td>System Architect</td>
											<td>Edinburgh</td>
											<td>61</td>
											<td>2011/04/25</td>
											<td>$320,800</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- #END# Exportable Table -->
		</div>
	</section>

	<%@ include file="footer.jsp"%>
</body>

</html>