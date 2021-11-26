<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content" style="display: flex; width: 100%; flex-direction: column;">
        <div class="page-head">
            <h1>Offer news</h1>
            <hr/>
        </div>
        <form action="Controller" method="post" style="margin: 30px;">
            <div class="form-floating" style="margin-bottom: 20px;">
                <textarea class="form-control" id="title" maxlength="200" name="title" required
                        placeholder="Please enter a title" style="height: 100px"></textarea>
                <label for="title" style="color: darkgray">Title</label>
            </div>
            <div class="form-floating" style="margin-bottom: 20px;">
                <textarea class="form-control" id="brief" name="briefDescription" maxlength="300" required
                        placeholder="Please enter a brief description" style="height: 200px"></textarea>
                <label for="brief" style="color: darkgray">Brief Description</label>
            </div>
            <div class="form-floating" style="margin-bottom: 20px;">
                <textarea class="form-control" id="content" name="content" maxlength="3000" required
                        placeholder="Please enter a content" style="height: 400px"></textarea>
                <label for="content" style="color: darkgray">Content</label>
            </div>
            <div class="d-flex justify-content-end" style="margin-right: 20px;margin-bottom: 10px">
                <button type="submit" class="btn btn-secondary btn-sm" name="command" value="ADD_NEWS">Offer news</button>
            </div>
        </form>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>