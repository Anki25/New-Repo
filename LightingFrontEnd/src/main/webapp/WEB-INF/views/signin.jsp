<%@ include file="header.jsp" %>
   
   <center>
        
         <form method="post" action="perform_login" id="signin">
         
           <h3 style="color:#3CB371;font-weight:bold;">Sign In</h3>
                  
          <p style="color:red; text-align:center">
          ${errorMessage}
                 
         <input type="text" name="username" placeholder="ENTER YOUR USERID" required><BR><BR><BR>
         <input type="password" name="password" placeholder="ENTER YOUR PASSWORD"><BR><BR><BR>
         <input id="button" type="submit" value="SIGN IN">
        
         <p>NOT REGISTERED? <a href= "memberShip.obj">SIGN UP</a> AND GET EXCITING OFFERS</p>
        
         </form><br>
      
         </center>


<%@ include file="footer.jsp" %>