<!DOCTYPE html>
<html ng-app>
<head>
<meta charset="ISO-8859-1">
<title>Nomeacao</title>
<link type="text/css" rel="stylesheet" href="../css/style.css"/>
<script type="text/javascript" src="../scripts/lib/angular.min.js"></script>
<script type="text/javascript" src="scripts/scripts_edit.js?version=1.0"></script>
</head>
<body ng-controller="controller">
	<p>Edicao de Nomeacao</p>
	<table>
		<tr>
			<td>Numero</td>
			<td><input type="text" nome="numero" ng-model="numero"></td>
		<tr>
		<tr>
			<td>Cliente</td>
			<td><select ng-model="cliente" ng-options="cliente.nome for cliente in clientes"></select></td>
		<tr>
		<tr>
			<td colspan="2" class="titulo">Servicos</td>
		<tr>
		<tr>
			<td>Servico</td>
			<td><select ng-model="servico" ng-options="servico.nome for servico in servicos"></select> <button type="button" ng-click="addServico()">Add</button></td>
		<tr>
			<td colspan="2">
				<table>
					<tr>
						<td class="td">Id</td>
						<td class="td">Servico</td>
						<td class="td">Acao</td>
					<tr>
					<tr ng-repeat="item in itemsServico">
						<td ng-class-odd="'td_odd'" ng-class-even="'td_even'">{{item.id}}</td>
						<td ng-class-odd="'td_odd'" ng-class-even="'td_even'">{{item.servico.nome}}</td>
						<td ng-class-odd="'td_odd'" ng-class-even="'td_even'"><a href="#" ng-click="del($index)">[ Delete ]</a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" ng-click="editar()">Save</button></td>
		</tr>
	</table>
	<a href="../index.html">[ Home ]</a> <a href="nomeacao_list.html">[ Lista ]</a>
	<script type="text/javascript">
		vIdNomination = '${param.id}';
	</script>
</body>
</html>