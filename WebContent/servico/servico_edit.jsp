<!DOCTYPE html>
<html ng-app>
<head>
<meta charset="ISO-8859-1">
<title>Servico</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/lib/angular.min.js"></script>
<script type="text/javascript" src="scripts/scripts_edit.js?version=1.0"></script>
</head>
<body ng-controller="controller">
	<p>Alteracao de Servico</p>
	<table>
		<tr>
			<td>Nome</td>
			<td><input type="text" nome="nome" ng-model="nome"></td>
		<tr>
		<tr>
			<td colspan="2"><button type="button" ng-click="editar()">Save</button></td>
		</tr>
	</table>
	<a href="../index.html">[ Home ]</a>
	<a href="servico_list.html">[ Lista ]</a>
	<script type="text/javascript">
		vIdServico = '${param.id}';
	</script>
</body>
</html>