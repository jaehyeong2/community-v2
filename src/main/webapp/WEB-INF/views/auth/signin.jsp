
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <h3 style="margin-top: 10px">로그인 페이지</h3>
    <form action="/auth/signin" method="post">

        <div class="form-group">
            <label for="username">아이디</label>
            <input type="username" name="username" id="username" placeholder="아이디를 입력하세요" class="form-control form-control-lg">
        </div>
        <div class="form-group">
            <label for="password">패스워드</label>
            <input type="password" class="form-control form-control-lg" placeholder="패스워드를 입력하세요" name="password" id="password">
        </div>

        <input type="submit" value="로그인" href="/" class="btn btn-dark btn-block" style="margin-top: 30px" >
        <br>
        <span > 아직 계정이 없으신가요? <a class="linkControl" href="/auth/signup">회원가입</a></span>
        <br>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>