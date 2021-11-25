<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <h3 style="margin-top: 10px">회원가입 페이지</h3>

    <form style="margin-top: 20px" action="/auth/signup" method="post">

        <div class="form-group">
            <label for="realName">이름</label>
            <input type="text" name="realName" id="realName" required placeholder="이름을 입력하세요 (20자 이내)" class="form-control form-control-lg" maxlength="20">
        </div>

        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" name="username" id="username" required placeholder="아이디를 입력하세요 (20자 이내)" class="form-control form-control-lg" maxlength="20">
        </div>

        <div class="form-group">
            <label for="password">패스워드</label>
            <input type="password" class="form-control form-control-lg" required placeholder="사용하실 패스워드를 입력하세요" name="password"
                   id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control form-control-lg" required minlength="6" placeholder="Email" name="email" id="email"
                   aria-describedby="emailHelp">
            <small id="emailHelp" class="form-text text-muted">이메일은 다른 용도로 사용되지 않습니다</small>
        </div>

        <input id= "save" type="submit" value="회원가입" href="/" class="btn btn-dark btn-block" style="margin-top: 30px" >
        <br>
        <span > 이미 계정이 있으신가요? <a class="linkControl" href="/auth/signin">로그인</a></span>
        <br>
    </form>



<%--    <button id="btn-save" class="btn btn-primary">회원가입완료</button>--%>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>