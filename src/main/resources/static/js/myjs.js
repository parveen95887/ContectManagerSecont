
const togleslidebar = () =>{
 if($("#left").is(":visible")){
    
    $("#left").css("display","none");
    $("#right").css("margin-left","0%");
    $("#right").css("width","100%");
 }else{
   
    $("#left").css("display","block");
    $("#right").css("margin-left","20%");
 }

};






