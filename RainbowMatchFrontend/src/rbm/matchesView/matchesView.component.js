(function() {

    function MatchesViewController (HttpService, $scope){
        var vm = this;
        vm.matches = [];
        vm.currentMatch = 0;

        /**
         * this method loads a list of all users and maps it to the related profile infos.
         * In this version all users are loaded. In a future release a filtered list for
         * specific matches will be loaded
         */
        vm.loadMatches = function() {
            console.log(RainbowMatch.baseUrl + "api/users/users");
            HttpService.get(RainbowMatch.baseUrl + "api/users/users", function(data){
                for(var i in data.data) {
                    var usr = data.data[i];
                    (function(usr) {console.log(usr);
                      HttpService.get(RainbowMatch.baseUrl + "api/profile/info/" + usr.userId, function(data){
                          usr.profile = data.data;
                          console.log(data.data, usr);
                          vm.matches.push(usr);
                      });
                    })(usr);
                }
            });
        };

        /**
         * handlers for touch event
         */
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
                    $scope.$apply();
                    console.log("swipe");

                }
            }
            xDown = null;
            yDown = null;
        };


        /**
         * selects next match. after the last user is selected, the first user will be returned.
         */
        vm.nextMatch = function() {
          if(vm.currentMatch < vm.matches.length - 1) {
            vm.currentMatch++;
            console.log(vm.matches);
            console.log(vm.currentMatch);
          } else {
            vm.currentMatch = 0;
            console.log(vm.currentMatch);
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
