<%@page import="clearance_management.StudentBean"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" errorPage="MyErrorPage.jsp" buffer="10kb"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>CMS</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/my_style.css">
        <link rel="stylesheet" href="css/NewTable.css">
        <script src="javascript/an.js"></script>
        <style type="text/css">

            .btn{
                color:black
            }  
            #msgF{
                font-size: 20px;
                width: 10%;
                background-color:#F00;
            }
            #msgSuccess{
                font-size: 20px;
                background-color:green;

            }
            #tt{
                position: absolute;
                top: calc(24% - 35px);
                left: calc(38% - 240px);
                width: 79%;
                /**  background-color: #AAA*/
            }
            #program{
                width:23%;
            } #department{
                width:22%;
            }
            .chkdata{
                width: 55px;

            }
            #name{
                text-transform: capitalize;
                text-align: left
            }
        </style>
        
        <script type="text/javascript">
            var ss = [];
            count = 0;
            function GetValues() {
                ckbox = document.getElementsByClassName("chkdata");
                for (var i = 0; i < ckbox.length; i++) {
                    element = ckbox[i];
                    if (element.checked) {
                        ss[count] = i;
                        count++;
                    }
                }
                count = 0;
                return ss;
            }

            function func()
            {
                GetValues();
                document.myform.varlet.value = ss;
                document.myform.arraylength.value = ss.length;
            }

        </script>
        <link rel="stylesheet" href="my_style.css" type="text/css">
    </head>
    <body style = "background-color:#DFE2DB;color:black;">
        <div class="header">
            <section id="header" class="appear">
                <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:red ;" data-300="line-height:60px; height:60px; background-color:red;">
                    <jsp:include page="Common.jsp"/>
                </div>
            </section>
        </div>
        <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />
        <%!
            public StudentBean[] stud;
            public String[] sid;
            public String fname = null;
            public String[] toJs = null;
            public int len;
        %>

        <%
            stud = (StudentBean[]) request.getAttribute("student");
            fname = (String) request.getAttribute("name");
            bean.setUsername((String) request.getAttribute("username"));
            bean.setUserRole((String) request.getAttribute("userrole"));
            bean.setOffice((String) request.getAttribute("office"));
            len = stud.length;

        %>

        <%!
            int vv() {
                return stud.length;
            }
        %>
        <div class="menu">
            <div class="menu">
                <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                        <div class="textwidget"><ul>
                                <li><a href="FilterForStudentDean?username=<%=bean.getUsername()%>" >
                                        Student Dean</a></li>
                                <li>
                                    <a href="FilterForUpdateServlet?username=<%=bean.getUsername()%>" >
                                        Update Clearance Status</a></li>     

                                <li><a href="GetStudentStatusServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                        Get Student Status</a>  </li>
                                <li>      <a href="logoutServlet">
                                        Logout(<%=fname%>)</a></li>
                            </ul>
                        </div>
                </ul>
            </div>
        </div>
        <form name="myform" class="student_table" id="tt" method="post" action="UpdateClearanceStatusServlet" >            &nbsp;&nbsp;&nbsp;&nbsp;

            <!--
        <div id="msgSuc">
            ${msgSuccess}
        </div>
    </div--><div id="msgF">
                ${msg}
            </div>
            <table class="testTable">     
                <thead id="head">

                    <tr>
                        <td><input type="text"class="myField" ID="id"  placeholder="Search By Id..." onkeydown="Filter(this)" >
                        <td><input type="text"class="myField" ID="fname" placeholder="First Name..."   onkeydown="Filter(this)" /></td>
                        <td><input type="text"class="myField" ID="lname"        placeholder="Last Name..."  onkeydown="Filter(this)" /></td>  
                        <!--td><input type="text" class="myField" ID="naselje"   placeholder="Search By Program"  onkeydown="Filter(this)" /></td-->
                        <td>
                            <select id="prog" class="form-control" class="myCombo"  value="Search By Program" onclick="Filter(this)">
                                <option  value="ur"  >Undergraduate Regular</option>
                                <option  value="us" >Undergraduate Summer</option>
                                <option value="ue" >Undergraduate Extension</option>
                                <option  value="pr">Postgraduate Regular</option>
                                <option  value="ps" >Postgraduate Summer</option>
                            </select>
                        </td>
                        <td>
                            <!--input type="checkbox" value="software eng" id="zupanija" name="departmentName"onkeydown="Filter(this)"-->
                            <!--select id="dep" class="myCombo" value="Search By Department" onclick="Filter(this)"-->
                            <select  id="dep" class="form-control" class="myCombo" value="Search By Department" onclick="Filter(this)">
                                <option  value="Software Engineering" onkeydown="Filter(this)" >Software Engineering</option>
                                <option value="Civil Engineering" onkeydown="Filter(this)">Civil Engineering</option>
                                <option value="Computer scince" onkeydown="Filter(this)">Computer Science</option>
                                <option value="Automotive Engineering" onkeydown="Filter(this)">Automotive Engineering</option>
                                <option value="Computer Engineering" onkeydown="Filter(this)">Computer Engineering</option>
                            </select>
                        </td>
                        <td>
                            <a href="FilterForStudentDean?username=<%=bean.getUsername()%>" class="refreshLink">Refresh</a>
                        </td>
                        <!--td><input type="text" ID="zupanija"   onkeydown="Filter(this)" /></td-->     
                    </tr>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Program</th>
                        <th>Department</th>
                        <th>section</th>
                        <th>Approve<br>
                            <input type="checkbox" onchange ="selection();">Select All</div>
                        </th>
                    </tr>
                </thead>
                <script type="text/javascript">
                    function selection() {
                    <% for (int t = 0; t < vv(); t++) {%>
                    <%= idAssign(t)%>.click();
                    <%}%>
                    }

                </script>
                <tbody class="bbbb">
                    <!--div style="height:400px; overflow: scroll"--> 
                    <%for (int i = 0; i < stud.length; i++) {%>
                    <tr class="aa"> 
                        <th><%= stud[i].getId()%></th>
                        <th id="name"><%= stud[i].getFirstName()%></th>
                        <th id="name"><%= stud[i].getLastname()%></th>
                        <th id="program"><%= stud[i].getProgram()%></th>
                        <th id="department"><%= stud[i].getDepartment()%></th>
                        <th><%= stud[i].getSection()%></th>
                        <th><input type="checkbox"  class="chkdata" id=<%=idAssign(i)%>  /></th>
                    </tr>     
                    <%}%>
                </tbody>
                <tfoot class="footer">         

                    <%!
                        public String idAssign(int n) {
                            String h = null;
                            h = "cb" + n;
                            return h;
                        }
                                                                        %>
                    <tr>
                        <td>
                            <div class="btn">
                                <input type="hidden" name="arraylength">
                                <input type="hidden" name="username" value=<%= bean.getUsername()%>>
                                <input type="hidden" name="length" value=<%= stud.length%>>
                                <input type="hidden" name="varlet"/>
                                <% for (int i = 0; i < stud.length; i++) {%>
                                <input type="hidden" name="studentsIdNum[<%= i%>]" value=<%= stud[i].getId()%>>
                                <%}%>
                                <input type="submit" class="lo" name = "Submit" value ="Finish" onclick ="func()"/>
                                <input type="reset" class="lo" value ="Cancel" />

                            </div>
                        </td>           
                    </tr>
                </tfoot>
            </table>
        </form>
        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div> 
    </body>
</html>
