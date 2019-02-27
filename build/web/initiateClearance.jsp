<%@page import="javax.swing.JOptionPane"%>
<%@page import="clearance_management.StudentBean"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" errorPage="MyErrorPage.jsp" buffer="10kb"%>

<html>
    <head>  
        <!-- BASICS -->
        <meta charset="utf-8">
        <title>CMS</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/my_style.css">
        <link rel="stylesheet" href="css/InitiateTable.css">
        <script src="javascript/an.js"></script>

        <style type="text/css">

            #tt{
                position: absolute;
                top: calc(27% - 35px);
                left: calc(38% - 243px);
            }
            #msgF{
                width: 33%;
                color: white;
                font-size: 20px;
                background-color:#F00;
            }
            #msgSuc{
                width: 45%;
                color: white;
                font-size: 25px;
                background-color:green;

            }

            .initiateBtn{
                width: 100px;
                color: red;
                background-color: #0199d9 ;
                font-size: 20pt;
                font-family: times new roman;
            }

            #program{
                width:21.025%;
            } #department{
                width:20.2%;
            }
            .chkdata{
                width: 75px;
            }
            #name{
                text-transform: capitalize;
                text-align: center;
                width: 17.35%;

            }#name2{
                text-transform: capitalize;
                text-align: left;
                width: 17.35%;

            }
            #sid{
                width: 17%;
            } 
            #sec{
                width: 5.65%;
            }  
            #yy{
                width:11.08%;

            }
        </style>
        <script type="text/javascript">

            var ss = [];
            var aa = [];
            count = 0;
            function GetValues() {
                ckbox = document.getElementsByClassName("chkdata");
                aa = document.getElementsByName("sid");
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
            function selectedValues() {
                return ss;
            }
            function func()
            {
                GetValues();
                document.myform.varlet.value = ss;
                document.myform.arraylength.value = ss.length;
            }

        </script>
        <link rel="stylesheet" href="my_style.css" type="text/css" media="screen, projection" />
    </head>
    <body style = "background-color:#DFE2DB;color:black;">

        <div class="header">
            <div class="navbar navbar-fixed-top">
                <jsp:include page="Common.jsp"/>
            </div>
        </div>
        <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

        <%!
            public StudentBean[] stud;
            public String[] sid;

            public String[] sids() {
                return sid;
            }
            public int len;

        %>

        <%

            stud = (StudentBean[]) request.getAttribute("stud");
            sid = (String[]) request.getAttribute("sid");
            bean.setUsername((String) request.getAttribute("username"));
            bean.setUserRole((String) request.getAttribute("userRole"));
            bean.setOffice((String) request.getAttribute("office"));
            len = stud.length;
        %>

        <%!     int vv() {
                return len;
            }
        %>
        <div class="menu">
            <div class="menu">
                <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                        <div class="textwidget"><ul>
                                <li> 
                                    <a href="initiateClearance1?username=<%=bean.getUsername()%>&amp; userRole=<%=bean.getUserRole()%>" accesskey="1" title="">
                                        Initiate Clearance</a> </li>              
                                <li>
                                    <a href="ApproveClearanceFilterServlet?username=<%= bean.getUsername()%>" >
                                        Approve Clearance Status</a></li>

                                <li><a href="GetStudentStatusServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                        Get Student Status</a>  </li>

                                <li>  
                                    <a href="ChangePasswordServlet2?username=<%= bean.getUsername()%>">
                                        Change Password</a></li>
                                <li>  
                                    <a href="logoutServlet">
                                        Logout(<%=bean.getFirstName().toUpperCase()%>)</a></li>
                            </ul>
                        </div>
                </ul>
            </div>
        </div>

        <!-------search ----------->
        <form  class="student_table" name="myform" id="tt" method="post" action="initiateClearance2">
            <div name="re">
                <div id="mainselection" class="myCombo" >
                    <select  name="reasonChoice">
                        <option>Select the Reason</option>
                        <option value="End Of Academic Year">End Of Academic Year</option>
                        <option name="Graduation">Graduation</option>
                        <option value="Disciplinary Case">Disciplinary Case</option>
                        <option value="Academic Dismisal">Academic Dismissal</option>
                        <option value="Withdrawal due to Family Problem">Family Problem</option>
                        <option value="Withdrawal due to Health Problem">Withdrawal due to Health Problem</option>
                        <option value="Forced Withdrawal">Forced Withdrawal</option>
                        <option name="Other">Other</option>
                    </select><br>

                </div>  
                <div id="msgF">
                    ${msg}
                </div>
                <div id="msgSuc">
                    ${msgSuccess}
                </div>
            </div>
            <!--table class="responsive-table1"-->         
            <table class="testTable">     
                <thead id="head">

                    <tr>
                        <td><input type="text"class="myField10" ID="id"  placeholder="Search By Id..." onkeydown="Filter(this)" >
                        <td><input type="text"class="myField10" ID="fname" placeholder=" Name..."   onkeydown="Filter(this)" /></td>
                        <td>  <select id="prog" class="form-control" class="myCombo"  value="Search By Program" onclick="Filter(this)">
                                <option  value="ur"  >Undergraduate Regular</option>
                                <option  value="us" >Undergraduate Summer</option>
                                <option value="ue" >Undergraduate Extension</option>
                                <option  value="pr">Postgraduate Regular</option>
                                <option  value="ps" >Postgraduate Summer</option>
                            </select>
                        </td>
                        <td>
                            <select  id="dep" class="form-control" class="myCombo" value="Search By Department" onclick="Filter(this)">
                                <option  value="Software Engineering" onkeydown="Filter(this)" >Software Engineering</option>
                                <option value="Civil Engineering" onkeydown="Filter(this)">Civil Engineering</option>
                                <option value="Computer scince" onkeydown="Filter(this)">Computer Science</option>
                                <option value="Automotive Engineering" onkeydown="Filter(this)">Automotive Engineering</option>
                                <option value="Computer Engineering" onkeydown="Filter(this)">Computer Engineering</option>
                            </select>
                        </td>
                        <td>
                            <a href="initiateClearance1?username=<%=bean.getUsername()%>" class="refreshLink">Refresh</a>
                        </td>
                    </tr>
                    <tr>
                        <th id="sid">ID</th>
                        <th id="name"> Name</th>
                        <th>Program</th>
                        <th>Department</th>
                        <th>Batch</th>
                        <th>section</th>
                        <th>Initiate<br>
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
                        <th id="sid"><%= stud[i].getId()%></th>
                        <th id="name2"><%= stud[i].getFirstName()%><% out.print("    ");%><%= stud[i].getLastname()%></th>
                        <th id="program"><%= stud[i].getProgram()%></th>
                        <th id="department"><%= stud[i].getDepartment()%></th>
                        <th id="yy"><%= stud[i].getYear()%></th>
                        <th id="sec"><%= stud[i].getSection()%></th>
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
            <!-- </div> --> 
        </div>
    </form>
    <div class="loc">
        <jsp:include page="Developers.jsp"/>
    </div>
</body>
</html>
