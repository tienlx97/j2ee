
$('#date-create-from').datetimepicker({
    format: 'DD/MM/YYYY'
});
$('#date-create-to').datetimepicker({
    format: 'DD/MM/YYYY'
});
$('.select-cat-parent').selectpicker({
    // options here
});

$('#btnAddNew').click(function () {

    $('#modal_add_new').modal('show');

});

