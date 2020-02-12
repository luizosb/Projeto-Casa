$('#confirmarExcluir').on('show.bs.modal', function (event) {
	 var button = $(event.relatedTarget);
	 
	 var codigoEvento = button.data('codigo');
	 var nomeEvento = button.data('nome');
	 
	 var modal = $(this);
	 var form = modal.find('form');
	 var action = form.data('url-base');
	 if(!action.endsWith('/')){
		 action+= '/';
	 }
	 form.attr('action', action + codigoEvento)
});