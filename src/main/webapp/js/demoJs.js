

function validateForm() {
	  let username = document.forms["form"]["Username"].value;
	  let password = document.forms["form"]["password"].value;
	  if (username == "" || password=="") {
		  
	    alert("Username and password must be required");
	    return false;
	  }

	}




