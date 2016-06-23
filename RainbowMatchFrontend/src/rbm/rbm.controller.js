angular.module("rbm").controller("RainbowMatchController", function(){
    if(localStorage.userName == undefined){
        jQuery.mobile.navigate("#login");
    }else{
        jQuery.mobile.navigate("#home");
    }
});
