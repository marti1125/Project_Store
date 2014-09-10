var Usuario = Backbone.Model.extend({});

var Usuarios = Backbone.PageableCollection.extend({
  model: Usuario,
  url: "/usuarios/listar",
  //Initial pagination states
  state: {
    pageSize: 15,
    sortKey: "updated",
    order: 1
  }
});

var usuarios = new Usuarios();

var columns = [{
    name: "usuario",
    label: "Usuario",
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

var $paginator = $("#paginator");
$paginator.append(grid.render().el);

// Render the grid and attach the root to your HTML document
$("#backgrid").append(grid.render().el);

var paginator = new Backgrid.Extension.Paginator({
	// If you anticipate a large number of pages, you can adjust
	// the number of page handles to show. The sliding window
	// will automatically show the next set of page handles when
	// you click next at the end of a window.
	windowSize: 20, // Default is 10
	// Used to multiple windowSize to yield a number of pages to slide,
	// in the case the number is 5
	slideScale: 0.25, // Default is 0.5
	// Whether sorting should go back to the first page
	goBackFirstOnSort: false, // Default is true
	collection: usuarios
});

$paginator.append(paginator.render().el);

// Fetch some countries from the url
usuarios.fetch({reset: true});

var clientSideFilter = new Backgrid.Extension.ClientSideFilter({
	collection: usuarios,
	placeholder: "Buscar Usuario",
	fields: ['usuario','apPaterno','apMaterno','nombres','esAdministrador'],
	wait: 150
});

$("#filtro").prepend(clientSideFilter.render().el);
