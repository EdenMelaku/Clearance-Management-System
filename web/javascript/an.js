
 /*  ***************CMS**********************  */

            var filters = ['hide_ida', 'hide_fname', 'hide_lname', 'hide_prog', 'hide_dep'];

            function ExcludeRows(cls) {

                var skipRows = [];

                for (i = 0; i < filters.length; i++)
                    if (filters[i] != cls)
                        skipRows.push(filters[i]);

                var pattern = skipRows.join('|')

                return pattern;
            }

            function Filter(srcField) {

                // var node = srcField.parentNode;
                var index = srcField.parentNode.cellIndex;

                //all the DATA rows
                var dataRows = document.getElementsByClassName("aa");

                //ensure that dataRows do not have any filter class added already
                var kids = dataRows.length;
                var filter = 'hide_' + srcField.id;

                var pattern = ExcludeRows(filter);

                var skipRow = new RegExp(pattern, "gi");

                var searchReg = new RegExp('^' + srcField.value, 'gi');

                var replaceCls = new RegExp(filter, 'gi');

                for (i = 0; i < kids; i++) {
                    //skip if already filter applied  

                    if (dataRows[i].className.match(skipRow))
                        continue;

                    //now we know which column to search
                    //remove current filter
                    dataRows[i].className = dataRows[i].className.replace(replaceCls, '');

                    if (!dataRows[i].cells[index].innerHTML.trim().match(searchReg))
                        dataRows[i].className = dataRows[i].className + ' ' + filter;
                }
            }
            /*  ***************CMS**********************  */


