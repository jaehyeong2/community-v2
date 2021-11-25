<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form>
        <input type="hidden" id="id" value="${principal.user.id}" />

        <div class="form-group">
            <label for="realName">이름</label>
            <input type="text" value="${principal.user.realName}" id="realName" class="form-control form-control-lg" maxlength="20">
        </div>

        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" value="${principal.user.username}" class="form-control"  id="username" readonly>
        </div>

        <c:if test="${empty principal.user.oauth}">
            <div class="form-group">
                <label for="password">패스워드</label>
                <input type="password" class="form-control"  id="password">
            </div>
        </c:if>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" value="${principal.user.email}" class="form-control" id="email" readonly>
        </div>

    </form>
    <button id="btn-update" class="btn btn-primary">수정완료</button>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>