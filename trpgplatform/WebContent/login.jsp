<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<fieldset>
		<legend>登入</legend>
			<form method="post" action="LoginServlet">
				<div>使用者名稱</div>
					<input type="text" maxlength="10"　id="username" name="username"/>
				<div>密碼</div>
					<input type="password" maxlength="20" id="password" name="password"/>
				<div>
					<button type="submit">登入</button>
					<button type="reset">清除</button>
				</div>
			</form>
	</fieldset>
	${msg}
</body>
</html>
