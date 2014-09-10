var Usuario = Backbone.Model.extend({});

var Usuarios = Backbone.Collection.extend({
  model: Usuario,
  url: "/usuarios/listar"
});

var usuarios = new Usuarios();

var columns = [{
    name: "usuario",
    label: "Usuario",
    editable: false,
    cell: "string"
  }, {
    name: "clave",
    label: "Clave",
    editable: false,
    cell: "string"
  }, {
    name: "apPaterno",
    label: "Ap. Paterno",
    editable: false,
    cell: "string"
  }, {
    name: "apMaterno",
    label: "Ap. Materno",
    editable: false,
    cell: "string"
  }, {
    name: "nombres",
    label: "Nombres",
    editable: false,
    cell: "string"
  }, {
    name: "esAdministrador",
    label: "¿Es Administrador?",
    editable: false,
    cell: "string"
}];

// Initialize a new Grid instance
var grid = new Backgrid.Grid({
  columns: columns,
  collection: usuarios
});

// Render the grid and attach the root to your HTML document
$("#backgrid").append(grid.render().el);

// Fetch some countries from the url
usuarios.fetch({reset: true});