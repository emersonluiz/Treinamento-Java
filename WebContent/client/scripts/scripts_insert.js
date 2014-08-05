function controller($scope,$http){
	$scope.items = [];
    $scope.cliente = "";
    
    $scope.salvar = function(){
    	$scope.cliente = {cliente:{nome:$scope.nome}};
	    $http.post('/Nomination/rest/resource/cliente/insert',$scope.cliente).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
}