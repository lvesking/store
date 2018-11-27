<%@ page contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<!-- 图片上传
		enctype="multipart/form-data":表示上传整个图片
		<input type="file">	上传组件选择file -->
		<form action="${pageContext.request.contextPath }/upload/uploadFile.do" method="post"
			enctype="multipart/form-data">
			
			请选择文件:<input type="file" name="file" id="file"><br>
			<input type="submit" value="上传"><br>
		</form>
</body>
</html>