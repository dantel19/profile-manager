<script type="text/javascript" charset="utf-8">
    function findAllUsers(){
       $('#user_list').dataTable({
      	  "destroy": true,
          "bProcessing": true,
          "bServerSide": true,
          "sPaginationType": "full_numbers",
          "sAjaxDataProp": "rows",
          "aoColumns": [
              {"mData": "name"},
              {"mData": "surname"},
              {"mData": "email"},
              {"sName": "Actions",
                 "bSearchable": false,
                 "bSortable": false,
                 "sDefaultContent": "",
                 "mRender":  function(data, type, full){
                    return "<a href='${pageContext.request.contextPath}/administration/user/update?id=" + full['id'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a> "+
                            "<a href='${pageContext.request.contextPath}/administration/user/delete?id=" + full['id'] + "' class='btn btn-danger btn-xs'><i class='fa fa-folder'></i> Delete </a>";
                 }
             }
          ],
          "sAjaxSource": "${pageContext.request.contextPath}/administration/user/findallpaginated",
          "fnServerParams": addparams
      }).columnFilter({
         aoColumns: [{type: "number"},
            {type: "text"},
            {type: "text"},
            null
        ]});
    }
    
	
    $(document).ready(function() {
       if ("${requestScope.view_type}" == "list" ) {
          findAllUsers();
          return;
       }
       
       $("#roles").select2({
          // maximumSelectionLength: 4,
          // placeholder: "With Max Selection limit 4",
          allowClear: true
        });
              
       if ("${requestScope.view_type}" == "delete"){
       	  $(":input[type='text']").each(function () { $(this).attr('disabled','disabled'); });
       	  $(":input[type='password']").each(function () { $(this).attr('disabled','disabled'); });
	      $("#roles").prop("disabled", true);
       }
	});
   
</script>