<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content">
        <div class="page-head">
            <h2>Your profile</h2>
        </div>
        <div class="card">
            <!-- Card header -->
            <div class="card-header">
                <h3 class="mb-0">Profile Details</h3>
                <p class="mb-0">
                    You have full control to manage your own account setting.
                </p>
            </div>
            <!-- Card body -->
            <div class="card-body">
                <hr class="my-5">
                <div>
                    <h4 class="mb-0">Personal Details</h4>
                    <p class="mb-4">
                        Edit your personal information.
                    </p>
                    <!-- Form -->
                    <form class="row" action="Controller" method="post">
                        <!-- First name -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="fname">First Name</label>
                            <input type="text" id="fname" class="form-control" placeholder="First Name" name="name" value="${user.name}" required="">
                        </div>
                        <!-- Last name -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="lname">Last Name</label>
                            <input type="text" id="lname" class="form-control" placeholder="Last Name" name="surname" value="${user.surname}" required="">
                        </div>
                        <!-- Email -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="email">Email</label>
                            <input type="email" id="email" class="form-control" placeholder="@email" required="" name="email" value="${user.email}">
                        </div>
                        <!-- Date of registration -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="dateReg">Date of registration</label>
                            <input class="form-control" id="dateReg" type="text" name="dateOfRegistration" value="${user.dateOfRegistration}" aria-label="dateReg"
                                   disabled="" readonly="">
                        </div>
                        <!-- Password -->
                        <div class="mb-3 col-12 col-md-6">
                            <label class="form-label" for="password">Password</label>
                            <input class="form-control" id="password" type="text" placeholder="password" name="password" value="${user.password}" required="" aria-label="dateReg">
                        </div>
                        <div class="col-12">
                            <!-- Buttons -->
                            <input type="hidden" >
                            <button class="btn btn-primary" type="submit" name="command" value="UPDATE_USER_PROFILE">Update Profile</button>
                            <a class="btn btn-primary" role="button" href="Controller?command=DELETE_USER">Delete Profile</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
