<jsp:include page="/WEB-INF/jsp/header.jsp" />


<body ng-controller="mainCtrl">

<!-- right menu -->
<aside-menu id="right-menu" side="left" width="400px" is-backdrop="true" push-content="false">
    <ul class="list-group">
        <li class="list-group-item"><a href="FileUpload.html">Carga de Datos</a></li>        
        <li class="list-group-item">Opcion 2</li>
        <li class="list-group-item">Opcion 3</li>
        <li class="list-group-item">Opcion 3</li>
        <li class="list-group-item">Salir</li>
    </ul>
</aside-menu>

	<h1>{{msj}}</h1>
	<h2>
		<a href="welcome.html">WELCOME</a>
	</h2>
	
<!-- 	<button type="button" aside-menu-toggle="sol2" class="btn btn-default">Left</button> -->
<aside-menu-content>
    <div style="display: table; margin: 200px auto">
        <button type="button" aside-menu-toggle="right-menu" class="btn btn-default">Left Menu</button>
    </div>
</aside-menu-content>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />