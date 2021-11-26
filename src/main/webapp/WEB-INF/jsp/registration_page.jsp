<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content">
        <div class="page-head">
            <h2>Registration page</h2>
        </div>
        <div class="card">
            <!-- Card header -->
            <div class="card-header">
                <h3 class="mb-0">Registration form:</h3>
            </div>
            <!-- Card body -->
            <div class="card-body">
                <hr class="my-5">
                <div>
                    <h4 class="mb-0">Enter your personal information.</h4>
                    <!-- Form -->
                    <form class="row" action="Controller" method="post">
                        <!-- First name -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="fname">First Name</label>
                            <input type="text" id="fname" class="form-control" placeholder="First Name" name="name"
                                   required="">
                        </div>
                        <!-- Last name -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="lname">Last Name</label>
                            <input type="text" id="lname" class="form-control" placeholder="Last Name" name="surname"
                                   required="">
                        </div>
                        <!-- Email -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="email">Email</label>
                            <input type="email" id="email" class="form-control" placeholder="@email.com" required=""
                                   name="email">
                        </div>
                        <!-- Password -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="password">Password</label>
                            <input class="form-control" id="password" type="text" placeholder="password" name="password"
                                   required="" aria-label="dateReg">
                        </div>
                        <div class="col-12">
                            <!-- Buttons -->
                            <button class="btn btn-primary" type="submit" name="command" value="REGISTER_NEW_USER">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
