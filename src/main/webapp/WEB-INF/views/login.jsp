<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
${msg}

${user}

<form action="./result.do" method="post">
아이디 : 
<input type="text" name="id">
비밀번호
<input type="text" name="password">
<input name ="remember-me" type = "checkbox"/>Remember me

<input type="submit" value="제출">
</form>

<a href="./singUpgo.do">회원가입</a>

</body>
</html>















