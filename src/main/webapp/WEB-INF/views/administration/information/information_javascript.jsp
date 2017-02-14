<script type="text/javascript" charset="utf-8">
    function findAllInformation(){
       var informationTable = $('#information_list').dataTable({
      	  "destroy": true,
          "bProcessing": true,
          "bServerSide": true,
          "sPaginationType": "full_numbers",
          "sAjaxDataProp": "rows",
          "aoColumns": [
              {"mData": "id"},
              {"mData": "description"},
              {"sName": "Actions",
                 "bSearchable": false,
                 "bSortable": false,
                 "sDefaultContent": "",
                 "mRender":  function(data, type, full){
                    return "<a href='${pageContext.request.contextPath}/administration/information/update?id=" + full['id'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a> "+
                            "<a href='${pageContext.request.contextPath}/administration/information/delete?id=" + full['id'] + "' class='btn btn-danger btn-xs'><i class='fa fa-folder'></i> Delete </a>";
                 }
             }
          ],
          "columnDefs": [
             { 
                "bSearchable": true, 
                "bVisible" : false,
                "aTargets": [ 0 ]
             },
           ],
          "sAjaxSource": "${pageContext.request.contextPath}/administration/information/findallpaginated",
          "fnServerParams": addparams
      }).columnFilter({
         aoColumns: [
            {type: "number"},
            {type: "text"},
            null
        ],
        "bUseColVis": true
        });
    }
	
    $(document).ready(function() {
       if ("${requestScope.view_type}" == "list" ) {
          findAllInformation();
          return;
       }
       
       $("#categorySet").select2({
          // maximumSelectionLength: 4,
          // placeholder: "With Max Selection limit 4",
          allowClear: true
        });
       
       if ("${requestScope.view_type}" == "delete"){
      	  $(":input[type='text']").each(function () { $(this).attr('disabled','disabled'); });
      	  $("#categorySet").prop("disabled", true);
      }
              
	});
   
</script>