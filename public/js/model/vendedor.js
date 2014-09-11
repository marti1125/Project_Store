var Vendedor = Backbone.Model.extend({});

var Vendedores = Backbone.PageableCollection.extend({
  model: Vendedor,
  url: "/vendedores/listar",
  //Initial pagination states
  state: {
    pageSize: 15,
    sortKey: "updated",
    order: 1
  }
});

var vendedores = new Vendedores();

var columns = [
   {
    name: "id",
    label: "Id",
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
	name: "email",
	label: "Email",
	editable: false,
	cell: "string"  
  }, {
	name: "telefono",
	label: "Telefono",
	editable: false,
	cell: "string"  
  }, {
	name: "telefono_mobil",
	label: "Celular",
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
  collection: vendedores
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
	collection: vendedores
});

$paginator.append(paginator.render().el);

// Fetch some countries from the url
vendedores.fetch({reset: true});

var clientSideFilter = new Backgrid.Extension.ClientSideFilter({
	collection: vendedores,
	placeholder: "Buscar Vendedor",
	fields: ['id','apPaterno','apMaterno','nombres','email','telefono','telefono_mobil'],
	wait: 150
});

$("#filtro").prepend(clientSideFilter.render().el);
