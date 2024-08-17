function validate()
{
    var success=true;
    uid=document.getElementById("uid").value;
    password=document.getElementById("pwd").value;
    if(uid==="")
    {
        sp1.document.getElementsByClassName("sp1");
        sp1.innerHTML("UserId Required!");
        sp1.style.color="red";
        success=false;
    }
    if(password==="")
    {
        sp2.document.getElementsByClassName("sp2");
        sp2.innerHTML("UserId Required!");
        sp2.style.color="red";
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
   ajaxReq.open("post","LoginControllerServlet",true);
   ajaxReq.setRequestHeader("Content-type","application/x-www-form-urlencoded");
   var qry="uid="+uid+"&pwd="+password;
   ajaxReq.send(qry);
}
function processresponse()
{
    if(ajaxReq.readyState===4){
        sp4=document.getElementById("sp3");
        var rq=ajaxReq.responseText;
        sp4.innerHTML=rq;
    }
}

