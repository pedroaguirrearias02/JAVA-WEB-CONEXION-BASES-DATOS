//'use strict';
//
//module.controller('HorarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
//        $scope.lista = null;
//        $scope.datosFormulario = {};
//        $scope.panelEditar = false;
//        $scope.dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
//
//        $scope.nuevo = function () {
//            $scope.panelEditar = true;
//            $scope.datosFormulario = {};
//        };
//
//        $scope.cancelar = function () {
//            $scope.panelEditar = false;
//            $scope.datosFormulario = {};
//        };
//
//        //editar
//        $scope.editar = function (data) {
//            $scope.panelEditar = true;
//            $scope.datosFormulario = data;
//        };
//        
//        //eliminar
//        $scope.eliminar = function (data) {
//            for (var i = 0; i < $scope.lista.length; i++) {
//                if ($scope.lista[i] === data) {
//                    $scope.lista.splice(i, 1);
//                    break;
//                }
//            }
//            console.log("Eliminado " + data.nombre);
//            $.ajax({
//                url: './webresources/ServicioHorario/' + data.id,
//                type: 'DELETE'
//            });
//        };
//
//        $scope.getHorarios = function () {
//            $scope.lista = null;
//            $http.get("./webresources/ServicioHorario", {})
//                    .then(function (response) {
//                        console.log(response.data);
//                        $scope.lista = response.data;
//                    }, function () {
//                        alert("Error al consultar Horarios");
//                    });
//        };
//
//        $scope.guardarHorario = function () {
//            console.log("esta guardando horario")
//            $http.post("./webresources/ServicioHorario", $scope.datosFormulario)
//                    .then(function (response) {
//                        $scope.getHorarios();
//                    });
//            $scope.panelEditar = false;
//        };
//        $scope.getHorarios();
//    }]);
