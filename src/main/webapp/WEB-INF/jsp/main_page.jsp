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
            <h4>Latest 10 news...</h4>
        </div>
        <div class="last-news">
            <c:forEach var="news" items="${lastNews}">
                <div class="news-head">
                    <form action="Controller" method="post">
                        <a>
                            <input type="hidden" name="newsId" value="${news.id}">
                            <input type="hidden" name="command" value="GO_TO_NEWS_FROM_ID">
                            <button type="submit" class="btn btn-link" style="text-decoration-line: none;
                                font-size: 19px">${news.title}</button>
                        </a>
                    </form>
                    <div>
                        <c:out value="${news.briefDescription}"/>
                    </div>
                </div>
                <hr/>
                <div class="news-foot">
                    <div class="main-news-foot">
                        <form action="Controller" method="post">
                            <a>
                                <input type="hidden" name="command" value="GO_TO_COMMENTS_PAGE">
                                <input type="hidden" name="newsId" value="${news.id}">
                                <button type="submit" class="btn btn-secondary btn-sm">Comments</button>
                            </a>
                        </form>
                    </div>
                    <div class="main-news-foot d-flex justify-content-end">${news.dateOfPublication}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>