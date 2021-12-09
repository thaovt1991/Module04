let customers = [
    [1, "Tuong", "tuong@gmail.com", "123456", "0972748562", "12 Ly Thai To",true],
    [2, "Minh", "asdasdasdasdasdasd@gmail.com", "123456", "0942468213", "12 Cong Uan",true],
    [3, "Tuan Ngoc", "asd@gmail.com", "123456", "513552468124", "Le Huaan",true]
]
let num = customers.length - 1

function onLoadPage() {
    let str = ""
    for (let i = customers.length - 1; i >= 0; i--) {
        if (customers[i][6]) {
            str += `<tr>
            <th scope="row">` + customers[i][0] + `</th>
            <td>` + customers[i][1] + `</td>
            <td>` + customers[i][2] + `</td>
            <td>` + customers[i][4] + `</td>
            <td>` + customers[i][5] + `</td>
            <td>
                <a type="button" class="btn btn-outline-secondary" data-bs-toggle="modal"
                    data-bs-target="#modalEdit" id = 'editCustomer` + i + ` ' onclick= 'editCustomer(this.id)'>
                    <i class="far fa-edit"></i> Edit
                </a>
            </td>
            <td>
                <a type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                    data-bs-target="#modalDelete" id = 'deleteCustomer` + i + ` ' onclick= 'deleteCustomer(this.id)'>Delete
                </a>
            </td>
        </tr>`
        }
    }
    document.getElementById("showCustomers").innerHTML = str;
}

function addCustomer() {
    let name = document.getElementById("fullName").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let rePassword = document.getElementById("rePassword").value;
    let phone = document.getElementById("phone").value;
    let address = document.getElementById("address").value;
    if (password != rePassword) {
        alert("Password khong dung !")
    } else {
        let size = customers.length
        customers[size] = [size + 1, name, email, password, phone, address,true]
        onLoadPage()
        reset()
    }
}

function reset() {
    document.getElementById("fullName").value = ""
    document.getElementById("email").value = ""
    document.getElementById("password").value = ""
    document.getElementById("rePassword").value = ""
    document.getElementById("phone").value = ""
    document.getElementById("address").value = ""
}

function editCustomer(clicker_id) {
    let num = parseInt((clicker_id).replace("editCustomer", ""))
    let customer = customers[num]
    document.getElementById("idUp").value = customer[0]
    document.getElementById("fullNameUp").value = customer[1]
    document.getElementById("emailUp").value = customer[2]
    document.getElementById("phoneUp").value = customer[4]
    document.getElementById("addressUp").value = customer[5]
}

function updateCustomer() {
    let id = document.getElementById("idUp").value
    let index = id - 1
    customers[index][1] = document.getElementById("fullNameUp").value
    customers[index][2] = document.getElementById("emailUp").value
    customers[index][4] = document.getElementById("phoneUp").value
    customers[index][5] = document.getElementById("addressUp").value
    onLoadPage()

}

function deleteCustomer(clicker_id) {
    let num = parseInt((clicker_id).replace("deleteCustomer", ""))
    let customer = customers[num]
    document.getElementById("idDelete").value = customer[0]
}

function applyDelete() {
    let id = document.getElementById("idDelete").value
    let index = id - 1
    customers[index][6]=false 
    onLoadPage()
}

onLoadPage();