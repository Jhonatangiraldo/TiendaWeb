(function() {
  var app = angular.module('TiendaPeliculas', []);

  app.controller('Login',['$http', function($http){
    var login = this;
    login.usuario = '';
    login.pass = '';

    login.ingresar = function(){
      if (login.usuario == '' || login.pass == ''){
        alert("Llene todos los campos");
      }else{
        var req = {
             method: 'POST',
             url: 'http://localhost:8090/Tienda/rest/security_service/login/'
                  + login.usuario + "/" + login.pass,
             headers: {
               'Content-Type': undefined
             }
        };
          console.log(req.url);
            $http(req).then(function(response){
              if (response.data.respuesta == "Ok"){
                alert("Bienvenido");
                location.href = "http://localhost:8090/Tienda/views/main.html";
              }else{
                alert("Usuario y/o contraseña incorrecto");
              }
            });
      }
    }
  }]);

  app.controller('Main',['$http', function($http){
    var main = this;
  }]);

  app.controller('Movies',['$http', function($http){
    var movies = this;
    movies.filtro = 'nombrePelicula';
    movies.texto = '';
    movies.peliculas = '';
    movies.peliculaAlquilar = '';
    movies.inicio = '';
    movies.fin = '';
    movies.numero = 0;

    movies.alquilar = function(pelicula_id){
      movies.peliculaAlquilar = pelicula_id;
    }

    var req = { method: 'POST', url: 'http://localhost:8090/Tienda/rest/peliculas/peliculas',
                headers: {'Content-Type': undefined }
    };
        $http(req).then(function(response){
            console.log(response.data);
            movies.peliculas = response.data;
        });


    movies.busqueda = function(){
      var req2 = { method: 'POST', url: 'http://localhost:8090/Tienda/rest/peliculas/pelicula/'
                   + movies.filtro + '/' + movies.texto,
                  headers: {'Content-Type': undefined }
       };
      console.log(req2.url);
        $http(req2).then(function(response){
            console.log(response.data);
            movies.peliculas = response.data;
        });
    }

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
