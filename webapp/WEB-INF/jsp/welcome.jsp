<jsp:include page="/WEB-INF/jsp/header.jsp" />

<%
	
%>

<body>
<%-- 	<h4>${mensaje} : ${user}</h4> --%>
<%--  	<spring:url var="salir" value="/inicializarLogin.html"/> --%>
<%--  	<a href="${lista}" >Salir</a> --%>
	<p id="msg">${message}</p>
		
	<br>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
 
		Spring MCV Tutorial by <a href="http://crunchify.com">Crunchify</a>.
		Click <a href="http://crunchify.com/category/java-web-development-tutorial/"	target="_blank">here</a>for all Java and 
		<a href='http://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.
		<br>
	</div>
	
</body>
</html>