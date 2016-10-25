<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<h3><center>Welcome to SuggestionCART</center></h3>
<c:if test="${userClickedLogin}">
<jsp:include page="login.jsp"></jsp:include><br>
</c:if>
<c:if test="${userClickedRegister}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:out value="${ErrorMessage}"/>
<c:out value="${SuccessMessage}"/>
</body>
</html>
