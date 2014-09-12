var EntradaDeProducto = Backbone.Model.extend({});

var EntradasDeProductos = Backbone.PageableCollection.extend({
  model: EntradaDeProducto,
  url: "/entradasdeproductos/listar",
  //Initial pagination states
  state: {
    pageSize: 15,
    sortKey: "updated",
    order: 1
  }
});

var entradasDeProductos = new EntradasDeProductos();

var columns = [
   {
    name: "id",
    label: "Id",
    editable: false,
    cell: "string"
  }, {
    name: "productoDetalle",
    label: "Producto Detalle",
    editable: false,
    cell: "string"
  }, {
    name: "cantidad",
    label: "Cantidad",
    editable: false,
    cell: "string"
  }, {
    name: "fechaDeEntrada",
    label: "Fecha",
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
  collection: entradasDeProductos
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
	collection: entradasDeProductos
});

$paginator.append(paginator.render().el);

// Fetch some countries from the url
entradasDeProductos.fetch({reset: true});

var clientSideFilter = new Backgrid.Extension.ClientSideFilter({
	collection: entradasDeProductos,
	placeholder: "Buscar Entrada de Producto",
	fields: ['id','productoDetalle','cantidad','fechaDeEntrada'],
	wait: 150
});

$("#filtro").prepend(clientSideFilter.render().el);
