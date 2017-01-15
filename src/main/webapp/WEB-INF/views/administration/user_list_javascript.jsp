<script type="text/javascript" charset="utf-8">
    function findAllUser(){
       $('#user_list').dataTable({
      	  "destroy": true,
          "bProcessing": true,
          "bServerSide": true,
          "sPaginationType": "full_numbers",
          "sAjaxDataProp": "rows",
          "aoColumns": [
              {"mData": "id"},
              {"mData": "name"},
              {"mData": "surname"},
              {"sName": "Actions",
                  "bSearchable": false,
                  "bSortable": false,
                  "sDefaultContent": "",
                  "mRender":  function(data, type, full){
                     return "<a href='${pageContext.request.contextPath}/administration/user?id=" + full['id'] + "' class='btn btn-primary btn-xs'><i class='fa fa-folder'></i> View </a>";
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
          ]

      });
    }
    
    $(document).ready(function() {
        findAllUser();
    });

</script>