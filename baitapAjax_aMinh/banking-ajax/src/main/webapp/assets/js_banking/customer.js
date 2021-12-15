// class Customer{
//     constructor(id ,fullName,email,phone,address,balance) {
//         this.id = id;
//         this.fullName = fullName;
//         this.email = email;
//         this.phone = phone;
//         this.address = address ;
//         this.balance = balance;
//     }
// }

function addNewCustomer() {
    //lay du lieu
    let fullName = $('#fullName').val();
    let email = $('#email').val();
    let phone = $('#phone').val();
    let address = $('#address').val();

    let newCustomer = {
        fullName: fullName,
        email: email,
        phone: phone,
        address: address,
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newCustomer),
        //tên API
        url: "/api/customers",
        //xử lý khi thành công
        success: function () {
            alert("Create success !")
            clear();
            showCustomers();


        },
        error: function () {
            alert("Create fail !")
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
    // return false;
}

function clear() {
    $('#fullName').val("");
    $('#email').val("");
    $('#phone').val("");
    $('#address').val("");

}


function showCustomers() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/api/customers",
        //xử lý khi thành công
        success: function (data) {
            console.log(data)
            // hien thi danh sach o day
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += getCustomers(data[i]);
            }
            document.getElementById('showListCustomers').innerHTML = content;
            // ${'#showListCustomers'}.html(content)

        }
    });
}

function getCustomers(customer) {
    return `<tr>
            <td>${customer.id}</td>
            <td>${customer.fullName}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
            <td>${customer.address}</td>
            <td style="text-align: right">${customer.balance}</td>
            <td>
                <button type="button"  class="btn btn-outline-secondary"
                   data-toggle="tooltip" data-placement="top" title="Edit"
                data-id="${customer.id}">
                    <i class="far fa-edit"></i>
                </button>
            </td>
            <td>
                <button type="button"  class="btn btn-outline-success"
                   data-toggle="tooltip" data-placement="top" title="Desposit"
                   data-id="${customer.id}"><i class="far fa-plus-square"></i>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-warning"
                   data-toggle="tooltip" data-placement="top" title="Withdraw"
                   data-id="${customer.id}"><i class="fas fa-minus"></i></button>
            </td>
            <td>
                <button type="button"  class="btn btn-outline-primary"
                   data-toggle="tooltip" data-placement="top" title="Transfer"
                  data-id="${customer.id}"> <i class="fas fa-exchange-alt"></i></button>
            </td>
            <td>
                <button type="button"  class="btn btn-outline-danger"
                   data-toggle="tooltip" data-placement="top" title="Suspended"
                 data-id="${customer.id}"><i class="fas fa-ban"></i></button>
            </td>
        </tr>`
}

showCustomers()