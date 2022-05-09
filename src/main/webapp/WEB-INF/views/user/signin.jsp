
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <h3 style="margin-top: 10px">로그인 페이지</h3>
    <form action="/user/signin" method="post">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="username" name="username" id="username" placeholder="아이디를 입력하세요" class="form-control form-control-lg">
        </div>
        <div class="form-group">
            <label for="password">패스워드</label>
            <input type="password" class="form-control form-control-lg" placeholder="패스워드를 입력하세요" name="password" id="password">
        </div>

            <input type="submit" value="로그인" href="/" class="btn btn-dark btn-block col-sm-1 " style="display:inline-block" >
            <a href="https://kauth.kakao.com/oauth/authorize?client_id=19ec158ac89f2be7a8713d1bec482fb9&redirect_uri=http://13.209.86.236:8080//auth/kakao/callback&response_type=code"><img height="38px" src="/images/kakao_login_button.png" /></a>

        <br /> <br />
        <span > 아직 계정이 없으신가요? <a class="linkControl" href="/user/signup">회원가입</a></span>
        <br>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>