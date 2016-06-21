(function(){
  function HomeViewController(HttpService){
    var vm = this;
    
  }

  angular.module("backendApp").component("homeView", {
    templateUrl : 'backend/homeView/homeView.html',
    controller : HomeViewController,
    bindings : {}
  });
})();
