function formValidation()
{
var fname = document.registration.firstname;
var lname = document.registratoin.lastname;
var uemail = document.registration.email;
var uname = document.registration.username;
var passid = document.registration.password;

if(allLetter(fname)){
    if(allLetter(lname)){
        if(ValidateEmail(uemail)){
if(uname_validation(uname,5,12)) {
        if(passid_validation(passid, 7,12)){
 
                            }
                        }
} 
}
}
return false;
}

//individual functions
function allLetter(fname)
{ 
var letters = /^[A-Za-z]+$/;
if(fname.value.match(letters)) 
{
return true;
}
else
{
alert('Name must have alphabet characters only');
fname.focus();
return false;
}
}

function allLetter(lname)
{ 
var letters = /^[A-Za-z]+$/;
if(lname.value.match(letters)) 
{
return true;
}
else
{
alert('Name must have alphabet characters only');
lname.focus();
return false;
}
}

function ValidateEmail(uemail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(uemail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
uemail.focus();
return false;
}
}

function uname_validation(uname,mx, my)
{
var uid_len = uid.value.length;
if (uid_len == 0 || uid_len >= my || uid_len < mx)
{
alert("User Id should not be empty / length be between "+mx+" to "+my);
uid.focus();
return false;
}
return true;
}

function passid_validation(passid, mx,my)
{
    
var passid_len = passid.value.length;

if (passid_len == 0 ||passid_len >= my || passid_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
passid.focus();
return false;
}
return true;
}