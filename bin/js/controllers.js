(function() {
  var app = angular.module('TiendaPeliculas', []);

  app.controller('Login',['$http', function($http){
    var login = this;
    login.numero1 = "Hola Mundo Login";
  }]);

  app.controller('Main',['$http', function($http){
    var login = this;
    login.numero1 = "Hola Mundo Main";
  }]);

  app.controller('Movies',['$http', function($http){
    var login = this;
    login.numero1 = "Hola Mundo Movies";
  }]);

  app.controller('SignUp',['$http', function($http){
    var login = this;
    login.usuario = '';
    login.pass = '';
    login.pass2 = '';

    login.registrar = function(){
      if (login.usuario == '' || login.pass == '' || login.pass2 == ''){
        alert("Llene todos los campos");
      }else if(login.pass != login.pass2){
        alert("Las contraseñas dadas no concuerdan");
      }else{
        var req = {
             method: 'POST',
             url: 'http://localhost:8090/Tienda/rest/security_service/registro/'
                  + login.usuario + "/" + login.pass,
             headers: {
               'Content-Type': undefined
             }
        };
          console.log(req.url);
            $http(req).then(function(response){
              if (response.data.respuesta == "Ok"){
                alert("Usuario creado exitosamente");
                location.href = "http://localhost:8090/Tienda/views/main.html";
              }else{
                alert("Este usuario ya se encuentra registrado");
              }
            });
      }

    }
  }]);

})();
