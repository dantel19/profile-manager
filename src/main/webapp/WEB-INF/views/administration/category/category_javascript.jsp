<script type="text/javascript" charset="utf-8">
    function findAllCategory(){
       $('#category_list').dataTable({
      	  "destroy": true,
          "bProcessing": true,
          "bServerSide": true,
          "sPaginationType": "full_numbers",
          "sAjaxDataProp": "rows",
          "aoColumns": [
              {"mData": "id"},
              {"mData": "name"},
              {"sName": "Actions",
                 "bSearchable": false,
                 "bSortable": false,
                 "sDefaultContent": "",
                 "mRender":  function(data, type, full){
                    return "<a href='${pageContext.request.contextPath}/administration/category/update?id=" + full['id'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a> "+
                            "<a href='${pageContext.request.contextPath}/administration/category/delete?id=" + full['id'] + "' class='btn btn-danger btn-xs'><i class='fa fa-folder'></i> Delete </a>";
                 }
             }
          ],
          "columnDefs": [
             { 
                "bSearchable": true, 
                "bVisible": false, 
                "aTargets": [ 0 ]
             },
           ],
          "sAjaxSource": "${pageContext.request.contextPath}/administration/category/findallpaginated",
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
          findAllCategory();
          return;
       }
       
       if ("${requestScope.view_type}" == "delete"){
      	  $(":input[type='text']").each(function () { $(this).attr('disabled','disabled'); });
      }
              
	});
   
</script>