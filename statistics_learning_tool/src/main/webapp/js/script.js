function getId(url) {
    const regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|&v=)([^#&?]*).*/;
    const match = url.match(regExp);
    return (match && match[2].length === 11)
      ? match[2]
      : null;
}
    


function runEmbed(url){
	const videoId = getId(url);
	console.log('//www.youtube.com/embed/'+videoId)
}



function alertWarning(msg){
	alert(msg)
}


function test(val){
	const contentDiv = document.getElementById('tester');
	const contentTest = document.getElementById('valu');
	
	console.log(contentTest)
	
	
	if(contentTest == null){
		const newItem = document.createElement('p');
		newItem.textContent = val;
		newItem.setAttribute("id","valu")
		contentDiv.appendChild(newItem);}
	else{	
	}
}




function addStudentTemp(email){
	const contentDiv = document.getElementById('usersChosen');
	const contentSend = document.getElementById('dataToBeSent');
	console.log(contentSend);
	
	if(contentSend == null){
		const newItem = document.createElement('p');
		newItem.textContent = email;
		newItem.setAttribute("id",'dataToBeSent');
		
		
		const submitBtn = document.createElement('button');
		submitBtn.innerText = email;
		submitBtn.setAttribute("name","")
		
		
		contentDiv.appendChild(newItem);
		contentDiv.appendChild(submitBtn);
		}
	else{	
	}
}



//-------Code by https://stackoverflow.com/users/1295344/scott------//
function getCount(parent, getChildrensChildren){
    var relevantChildren = 0;
    var children = parent.childNodes.length;
    for(var i=0; i < children; i++){
        if(parent.childNodes[i].nodeType != 3){
            if(getChildrensChildren)
                relevantChildren += getCount(parent.childNodes[i],true);
            relevantChildren++;
        }
    }
    return relevantChildren;
}
function tesss(){
	var element = document.getElementById("rows");
	alert(getCount(element, false));
}
//-------------------------------------------------------------------//




function checkEmptyRegister(){
	var email = document.form.email.value;
	var username = document.form.username.value;
	var first_name = document.form.first_name.value;
	var second_name = document.form.second_name.value;
	var DOB = document.form.DOB.value;
	var password  = document.form.password.value;
	
 
     if (username==null || username=="" || password==null || password=="" || email==null || email==""
     || first_name==null || first_name=="" || second_name==null || second_name=="" || DOB==null || DOB=="")
     { 
     alert("One Field is empty"); 
     return false; 
     }
}

//https://www.w3resource.com/javascript/form/password-validation.php
function CheckPassword() 
{ 
	
var inputtxt = document.form.password.value;
var passw=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$/;
if(!(passw.test(inputtxt))) 
{
	alert('Password must contain 8 characters, One number, has both upper and Lower case characters and has one special character')
	return false;
}
}


function checkRetypePassord(){
	var pass1 = document.form.fPassword.value;
	var pass2 = document.form.password.value;
	
	if(!(pass1 == pass2)){
		alert('passwords arent matching')
		return false;
	}
}

