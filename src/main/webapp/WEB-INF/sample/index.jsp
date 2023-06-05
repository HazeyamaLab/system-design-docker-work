<%@ page import="model.Sample" %> 
<%@ page import="java.util.ArrayList"%> 
<%@ page import = "java.util.List" %> 
<% List<Sample> sampleList = (ArrayList<Sample>)request.getAttribute("sampleList"); %> 
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <body>
    <% if(sampleList.size() > 0) { 
      for(Sample sample : sampleList) { %>
        <h1 align="center"><%=sample.getContent() %></h1>
      <% }
    }else{ %> 
    <% } %>
  </body>
</html>
