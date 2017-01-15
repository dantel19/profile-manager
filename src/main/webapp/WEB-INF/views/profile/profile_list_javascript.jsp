<script type="text/javascript" charset="utf-8">
    function findAllProfile(){
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
                  "mRender": function(data, type, full) {
                      return "<a href='${pageContext.request.contextPath}/profile/info?name=" + full['name'] + "&description=" + full['description'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a>";
                      
                  }
              }
          ],
          "sAjaxSource": "${pageContext.request.contextPath}/profile/discovery"
       });
    }
    
    $(document).ready(function() {
        findAllProfile();
    });

</script>