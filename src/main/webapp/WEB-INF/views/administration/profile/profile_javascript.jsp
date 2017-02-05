<script type="text/javascript" charset="utf-8">
    function findAllProfiles(){
       $('#profile_list').dataTable({
      	  "destroy": true,
          "bProcessing": true,
          "bServerSide": true,
          "sPaginationType": "full_numbers",
          "sAjaxDataProp": "rows",
          "aoColumns": [
              {"mData": "name"},
              {"mData": "description"},
              {"sName": "Actions",
                 "bSearchable": false,
                 "bSortable": false,
                 "sDefaultContent": "",
                 "mRender":  function(data, type, full){
                    return "<a href='${pageContext.request.contextPath}/administration/profile/update?id=" + full['id'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a> "+
                            "<a href='${pageContext.request.contextPath}/administration/profile/delete?id=" + full['id'] + "' class='btn btn-danger btn-xs'><i class='fa fa-folder'></i> Delete </a>";
                 }
             }
          ],
          "sAjaxSource": "${pageContext.request.contextPath}/administration/profile/findallpaginated",
          "fnServerParams": addparams
      });
    }
    
	
    $(document).ready(function() {
       if ("${requestScope.view_type}" == "list" ) {
          findAllProfiles();
          return;
       }
       
       if ("${requestScope.view_type}" == "delete"){
      	  $(":input[type='text']").each(function () { $(this).attr('disabled','disabled'); });
      }
              
	});
   
</script>