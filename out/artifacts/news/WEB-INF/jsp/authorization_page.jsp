<jsp:include page="header.jsp"/>
	
	<!-- Authorization form -->
	<form>
		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Email address</label>
    		<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    		<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputPassword1" class="form-label">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword1">
  		</div>
  		<button type="submit" class="btn btn-primary">Submit</button>
  		<a href="/jsp/regPage" class="btn btn-secondary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true">Registration</a>
	</form>

<jsp:include page="footer.jsp"/>