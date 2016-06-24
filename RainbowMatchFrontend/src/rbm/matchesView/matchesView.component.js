(function() {

    function MatchesViewController (HttpService){
        var vm = this;
        vm.matches = [];
        vm.currentMatch = 0;

        vm.loadMatches = function() {
            console.log(RainbowMatch.baseUrl + "api/users/users");
            HttpService.get(RainbowMatch.baseUrl + "api/users/users", function(data){
                for(var i in data.data) {
                    var usr = data.data[i]
                    HttpService.get(RainbowMatch.baseUrl + "api/profile/info/" + usr.userId, function(data){
                        usr.profile = data.data;
                        vm.matches.push(usr);
                    });
                }
            });
        };
        document.addEventListener('touchstart', handleTouchStart, false);        
        document.addEventListener('touchmove', handleTouchMove, false);

        var xDown = null;                                                        
        var yDown = null;                                                        

        function handleTouchStart(evt) {                                         
            xDown = evt.touches[0].clientX;                                      
            yDown = evt.touches[0].clientY;                                      
        };                                                

        function handleTouchMove(evt) {
            if ( ! xDown || ! yDown ) {
                return;
            }

            var xUp = evt.touches[0].clientX;                                    
            var yUp = evt.touches[0].clientY;

            var xDiff = xDown - xUp;
            var yDiff = yDown - yUp;

            if ( Math.abs( xDiff ) > Math.abs( yDiff ) ) {/*most significant*/
                if ( xDiff > 0 ) {
                    
                    vm.nextMatch();
                }                       
            } else {
                if ( yDiff > 0 ) {
                    /* up swipe */ 
                } else { 
                    /* down swipe */
                }                                                                 
            }
            /* reset values */
            xDown = null;
            yDown = null;                                             
        };
        vm.nextMatch = function() {
          if(vm.currentMatch < vm.matches -1) {
            vm.currentMatch++;
          } else {
            vm.currentMatch = 0;
          }

        };


        vm.loadMatches();



    }


    angular.module("rbm").component("matchesView", {
	   templateUrl : "rbm/matchesView/matchesView.html",
	   controller : MatchesViewController,
	   bindings : {}
    });

})();
