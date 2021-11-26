<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content">
        <div class="admin-page-head">
            <h1>Administrator page</h1>
            <br/>
            <h3>All news:</h3>
        </div>
        <div class="last-news" style="max-width: 800px;">
            <c:forEach var="news" items="${allNews}">
                <div class="news-head">
                    <form action="Controller" method="post">
                        <input type="hidden" name="newsId" value="${news.id}">
                        <input type="hidden" name="command" value="GO_TO_NEWS_FROM_ID">
                        <button type="submit" class="btn btn-link" style="text-decoration-line: none;
                            font-size: 19px">${news.title}</button>
                    </form>
                    <div>
                        <c:out value="${news.briefDescription}"/>
                    </div>
                </div>
                <hr/>
                <div class="news-foot-admin">
                    <div class="d-flex">
                        <div class="foot-button-grp">
                            <form class="d-flex" action="Controller" method="get">
                                <input type="hidden" name="command" value="GO_TO_COMMENTS_PAGE">
                                <input type="hidden" name="newsId" value="${news.id}">
                                <button type="submit" class="btn btn-secondary btn-sm">Comments</button>
                            </form>
                            <c:if test="${userRole == 'ADMIN'}">
                                <form action="Controller" method="get">
                                    <input type="hidden" name="command" value="GO_TO_UPDATE_NEWS">
                                    <input type="hidden" name="newsId" value="${news.id}">
                                    <button type="submit" class="btn btn-secondary btn-sm">Update</button>
                                </form>
                                <form action="Controller" method="get">
                                    <input type="hidden" name="command" value="DELETE_NEWS">
                                    <input type="hidden" name="newsId" value="${news.id}">
                                    <button type="submit" class="btn btn-secondary btn-sm">Delete</button>
                                </form>
                                <form action="Controller" method="get">
                                    <input type="hidden" name="command" value="PUBLISHED_NEWS">
                                    <input type="hidden" name="newsId" value="${news.id}">
                                    <button type="submit" class="btn btn-secondary btn-sm">Publish</button>
                                </form>
                            </c:if>
                        </div>
                        <div class="foot-status-grp">
                            <c:if test="${userRole == 'ADMIN'}">
                                <div style="color: #ff0000">${news.newsStatus}</div>
                            </c:if>
                            <div>${news.dateOfPublication}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>