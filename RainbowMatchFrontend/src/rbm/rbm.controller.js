angular.module("rbm").controller("RainbowMatchController", function(){
    if(localStorage.userName == undefined){
         window.location.href = "#login";
    }else{
        window.location.href = "#home";
    }
});
