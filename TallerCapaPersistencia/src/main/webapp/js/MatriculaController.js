'use strict';

module.controller('MatriculaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listaEstudia = listaEstudiante;
        $scope.listaMateria = listaMaterias;

        $scope.matCarr = [];

        $scope.searchMat = function (data) {
            $scope.matCarr = [];
            for (var i = 0; i < $scope.listaMateria.length; i++) {
                if ($scope.listaMateria[i].carrera.nombre == data.nombre) {
                    $scope.matCarr.push($scope.listaMateria[i]);
                }
            }
        }



        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
            $scope.matCarr = [];
        };

        $scope.guardar = function () {
            $scope.errores = {};
            var error = false;

            if (error)
                return;

            if (!$scope.datosFormulario.id) {
                $scope.datosFormulario.id = $scope.id++;
                $scope.lista.push($scope.datosFormulario);
            }
            $scope.panelEditar = false;
        };
        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
            $scope.matCarr = [];
        };

        //editar
        $scope.editar = function (data) {
            $scope.matCarr = [];
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };
        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                for (var i = 0; i < $scope.lista.length; i++) {
                    if ($scope.lista[i] == data) {
                        $scope.lista.splice(i, 1);
                        break;
                    }
                }
            }
        };
    }]);
