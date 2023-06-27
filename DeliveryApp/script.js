
var hotelID = null;

function validatePhone(phone) { //Validates the phone number
    var phoneRegex = /^(\+91-|\+91|0)?\d{10}$/; // Change this regex based on requirement
    return phoneRegex.test(phone);
}
function validateEmail(email) { //Validates the email address
    var emailRegex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return emailRegex.test(email);
}


function sendOTP() {

    let input = document.getElementById("otpInput").value;
    console.log(input);


    // for mobile
    if (validatePhone(input)) {
        console.log("phoneee");
        let phoneNumber = "+91" + input;
        params = {
            phoneNumber
        }
        axios.post('http://localhost:8080/login/OTPsendToPhoneNumber', params, {
            headers: {
                contentType: 'application/json'
            }
        })
            .then(response => {
                console.log(response.data.error);
                if (response.data.error == null) {
                    localStorage.setItem("otpKey", phoneNumber);
                    window.location = "http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/OtpValidate.html";
                }
                else {
                    alert(response.data.error);
                }
            });


    }

    // for mailid
    else if (validateEmail(input)) {
        let mailId = input;
        params = {
            mailId
        }
        axios.post('http://localhost:8080/login/OTPsendToMailId', params, {
            headers: {
                contentType: 'application/json'
            }
        })
            .then(response => {
                if (response.data.error == null) {
                    localStorage.setItem("otpKey", mailId);
                    window.location = "http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/OtpValidate.html";
                }
                else {
                    alert(response.data.error);
                }
            });
    }
    else {
        alert("invalid input");
    }

}

// ------------------------------VALIDATE OTP---------------------------------------------------------------------------

function validateOtp() {
    let otp = document.getElementById("otp").value;
    let key = localStorage.getItem("otpKey");
    console.log(otp);
    console.log(key);
    params = {
        key, otp
    }
    axios.post('http://localhost:8080/login/OTPValidate', params, {
        headers: {
            contentType: 'application/json'
        }
    })
        .then(response => {
            if (response.data.error == null && response.data.data === "OTP is VALID") {
                // var a = document.getElementById("otp").value = response.data.data;
                // console.log(a);
                window.location = "http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/Home.html";
            }
            else {
                alert(response.data.error);
            }
        });

}

function hotelClick(hotelId) {

    // const home = document.getElementById("home");
    // home.style.display="none";
    // const modal = document.getElementById("myModal");
    // modal.style.display = "none";
    localStorage.setItem("hotelID", hotelId);
    // hotelID=hotelId;
    console.log(localStorage.getItem("hotelID"));
    window.location = "http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/HotelDetails.html";
}


//






// function hotelClick(hotelId) {
//     console.log(hotelId);
//     axios.get('http://localhost:8080/getOneHotelItems?hotelId=' + hotelId, {
//         headers: {
//             contentType: 'application/json'
//         }
//     }).then(response => {
//         if (response.data != null) {
//             console.log(response.data);

//             window.location  = "http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/HotelDetails.html" ;
//             console.log("hello")
//             var food = document.getElementById("hotel").value = response.data;
//             console.log(response.data);
//             for (let index in food) {
//                 const div_id = document.getElementById("hotel");
//                 // let desgin = "<div class='col-2'>" +
//                 //     "<img id='img_id' src='./images/" + hotel[index].hotelName + ".jpg' onclick='hotelClick(" + hotel[index].hotelId + ")'  />" + "<h5>" + hotel[index].hotelName + "</h5>" + "<h6>" + hotel[index].location + "</h6>" + "<div>" + "<h6>" + hotel[index].rating + "</h6>" + "</div>"
//                 // "</div>"
//                 // div_id.innerHTML += desgin;
//                 div_id.innerHTML = food[index].foodName;
//                 console.log(food[index]);
//             }
//         }
//         else {
//             alert(response.data.error);
//         }
//     });



// }

function AddCart(foodId,hotelId,price){
    console.log(foodId,hotelId,price);
    localStorage.setItem("AddCarthotelID", hotelId);
    localStorage.setItem("AddCartFoodID", foodId);
    localStorage.setItem("AddCartFoodPrice", price);
    window.location="http://127.0.0.1:5500/HTML/indexManoj.html/Swiggy/AddCart.html";

}