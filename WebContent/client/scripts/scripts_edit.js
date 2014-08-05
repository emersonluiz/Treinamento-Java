function controller($scope,$http){
	$scope.cliente = "";
    
    $scope.get = function(pId){
    	
    	$http.get('/Nomination/rest/resource/cliente/cliente/'+pId).success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.nome = data.cliente.nome;
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.editar = function(){
    	$scope.cliente = {cliente:{id:vIdClient,nome:$scope.nome}};
	    $http.post('/Nomination/rest/resource/cliente/edit',$scope.cliente).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
    
    $scope.get(vIdClient);

}