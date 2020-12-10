<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊畫面</title>
</head>
<body>
	<fieldset>
		<legend>會員註冊</legend>
			<form method="post" action="RegisterServlet">
				<!--div:division-->
				<div>使用者名稱</div>
					<input type="text" placeholder="請以英文輸入" maxlength="10" name="username" />
				<div>密碼</div> 
					<input type="password" minlength="8" maxlength="20" name="password" />
				<div>
					<button type="submit">註冊</button>
					<button type="reset">清除</button>
				</div>
			</form>
	</fieldset>
</body>
</html>