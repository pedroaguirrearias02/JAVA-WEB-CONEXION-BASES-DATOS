'use strict';

module.controller('MateriaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaCarrera = null;
        $scope.listaProfes = null;

        $scope.datosFormulario = {horario: []};
        $scope.panelEditar = false;

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            //$scope.datosFormulario = {horario:[]};
        };

        $scope.nuevoHorario = function () {
            $scope.datosHorario = {};
            $('#modalHorario').modal('show');
        };

        $scope.editarHorario = function (datos) {
            $scope.datosHorario = datos;
            $('#modalHorario').modal('show');
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
        //eliminar
        $scope.eliminar = function (data) {
            for (var i = 0; i < $scope.lista.length; i++) {
                if ($scope.lista[i] === data) {
                    $scope.lista.splice(i, 1);
                    break;
                }
            }
            console.log("Eliminado " + data.nombre);
            $.ajax({
                url: './webresources/ServicioMateria/' + data.id,
                type: 'DELETE'
            });
        };

        $scope.getMaterias = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioMateria", {})
                    .then(function (response) {
                        console.log(response.data);
                        $scope.lista = response.data;
                        for (var i = 0; i < $scope.lista.length; i++) {
                            for (var j = 0; j < $scope.lista[i].horario.length; j++) {
                                var dat = $scope.lista[i].horario[j].horaFin.toString();
                                $scope.lista[i].horario[j].horaFin = dat.slice(0, dat.length - 5);
                                var datIni = $scope.lista[i].horario[j].horaInicio.toString();
                                $scope.lista[i].horario[j].horaInicio = datIni.slice(0, datIni.length - 5);
                            }
                        }

                    }, function () {
                        alert("Error al consultar Materias");
                    });
        };

        $scope.guardarMateria = function () {
            console.log($scope.datosFormulario.horario.dia);
            $http.post("./webresources/ServicioMateria", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getMaterias();
                    });
            $scope.panelEditar = false;
        };

        $scope.getCarrera = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioCarrera", {})
                    .then(function (response) {
                        $scope.listaCarrera = response.data;
                    }, function () {
                        alert("Error al consultar el Carreras");
                    });
        };

        $scope.getProfesores = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioProfesor", {})
                    .then(function (response) {
                        $scope.listaProfes = response.data;
                    }, function () {
                        alert("Error al consultar el Profesores");
                    });
        };

        $scope.getProfesores();
        $scope.getCarrera();
        $scope.getMaterias();

        $scope.guardarHorario = function () {
            $scope.datosFormulario.horario.push($scope.datosHorario);
            for (var i = 0; i < $scope.lista.length; i++) {
                for (var j = 0; j < $scope.lista[i].horario.length; j++) {
                }
            }

            $('#modalHorario').modal('hide');
        };
      
        $scope.eliminarHorario = function (data) {
            console.log('esta es la informacion de horario'+JSON.stringify(data));
            if (confirm('\xbfDesea elminar este registro?')) {
                for (var i = 0; i < $scope.lista.length; i++) {
                    for (var j = 0; j < $scope.lista[i].horario.length; j++) {
                        if ($scope.lista[i].horario[j] == data) {
                            $scope.lista[i].horario.splice(j, 1);
                            break;
                        }else{
                            $scope.datosFormulario = {};
                        }
                    }
                }
            }
            $.ajax({
                url: './webresources/ServicioEstudiante/eliminarHorario' + data,
                type: 'DELETE'
            });
        };

    }]);



