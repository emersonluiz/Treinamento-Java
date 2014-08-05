function controller($scope,$http){
	$scope.items = [];
    $scope.servico = "";
    
    $scope.salvar = function(){
    	$scope.servico = {servico:{nome:$scope.nome}};
	    $http.post('/Nomination/rest/resource/servico/insert',$scope.servico).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
}