function controller($scope,$http){
	$scope.servico = "";
    
    $scope.get = function(pId){
    	
    	$http.get('/Nomination/rest/resource/servico/servico/'+pId).success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.nome = data.servico.nome;
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.editar = function(){
    	$scope.servico = {servico:{id:vIdServico,nome:$scope.nome}};
	    $http.post('/Nomination/rest/resource/servico/edit',$scope.servico).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
    
    $scope.get(vIdServico);

}