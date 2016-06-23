angular.module("rbm").controller("RainbowMatchController", function(){
    if(localStorage.userName == undefined){
        jQuery.mobile.navigate("#home");
    }else{
        jQuery.mobile.navigate("#home");
    }
});
