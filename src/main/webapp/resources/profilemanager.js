/*
 Profile Manager - Copyright (C) 2016  Daniele Tellina

 Profile Manager is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
  
 Profile Manager is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
  
 You should have received a copy of the GNU General Public License
 along with Profile Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
function objectFindByKey(array, key, value) {
    for (var i = 0; i < array.length; i++) {
        if (array[i][key] === value) {
            return array[i];
        }
    }
    return null;
}
function getSortCol(array) {
    var iSortColValue = objectFindByKey(array, 'name', 'iSortCol_0').value;
    var mPropsValue = objectFindByKey(array, 'name', 'mDataProp_' + iSortColValue).value;
    return mPropsValue;

}

function getSortDir(array) {
    var iSortDirValue = objectFindByKey(array, 'name', 'sSortDir_0').value;
    return iSortDirValue;

}

function addSearchFields(aoData) {
    var aSearchNames = "";
    var aSearchValues = "";
    var iColumns = objectFindByKey(aoData, 'name', 'iColumns').value;
    var searchColumns = 0;
    for (i = 0; i < iColumns; i++) {
        var searchName = objectFindByKey(aoData, 'name', 'mDataProp_' + i).value;
        var searchValue = objectFindByKey(aoData, 'name', 'sSearch_' + i).value;
        var searchable = objectFindByKey(aoData, 'name', 'bSearchable_' + i).value;
        //alert(searchName);
        //alert(searchValue);            
        if (searchable) {
            searchColumns++;
            if (searchColumns > 1) {
                aSearchNames += "|" + searchName;
                aSearchValues += "|" + searchValue;
            } else {
                aSearchNames += searchName;
                aSearchValues += searchValue;
            }
        }
    }
    aoData.push({"name": "aSearchNames", "value": aSearchNames});
    aoData.push({"name": "aSearchValues", "value": aSearchValues});

}


function addparams(aoData) {
    addSearchFields(aoData);
    aoData.push({"name": "sortCol", "value": getSortCol(aoData)});
    aoData.push({"name": "sortDir", "value": getSortDir(aoData)});
}

function formatDate(dateIn) {
    var dataToFormat = new Date(dateIn);
    var day = dataToFormat.getDate();
    var month = dataToFormat.getMonth() + 1;
    if (day < 10) {
        day = '0' + day;
    }
    if (month < 10) {
        month = '0' + month;
    }
    return  day + "/" + month + "/" + dataToFormat.getFullYear();    
}

function formatDateFromDB(dateIn) {
    if (dateIn.trim() === "") {
        return "";
    }
    var year = dateIn.slice(0,4);
    var month = dateIn.slice(5,7);
    var day = dateIn.slice(8);    
    
    return  day + "/" + month + "/" + year;    
}