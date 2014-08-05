function controller($scope,$http){
	$scope.nomination = "";
	$scope.itemsServico = [];
	$scope.clientes = [];
	
	$scope.getClientes = function(pObject){
    	$http.get('/Nomination/rest/resource/cliente/clientes').success(function(data){
		   if (data != null && data != "null"){      		   	
		   		$scope.clientes = data.cliente;
		   		if (pObject != null){
		   			for(var i=0; i<$scope.clientes.length; i++){
		   				if (pObject.id == $scope.clientes[i].id)
		   					$scope.cliente = $scope.clientes[i];
		   			}
		   		}
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
	
    $scope.get = function(pId){
    	
    	$http.get('/Nomination/rest/resource/nomeacao/nomeacao/'+pId).success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.numero = data.nomeacao.numero;
  	       		$scope.getClientes({id:data.nomeacao.cliente.id, nome:data.nomeacao.cliente.nome});
  	       		if (data.nomeacao.nomeacaoServicos)
  	       			$scope.itemsServico = ((data.nomeacao.nomeacaoServicos instanceof Array)?data.nomeacao.nomeacaoServicos:[data.nomeacao.nomeacaoServicos]);
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.addServico = function(){
    	$scope.itemsServico.push( {nomeacao:{id:vIdNomination},servico:$scope.servico} );
    };
    
    $scope.editar = function(){
    	$scope.nomeacao = {nomeacao:{id:vIdNomination,numero:$scope.numero,cliente:$scope.cliente,nomeacaoServicos:$scope.itemsServico}};
	    $http.post('/Nomination/rest/resource/nomeacao/edit',$scope.nomeacao).success(function(data){    		
			if (data != null && data != "null"){
				alert("Dados gravados.");
				$scope.get(vIdNomination);
			}
		}).error(function(data){
			alert("Error on server!");
		});
    };
    
    $scope.del = function(pIndice){
    	if ($scope.itemsServico[pIndice].id != ""){
    		$http.get('/Nomination/rest/resource/nomeacao/deleteServico/'+$scope.itemsServico[pIndice].id).success(function(data){
	      	   if (data != null && data != "null"){      		   	
	      		 alert("Dados Deletado.");
	  	       }
	         }).error(function(data){
	     		alert("Error on server!");
	     	});    
    	}
    	$scope.itemsServico.splice(pIndice,1);         
    };
    
    
    $scope.getServicos();
    $scope.get(vIdNomination);

}