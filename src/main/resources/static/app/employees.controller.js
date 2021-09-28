(function () {
    'use strict';

    angular
        .module('app')
        .controller('EmployeesController', EmployeesController)

    EmployeesController.$inject = ['$http', '$scope', '$filter'];

    function EmployeesController($http, $scope, $filter) {
        var ec = this;

        ec.employees = [];
        $scope.employee = {};
        ec.getAll = getAll;
        ec.deleteEmployee = deleteEmployee;
        ec.addEmployee = addEmployee;
        ec.editEmployee = editEmployee;
        $scope.setEmployee = setEmployee;
        ec.updateEmployee = updateEmployee;
        ec.goToHome = goToHome;

        init();

        function init() {

            /*getAll();*/

            $(document).ready(function () {

                var draw;

                $('#employeesTable').DataTable({
                    paging: true,
                    pagingType: 'full_numbers',
                    pageLength: 5,
                    scrollY: '196px',
                    scrollCollapse: true,
                    processing: true,
                    searching: true,
                    ordering: true,
                    responsive: true,
                    serverSide: true,
                    ajax: {
                        type: 'POST',
                        headers: {
                            'Content-type': 'application/json'
                        },
                        url: 'http://localhost:8080/api/v1/employee/listAllEmployees',
                        data: function (response) {
                            delete response.columns;

                            var dataTableRequestDTO = {
                                draw: response.draw,
                                start: response.start,
                                length: response.length,
                                order: response.order,
                                search: response.search
                            };

                            draw = response.draw;

                            console.log('dataTableRequestDTO', JSON.stringify(dataTableRequestDTO));

                            return JSON.stringify(dataTableRequestDTO);
                        }, dataFilter: function (data) {

                            var json = JSON.parse(data);

                            console.log('json', json);

                            var dataFilter = {
                                draw: draw,
                                recordsTotal: json.length,
                                recordsFiltered: json.length,
                                data: json
                            };

                            console.log('dataFilter', dataFilter);

                            return JSON.stringify(dataFilter);
                        },
                    },
                    columns: [
                        {data: 'id', title: 'Id'},
                        {data: 'name', title: 'Name'},
                        {data: 'role', title: 'Role'},
                        {data: 'cnic', title: 'Cnic'},
                        {data: 'age', title: 'Age'},
                        {
                            data: 'dob', title: 'Date of birth', render: function (data) {
                                return moment(data).format('MM/DD/YYYY');
                            }
                        },
                        {
                            data: 'id',
                            title: 'Action',
                            defaultContent: null,
                            render: function (data) {
                                return '<span class=\"text-primary editButton\" title=\"Edit Record\"><i class=\"fas fa-pencil-alt\" id=\"' + data + '\" style=\"cursor: pointer\"></i></span>&nbsp;&nbsp;<span class=\"text-danger deleteButton\" title=\"Delete Record\"><i class=\"fas fa-trash-alt\" id=\"' + data + '\" style=\"cursor: pointer\"></i></span>';
                            },
                            searchable: false,
                            orderable: false
                        },
                    ],
                });

                $(document).off('click', '.editButton');

                $(document).on('click', '.editButton', function ($event) {
                    var employeeId = $event.target.id;
                    editEmployee(employeeId);
                });

                $(document).off('click', '.deleteButton');

                $(document).on('click', '.deleteButton', function ($event) {
                    var employeeId = $event.target.id;
                    deleteEmployee(employeeId);
                });
            });
        }

        function getAll() {
            var url = "/api/v1/employee/all";
            var employeesInfo = $http.get(url);
            employeesInfo.then(function (response) {
                ec.employees = response.data;
                console.log('employees', ec.employees);
            });
        }

        function deleteEmployee(id) {
            var url = "/api/v1/employee/delete/" + id;
            $http.get(url).then(function (response) {
                ec.employees = response.data;
                location.href = '/Home/Index';
            });
        }

        function addEmployee(employee) {
            var url = "/api/v1/employee/add";

            $http.post(url, employee).then(function (response) {
                var data = response.data;
                console.log('employee', data);
                alert('Employee Added Successfully.');
                $scope.employee = {};
            });
        }

        function editEmployee(id) {
            var url = "/Home/Edit/";
            location.href = url + id;
        }

        function setEmployee(id) {
            var url = "/api/v1/employee/" + id;
            var employeeInfo = $http.get(url);
            employeeInfo.then(function (response) {
                $scope.employee = response.data;
                $scope.employee.dob = new Date($scope.employee.dob);
            });
        }

        function updateEmployee(employee) {
            var url = "/api/v1/employee/update/";

            $http.put(url, employee).then(function (response) {
                var data = response.data;
                console.log('employee', data);
                alert('Employee Updated Successfully.');
            });
        }

        function goToHome() {
            location.href = '/Home/Index';
        }
    }
})();
