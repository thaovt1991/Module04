let cutomer = new Customer();
let locationRegion = new LocationRegion();

function addNewSmartPhone() {
    //lay du lieu
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "/api/smartphones",
        //xử lý khi thành công
        success: successHandler

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/api/smartphones",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '    <tr>\n' +
                '        <td>ID</td>\n' +
                '        <td>Producer</td>\n' +
                '        <td>Model</td>\n' +
                '        <td>Price</td>\n' +
                '        <td>Edit</td>\n' +
                '        <td>Delete</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSmartphone(data[i]);
            }
            document.getElementById('smartphoneList').innerHTML = content;
            handlerEdit();
            handlerDelete() ;
        }
    });
}


function getSmartphone(smartphone) {
    return `<tr>
                    <td >${smartphone.id}</td>
                    <td >${smartphone.producer}</td>
                    <td >${smartphone.model}</td>
                    <td >${smartphone.price}</td>
                    <td>
                        <input type="button" class="editSmartphone" data-id="${smartphone.id}" value="Edit" ></input>
                    </td>
                    <td> <input type="button" class="deleteSmartphone" data-id="${smartphone.id}" value="Delete"></></td>
                </tr>`;
}


$(document).ready(function () {
    handlerDelete()
})

function handlerDelete() {
    //sư kiện nào thực hiện Ajax
    $('.deleteSmartphone').click(function (event) {
        //lay du lieu
        let a = $(this);
        let smartphoneId = a.data("id");
        // goi ajax
        $.ajax({
            type: "DELETE",
            //tên API
            url: `/api/smartphones/${smartphoneId}`,
            //xử lý khi thành công
            success: function (data) {
                a.parent().parent().remove();
            }
        });
        // return false;
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
}


$(document).ready(function () {
    handlerEdit();
});

function handlerEdit() {
    $(".editSmartphone").click(function () {
        $("#edit-smartphone").show();
        let smartphoneId = $(this).data("id");

        // let a = $(this);
        // let smartphoneId = a.attr("href");
        // goi ajax
        $.ajax({
            type: "GET",
            //tên API
            url: `/api/smartphones/${smartphoneId}`,
            //xử lý khi thành công
            success: function (data) {
                // console.log(data)
                $("#idUp").val(smartphoneId)
                $("#producerUp").val(data.producer)
                $("#modelUp").val(data.model)
                $("#priceUp").val(data.price)
            }
        });
        // return false;
    });
}

function updateSmartPhone() {
    //lay du lieu
    $("#edit-smartphone").hide();
    let id = $('#idUp').val();
    let producer = $('#producerUp').val();
    let model = $('#modelUp').val();
    let price = $('#priceUp').val();
    let oldSmartPhone = {
        id: id,
        producer: producer,
        model: model,
        price: price
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(oldSmartPhone),
        //tên API
        url: `/api/smartphones`,
        //xử lý khi thành công
        success: function () {
            successHandler();
            reset();
        },
        error: function () {
            alert("TAO CHIU ROI")
        }
    });
    //chặn sự kiện mặc định của thẻ
    // return false;
    event.preventDefault();
};

function reset() {
    $('#idUp').val("");
    $('#producerUp').val("");
    $('#modelUp').val("");
    $('#priceUp').val("");
}