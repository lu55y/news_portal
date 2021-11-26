<%--@elvariable id="selectedNews" type="by.it.academy.bean.News"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<%--Content--%>
<div class="wrapper">
    <div class="d-flex flex-column m-4" style="width: 100%">
        <div class="page-head">
            <h1>Comments</h1>
            <br/>
        </div>
        <hr/>
        <div>
            <h4>
                <c:choose>
                    <c:when test="${commentCounter != 0}">${commentCounter} comments</c:when>
                    <c:when test="${commentCounter == null}">No comments</c:when>
                    <c:otherwise>No comments</c:otherwise>
                </c:choose>
            </h4>
            <c:forEach var="comment" items="${commentList}">
                <div class="d-flex flex-column p-3">
                    <div class="text-start">
                        <h6 class="ms-3 mt-1 mb-1">${comment.userName}</h6>
                    </div>
                    <div class="d-flex border" style="min-height: 80px">
                        <p class="mt-0 mb-0 p-2">${comment.commentContent}</p>
                    </div>
                    <p class="text-end mt-1">${comment.dateOfPublication}</p>
                    <c:if test="${userRole == 'ADMIN'}">
                        <form action="Controller" method="post">
                            <input type="hidden" name="commentId" value="${comment.id}">
                            <input type="hidden" name="newsId" value="${comment.newsId}">
                            <button class="float-end btn btn-secondary btn-sm mt-3 me-3" type="submit" name="command"
                                    value="DELETE_COMMENT">Delete
                            </button>
                        </form>
                    </c:if>
                </div>
            </c:forEach>
            <hr/>
            <h5>Write comment</h5>
            <form class="mt-5" action="Controller" method="post">
                    <textarea class="form-control mt-3" rows="3" placeholder="Write a comment.."
                              name="commentContent"></textarea>
                    <input type="hidden" name="newsId" value="${newsId}">
                    <button class="btn btn-secondary btn-sm mt-3" type="submit" name="command" value="PUBLISH_COMMENT">
                        Publish
                    </button>
            </form>
        </div>
    </div>
</div>
<%--Footer--%>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
