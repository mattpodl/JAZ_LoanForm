<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="domain.Person" scope="session"/>

<jsp:setProperty property="*" name="person"/>

<form action="success.jsp">
<label>city: <input type="text" id="city" name="city"/></label>
<label>zipCode: <input type="text" id="zipCode" name="zipCode"/></label>
<label>street: <input type="text" id="street" name="street"/></label>
<label>houseNumber: <input type="text" id="houseNumber" name="houseNumber"/></label>
<label>localNumber: <input type="text" id="localNumber" name="localNumber"/></label>
<label>phoneNumber: <input type="text" id="phoneNumber" name="phoneNumber"/></label>

<input type="submit" value="nastepny krok"/>

</form>




</body>
</html>