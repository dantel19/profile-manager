<script>
//check on div click
$(".tilesCheckbox").click(function() {
    var checkbox = $(this).find("input[type='checkbox']");

    if( checkbox.prop('checked') == false) {
        checkbox.prop('checked', true);
        $(this).prop('style', 'opacity: 0.5!important;');
        $(this).find('.icon').prop('style', 'opacity: 0.3!important;');
    } else {
        checkbox.prop('checked', false);
        $(this).prop('style', 'opacity: 1!important;');
        $(this).find('.icon').prop('style', 'opacity: 0!important;');
    }
});

$('.tilesCheckbox input[type=checkbox]').click(function(e){
        e.stopPropagation();
});
</script>