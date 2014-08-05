function controller($scope,$http){
	$scope.itemsServico = [];
	$scope.clientes = [];
	$scope.servicos = [];
    $scope.nomeacao = "";
    
    $scope.getClientes = function(){
    	$http.get('/Nomination/rest/resource/cliente/clientes').success(function(data){
       	   if (data != null && data != "null"){      		   	
   	       		$scope.clientes = data.cliente;
   	       }
          }).error(function(data){
      		alert("Error on server!");
      	});  
    };
    
    $scope.getServicos = function(){
    	$http.get('/Nomination/rest/resource/servico/servicos').success(function(data){
       	   if (data != null && data != "null"){      		   	
   	       		$scope.servicos = data.servico;
   	       }
          }).error(function(data){
      		alert("Error on server!");
      	});  
    };
    
    $scope.addServico = function(){
    	$scope.itemsServico.push( {servico:$scope.servico} );
    };
    
    $scope.salvar = function(){
    	$scope.nomeacao = {nomeacao:{numero:$scope.numero,cliente:$scope.cliente,nomeacaoServicos:$scope.itemsServico}};
	    $http.post('/Nomination/rest/resource/nomeacao/insert',$scope.nomeacao).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
    
    $scope.del = function(pIndice){    	
    	$scope.itemsServico.splice(pIndice,1);         
    };
    
    $scope.getClientes();
    $scope.getServicos();
};