<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content">
        <div class="page-head">
            <form class="auth-form" action="Controller" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                          required aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required
                           id="exampleInputPassword1">
                </div>
                <button type="submit" name="command" value="LOG_IN" class="btn btn-primary btn-sm">Submit</button>
                <a href="Controller?command=GO_TO_REGISTRATION_PAGE" class="btn btn-secondary btn-sm" tabindex="-1"
                   role="button">Registration</a>
            </form>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
