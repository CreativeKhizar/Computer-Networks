function validate()
			{
			var fname=document.registration.fname;
			var lname=document.registration.lname;
			var gender=document.registration.gender;
			var branch=document.registration.op;
			var add=document.registration.add;
			var c=document.registration.c;
			var p=document.registration.p;
			var j=document.registration.j;
            var add=document.registration.add;
			var cplus=document.registration.cplus;
			var date=document.registration.dob;
			var pno=document.registration.pno;
            var email=document.registration.e;
            var pass=document.registration.pass;
            var resume=document.registration.resume;
            
			if(!fname.value.match("[a-zA-Z]{5,50}"))
			{
				alert("First Name Size can only be between 5 to 50 words");
				return false;
			}
			else if(!lname.value.match("[a-zA-Z]{5,50}"))
			{
					alert("Last Name Size can only be between 5 to 50 words");
					return false;
			}
			else if(!date.value)
			{
				alert("Select your Date of Birth from Calendar");
				return false;
			}
			else if(gender.value!="male" && gender.value!="female")
			{
				alert("Please Select your Gender");
				return false;
			}
			else if(!(c.checked || p.checked || cplus.checked || j.checked))
			{
				alert("Choose any one Programming Language");
				return false;
			}
            else if(!add.value.match("[a-zA-Z0-9\/\-]{6,}"))
            {
                 alert("Enter Correct Address");
                 return false;
            }
			else if(branch.value!="cse" && branch.value!="csd" && branch.value!="cai" && branch.value!="csc")
			{
				alert("Choose your Branch");
				return false;
			}
            else if(!email.value.match("[a-zA-Z0-9_\.\-]+[@][a-z]+[\.][a-z]{2,3}"))
            {
                  alert("Specify the Correct Email Address");
                  return false;
            }
            else if(!pass.value.match("[a-zA-Z0-9]{7,}"))
            {
                alert("Enter Strong Password of atleast 7 characters ")
                return false;
            }
            else if(!pno.value.match("[6-9][0-9]{9}"))
            {
                alert("Specify Correct Phone Number");
                return false;
            }
            else if(!resume.value)
            {
                alert("Provide your Resume");
                return false;
            }
			else
			{
				alert("You have Successfully Submitted the Form");
                return true;
            }
            
}
