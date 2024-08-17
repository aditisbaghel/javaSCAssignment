function validate()
{
    var success=true;
    uid=document.getElementById("userid").value;
    username=document.getElementById("username").value;
    password=document.getElementById("password").value;
    if(uid==="")
    {
        sp1.document.getElementsByClassName("sp1");
        sp1.innerHTML("UserId Required!");
        sp1.style.color="red";
        success=false;
    }
    if(username==="")
    {
        sp1.document.getElementsByClassName("sp2");
        sp1.innerHTML("UserName TRequired!");
        sp1.style.color="red";
        success=false;
    }
    if(password==="")
    {
        sp1.document.getElementsByClassName("sp3");
        sp1.innerHTML("UserId TRequired!");
        sp1.style.color="red";
        success=false;
    }
    return success;
}
function connect()
{
   if (!validate())
   {
       return;
   }
   ajaxReq=new XMLHttpRequest();
   ajaxReq.onreadystatechange=processresponse;
   ajaxReq.open("post","RegistrationControllerServlet1",true);
   ajaxReq.setRequestHeader("Content-type","application/x-www-form-urlencoded");
   var qry="uid="+uid+"&uname="+username+"&pwd="+password;
   ajaxReq.send(qry);
}
function processresponse()
{
    if(ajaxReq.readyState===4){
        sp4=document.getElementById("sp4");
        var rq=ajaxReq.responseText;
        sp4.innerHTML=rq;
    }
}

