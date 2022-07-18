<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngọc Mai
  Date: 7/15/2022
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        * {
            font-size: 14px;
            font-family: "Open Sans", sans-serif;
        }

    </style>
</head>
<body>
<h1>Tờ khai y tế</h1><br>
<p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM</p>
<p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
<form:form action="/save" modelAttribute="medicalDeclaration" method="post">
    <p>Họ và tên(ghi chữ IN HOA)</p>
    <form:input size="100%" path="name"/>
    <table style="width: 100%">
        <tr>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tịch</td>
        </tr>
        <tr>
            <td>
                <form:select cssStyle="width: 33%" path="dayOfBirth" items="${dayOfBirth}"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="gender" items="${gender}"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="nationality" items="${nationality}"/>
            </td>
        </tr>
    </table>
    <p>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</p>
    <form:input size="100%" path="identityCard"/>

    <p>Thông tin đi lại</p>
    <form:radiobuttons path="travelInformation" items="${travel}"/>

    <table style="width: 100%">
        <tr>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
        </tr>
        <td>
            <form:input cssStyle="width: 50%" path="vehicleNumber"/>
        </td>
        <td>
            <form:input cssStyle="width: 50%" path="seats"/>
        </td>
    </table>

    <table style="width: 100%">
        <tr>
            <td colspan="3">Ngày khởi hành</td>
            <td colspan="3">Ngày kết thúc</td>
        </tr>
        <td>
            <form:select cssStyle="width: 33%" path="departureDay" items="${day}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="departureMonth" items="${month}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="departureYear" items="${year}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endDay" items="${days}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endMonth" items="${months}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endYear" items="${years}"/>
        </td>
    </table>
    <p>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</p>
    <form:input size="100%" path="note"/>
    <p>Địa chỉ liên lạc</p>
    <table>
        <tr>
            <td>Tỉnh/thành</td>
            <td>Quận/Huyện</td>
        </tr>
        <tr>
            <td>
                <form:select path="province" items="${province}"/>
            </td>
            <td>
                <form:select path="district" items="${district}"/>
            </td>
        </tr>
    </table>
    <p>Địa chỉ nơi ở</p>
    <form:input size="100%" path="addressOfResidence"/>
    <table>
        <tr>
            <td>Điện thoại</td>
            <td>Email</td>
        </tr>
        <tr>
            <td>
                <form:input path="phoneNumber"/>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
    </table>
    <p>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không</p>
    <table border="1">
        <tr>
            <th>Triệu chứng</th>
            <th>Có</th>
            <th>Không</th>
            <th>Triệu chứng</th>
            <th>Có</th>
            <th>Không</th>
        </tr>
        <tr>
            <td>Sốt</td>
            <td>
                <form:radiobutton path="note2"/>
            </td>
            <td>
                <form:radiobutton path="note2"/>
            </td>
            <td>Nôn/Buồn nôn</td>
            <td>
                <form:radiobutton path="note3"/>
            </td>
            <td>
                <form:radiobutton path="note3"/>
            </td>
        </tr>
        <tr>
            <td>Ho</td>
            <td>
                <form:radiobutton path="note4"/>
            </td>
            <td>
                <form:radiobutton path="note4"/>
            </td>
            <td>Tiêu chảy</td>
            <td>
                <form:radiobutton path="note5"/>
            </td>
            <td>
                <form:radiobutton path="note5"/>
            </td>
        </tr>
        </tr>
        <tr>
            <td>Khó thở</td>
            <td>
                <form:radiobutton path="note6"/>
            </td>
            <td>
                <form:radiobutton path="note6"/>
            </td>
            <td>Xuất huyết ngoài da</td>
            <td>
                <form:radiobutton path="note7"/>
            </td>
            <td>
                <form:radiobutton path="note7"/>
            </td>
        </tr>
        <tr>
            <td>Đau họng</td>
            <td>
                <form:radiobutton path="note8"/>
            </td>
            <td>
                <form:radiobutton path="note8"/>
            </td>
            <td>Nổi ban ngoài da</td>
            <td>
                <form:radiobutton path="note9"/>
            </td>
            <td>
                <form:radiobutton path="note9"/>
            </td>
        </tr>
    </table>
    <p>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có</p>
    <table border="1">
        <tr>
            <th></th>
            <th>Có</th>
            <th>Không</th>
        </tr>
        <tr>
            <td>Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vật</td>
            <td>
                <form:radiobutton path="note10"/>
            </td>
            <td>
                <form:radiobutton path="note10"/>
            </td>
        </tr>
        <tr>
            <td>Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV</td>
            <td>
                <form:radiobutton path="note11"/>
            </td>
            <td>
                <form:radiobutton path="note11"/>
            </td>
        </tr>
    </table>
    <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo
        quốc gia về Phòng chống dịch Covid-19.</p>
    <p>Khi bạn nhấn nút"Gửi" là bạn đã hiểu và đồng ý</p>
    <button type="submit">Gửi tờ khai</button>
</form:form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>