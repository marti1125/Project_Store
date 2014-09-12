var Tienda = Backbone.Model.extend({});

var Tiendas = Backbone.PageableCollection.extend({
  model: Tienda,
  url: "/tiendas/listar",
  //Initial pagination states
  state: {
    pageSize: 15,
    sortKey: "updated",
    order: 1
  }
});

var tiendas = new Tiendas();

var columns = [
   {
    name: "codigo",
    label: "Codigo",
    editable: false,
    cell: "string"
  }, {
    name: "nombre",
    label: "Nombre",
    editable: false,
    cell: "string"
  }, {
    name: "direccion",
    label: "Dirección",
    editable: false,
    cell: "string"
  }, {
    name: "telefono",
    label: "Telefono",
    editable: false,
    cell: "string"
  }, {
	name: "usuario",
	label: "Usuario",
	editable: false,
	cell: "string"
  }, {
	name: "actualizar",
	label: "Actualizar",
	editable: false,
	cell: Backgrid.Cell.extend({
		 render: function () {	 		
		 	this.$el.html('<a href="#" class="btn btn-primary"><i class="fa fa-pencil-square-o"></i></a>');
	 		return this;
		 }  
    })
  }
];

// Initialize a new Grid instance
var grid = new Backgrid.Grid({
  columns: columns,
  collection: tiendas
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
	collection: tiendas
});

$paginator.append(paginator.render().el);

// Fetch some countries from the url
tiendas.fetch({reset: true});

var clientSideFilter = new Backgrid.Extension.ClientSideFilter({
	collection: tiendas,
	placeholder: "Buscar Tienda",
	fields: ['codigo','nombre','direccion','telefono','usuario'],
	wait: 150
});

$("#filtro").prepend(clientSideFilter.render().el);
