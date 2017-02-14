<script type="text/javascript" charset="utf-8">

	//Selectable information list
	function findAllInformation(){
	   var informationTable = $('#information_list').DataTable({
	      "aoColumnDefs": [{
	         "bSortable": false,
	         "bSearchable": false,
	         "aTargets": [ 0 ]
	      }]
	  });

   /* COLUMN FILTER */
   // Setup - add a text input to each footer cell
   $('#information_list tfoot th').each( function (i) {
       var title = $('#information_list thead th').eq( $(this).index() ).text();
       $(this).html( '<input type="text" placeholder="Search By '+title+'" data-index="'+i+'" />' );
   } );
   // Filter event handler
   $( informationTable.table().container() ).on( 'keyup', 'tfoot input', function () {
       informationTable
           .column( $(this).data('index') )
           .search( this.value )
           .draw();
   } ); 
   
   //This function re-Render input elements on datatable changes
   $('#information_list').on('draw.dt', function () {
      $('#information_list').find('input').iCheck({checkboxClass: 'icheckbox_flat-green',radioClass: 'iradio_flat-green'});
   });
   //remove sorting_asc icon on first th (added by default on datatables)
   $('#information_list th:first').removeClass ('sorting_asc');
   
   $("form").on('submit', function(e){

      var $form = $(this);
      // Iterate over all checkboxes in the table
      informationTable.$('input[type="checkbox"]').each(function(){
         // If checkbox doesn't exist in DOM
         if(!$.contains(document, this)){
            // If checkbox is checked
            if($(this).is(':checked')){
               // Create a hidden element 
               $form.append(
                  $('<input>')
                     .attr('type', 'hidden')
                     .attr('id', this.name)
                     .attr('name', this.name)
                     .val(this.value)
               );
            }
         } 
      });          
   });
   
   
   
	}
     
	//Document Ready
	$(document).ready(function() {
   
   if ("${requestScope.view_type}" == "list" ) {
      //findAllProfiles();
      return;
   }
   
   if ("${requestScope.view_type}" == "update" ) {
      findAllInformation();
      return;
   }
             
});
   
</script>