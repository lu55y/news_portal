<jsp:include page="header.jsp"/>
	
	<!-- Registration form -->
	<form class="row g-3">
  		<div class="col-md-6">
    		<label for="inputEmail4" class="form-label">Email</label>
    		<input type="email" class="form-control" id="inputEmail4">
 		</div>
  		<div class="col-md-6">
    		<label for="inputPassword4" class="form-label">Password</label>
    		<input type="password" class="form-control" id="inputPassword4">
  		</div>
  		<div class="col-12">
    		<label for="inputAddress" class="form-label">Address</label>
    		<input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  		</div>
  		<div class="col-md-6">
    		<label for="inputCity" class="form-label">City</label>
    		<input type="text" class="form-control" id="inputCity">
  		</div>
  		<div class="col-12">
    		<button type="submit" class="btn btn-primary">Sign in</button>
  		</div>
	</form>

<jsp:include page="footer.jsp"/>