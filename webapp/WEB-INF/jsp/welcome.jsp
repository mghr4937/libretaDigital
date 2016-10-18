<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<jsp:include page="/WEB-INF/jsp/header.jsp" />

<%
	ObjectMapper objMapper = new ObjectMapper();
	Object obj = request.getAttribute("objeto");
	String jsonString = objMapper.writeValueAsString(obj);
%>
<body ng-controller="mainCtrl">
<script type="text/javascript">
 var objeto = <%=jsonString%>;


</script>	

<%-- 	<h4>${mensaje} : ${user}</h4> --%>
<%--  	<spring:url var="salir" value="/inicializarLogin.html"/> --%>
<%--  	<a href="${lista}" >Salir</a> --%>
	<p id="msg">{{msj}}</p>
		
	<br>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
 
		Spring MCV Tutorial by <a href="http://crunchify.com">Crunchify</a>.
		Click <a href="http://crunchify.com/category/java-web-development-tutorial/"	target="_blank">here</a>for all Java and 
		<a href='http://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.
		<br>
	</div>
	
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />