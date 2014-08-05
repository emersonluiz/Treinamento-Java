function controller($scope,$http){
	$scope.items = [];
    $scope.nomeacao = "";
    
    $scope.getAll = function(){
    	
    	$http.get('/Nomination/rest/resource/nomeacao/nomeacoes').success(function(data){
      	   if (data != null && data != "null"){      		   	
  	       		$scope.items = data.nomeacao;
  	       }
         }).error(function(data){
     		alert("Error on server!");
     	});    
              
    };
    
    $scope.del = function(pId){
    	$http.get('/Nomination/rest/resource/nomeacao/delete/'+pId).success(function(data){
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