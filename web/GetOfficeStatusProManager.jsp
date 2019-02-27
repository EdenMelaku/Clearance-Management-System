

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.SQLException"%>
<%@page import="clearance_management.user"%>
<%@page import="model.read"%>
<%@page import="otherService.stakeholderrow"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="otherService.StudentClearanceInfo" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false"  buffer="10kb"%>

<head>
    <meta charset="utf-8">
    <title>CMS</title>
    <link rel="stylesheet" href="css/StyleOne.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/my_style.css">
    <link rel="stylesheet" href="css/StatusProgramManager.css">
    <script src="javascript/an.js"></script>

    <style type="text/css">
        #tt{
            position: absolute;
            top: calc(27% - 35px);
            left: calc(35% - 220px);
            width: 79%;
        }

        #idNum{
            width:7.5%;
            /**  color: #007090;*/
            /**   font-size: 17px;*/
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: left;  
        } #name{
            width:6%;
            /*   color: #007090;*/
            /** font-size: 17px;*/
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: left; 
            text-transform: capitalize

        }
        #caffe{
            width: 8%;
            color: #007090;;
            font-size: 17px;
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;  
        }   #dh{
            width: 9%;
            color: #007090;;
            font-size: 20px;
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;  
        }
        #refresh{
            width:3%;
        }
        .ab{
            text-align: left;
            text-transform: capitalize
        }
        .myField100{
            width:100px

        }#program{

            width:5%;

        }#sta{

            width:5.75%;

        }


    </style>

</head>
<body style = "background-color:#DFE2DB;color:black;">
    <div class="header">
        <div class="navbar navbar-fixed-top">
            <jsp:include page="Common.jsp"/>
        </div>
    </div>
    <%!
        String username = null;
        String firstname = null;
    %>
    <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />
    <%
        username = (String) request.getAttribute("username");
        firstname = (String) request.getAttribute("firstname");
        stakeholderrow[] dataAdv = (stakeholderrow[]) request.getAttribute("advisor");
        stakeholderrow[] dataDep = (stakeholderrow[]) request.getAttribute("departmenthead");
        stakeholderrow[] dataFuc = (stakeholderrow[]) request.getAttribute("facultystore");

    %>

    <div class="menu">
        <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                <div class="textwidget"><ul>
                        <li>
                            <a href="getofficeStatusServlet?username=<%=bean.getUsername()%>">
                                Get Office Status</a></li>
                        <li>   <a href= "ManageAccountServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                Manage An Account</a>
                        </li>
                        <li>
                            <a href="createAccountServlet1?username=<%=bean.getUsername()%>"accesskey="1" title="">
                                Create An Account</a></li>

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
    <div  class="student_table" id="tt">
        <table class="testTable">         
            <thead id="head">

                <tr>
                    <td><input type="text"class="myField10" ID="id"  placeholder="Search By Id..." onkeydown="Filter(this)" ></td>
                    <td><input type="text"class="myField10" ID="fname" placeholder="First Name..."   onkeydown="Filter(this)" /></td>
                    <td id="program" >  <select class="form-control" id="prog"  class="myCombo"  value="Search By Program" onclick="Filter(this)">
                            <option  value="advisor" onkeydown="Filter(this)" >Advisor</option>
                            <option value="departmenthead" onkeydown="Filter(this)">Department Head</option>
                            <option value="facultystore" onkeydown="Filter(this)">Faculty Store</option></select>
                    </td>
                    <td id="refresh">
                        <a href="getofficeStatusServlet?username=<%= request.getAttribute("username")%>" >Refresh</a>
                    </td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th> Name</th>
                    <th>Approved By</th>
                    <th>Approval Date</th>
                    <th id="sta"> Status </th>
                </tr>
            </thead>
            <tfoot>
            </tfoot>

            <tbody class="bbbb">
                <%
                    int a = 0;
                    String em = null;
                %>
                <%for (int i = 0; i < (dataAdv.length - 1); i++) {%>
                <tr class="aa">
                    <th id="idNum"><%= dataAdv[i].getId()%></th>
                    <th id="name"><%= read.getStudent(dataAdv[i].getId()).getFirstName()%><% out.print("  ");%><%=read.getStudent(dataAdv[i].getId()).getLastname()%></td>
                    <th hidden>advisor </td>
                    <th><%= dataAdv[i].getApprovedby()%></td>
                    <th><%= dataAdv[i].getApprovalDate()%></td>
                    <th><%= dataAdv[i].getStatus()%></td>
                </tr>
                <%}%>
                <%for (int i = 0; i < (dataAdv.length - 1); i++) {%>
                <tr class="aa">
                    <th id="idNum"><%= dataDep[i].getId()%></th>
                    <th id="name"><%= read.getStudent(dataDep[i].getId()).getFirstName()%><% out.print("  ");%><%=read.getStudent(dataDep[i].getId()).getLastname()%></td>
                    <th hidden>departmenthead </td>
                    <th><%= dataDep[i].getApprovedby()%></td>
                    <th><%= dataDep[i].getApprovalDate()%></td>
                    <th><%= dataDep[i].getStatus()%></td>
                </tr>
                <%}%>
                <%for (int i = 0; i < (dataAdv.length - 1); i++) {%>
                <tr class="aa">
                    <th id="idNum"><%= dataFuc[i].getId()%></th>
                    <th id="name"><%= read.getStudent(dataFuc[i].getId()).getFirstName()%><% out.print("  ");%><%=read.getStudent(dataFuc[i].getId()).getLastname()%></td>
                    <th hidden>facultystore </td>
                    <th><%= dataFuc[i].getApprovedby()%></td>
                    <th><%= dataFuc[i].getApprovalDate()%></td>
                    <th><%= dataFuc[i].getStatus()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</div>
<%!
    public String status(int sta) {
        String status = null;
        if (sta == 2) {
            status = "In Hold";
        } else if (sta == 1) {
            status = "Cleared";
        } else if (sta == 0) {
            status = "Fully Cleared";
        } else if (sta == 4) {
            status = "Deactivated";
        }
        return status;
    }



   



%>
<div class="loc">
    <jsp:include page="Developers.jsp"/>
</div>   
</body>