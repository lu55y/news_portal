<%--@elvariable id="selectedNews" type="by.it.academy.bean.News"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="content">
        <div class="page-head">
            <h1>Hello Page on News Portal</h1>
            <br/>
        </div>
        <div class="last-news">
            <h2>${selectedNews.title}</h2>
            <hr/>
            <div class="news-head">
                <p>${selectedNews.content}</p>
            </div>
            <hr/>
            <div class="news-foot-admin">
                <div class="d-flex">
                    <div class="foot-button-grp">
                        <form class="d-flex" action="Controller" method="get">
                            <input type="hidden" name="command" value="GO_TO_COMMENTS_NEWS">
                            <input type="hidden" name="newsId" value="${selectedNews.id}">
                            <button type="submit" class="btn btn-secondary btn-sm">Comments</button>
                        </form>
                        <c:if test="${userRole == 'ADMIN'}">
                            <form action="Controller" method="get">
                                <input type="hidden" name="command" value="GO_TO_UPDATE_NEWS">
                                <input type="hidden" name="newsId" value="${selectedNews.id}">
                                <button type="submit" class="btn btn-secondary btn-sm">Update</button>
                            </form>
                            <form action="Controller" method="get">
                                <input type="hidden" name="command" value="DELETE_NEWS">
                                <input type="hidden" name="newsId" value="${selectedNews.id}">
                                <button type="submit" class="btn btn-secondary btn-sm">Delete</button>
                            </form>
                            <form action="Controller" method="get">
                                <input type="hidden" name="command" value="PUBLISHED_NEWS">
                                <input type="hidden" name="newsId" value="${selectedNews.id}">
                                <button type="submit" class="btn btn-secondary btn-sm">Publish</button>
                            </form>
                        </c:if>
                    </div>
                    <div class="foot-status-grp">
                        <c:if test="${userRole == 'ADMIN'}">
                            <div style="color: #ff0000">${selectedNews.newsStatus}</div>
                        </c:if>
                        <div>${selectedNews.dateOfPublication}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
