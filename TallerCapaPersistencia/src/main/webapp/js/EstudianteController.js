'use strict';

module.controller('EstudiantesCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaMunicipio = null;
        $scope.listaCarrera = null;
        
        $scope.datosFormulario = {};
        $scope.panelEditar = false;

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };

        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        $scope.getEstudiantes = function () {
            $http.get("./webresources/ServicioEstudiante", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                        $scope.datosFormulario = {};
                    }, function () {
                        alert("Error al consultar el estudiante");
                    });
        };

        $scope.guardar = function () {
            console.log($scope.datosFormulario);
            $http.post("./webresources/ServicioEstudiante", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getEstudiantes();
                    });
            $scope.panelEditar = false;
        };

        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                $http.delete('./webresources/ServicioEstudiante/' + data.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.getEstudiantes();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de Estudiante, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.getMunicipios = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioMunicipio", {})
                    .then(function (response) {
                        $scope.listaMunicipio = response.data;
                    }, function () {
                        alert("Error al consultar el Municipios");
                    });
        };

        $scope.getCarrera = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioCarrera", {})
                    .then(function (response) {
                        $scope.listaCarrera = response.data;
                    }, function () {
                        alert("Error al consultar la Carreras");
                    });
        };

        $scope.getCarrera();
        $scope.getMunicipios();
        $scope.getEstudiantes();
    }]);
