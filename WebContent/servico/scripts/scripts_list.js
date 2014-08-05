function controller($scope,$http){
	$scope.items = [];
    $scope.servico = "";
    
    $scope.getAll = function(){
    	
    	$http.get('/Nomination/rest/resource/servico/servicos').success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.items = data.servico;
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.del = function(pId){
    	$http.get('/Nomination/rest/resource/servico/delete/'+pId).success(function(data){
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