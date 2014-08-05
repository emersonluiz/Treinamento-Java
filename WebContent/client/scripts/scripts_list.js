function controller($scope,$http){
	$scope.items = [];
    $scope.cliente = "";
    
    $scope.getAll = function(){
    	
    	$http.get('/Nomination/rest/resource/cliente/clientes').success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.items = data.cliente;
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.del = function(pId){
    	$http.get('/Nomination/rest/resource/cliente/delete/'+pId).success(function(data){
      	   if (data != null && data != "null"){      		   	
      		 alert("Dados Deletado.");
      		 $scope.getAll();
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
   
    $scope.getAll();
}