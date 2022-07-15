<%--
  Created by IntelliJ IDEA.
  User: Ngọc Mai
  Date: 7/15/2022
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Họ và tên:${medicalDeclaration.name}</p>
<p>Năm sinh:${medicalDeclaration.dayOfBirth}</p>
<p>Giới tính:${medicalDeclaration.gender}</p>
<p>Số CMND:${medicalDeclaration.identityCard}</p>
<p>Thông tin đi lại:${medicalDeclaration.travelInformation}</p>
<p>Số hiệu phương tiện:${medicalDeclaration.vehicleNumber}</p>
<p>Số ghế:${medicalDeclaration.seats}</p>
<p>Ngày khởi
    hành:${medicalDeclaration.departureDay},${medicalDeclaration.departureMonth},${medicalDeclaration.departureYear}</p>
<p>Ngày kết thúc:${medicalDeclaration.endDay},${medicalDeclaration.endMonth},${medicalDeclaration.endYear}</p>
<p>Số hiệu phương tiện:${medicalDeclaration.vehicleNumber}</p>
<p>Số hiệu phương tiện:${medicalDeclaration.vehicleNumber}</p>
<p>Trong vòng 14 ngày qua, Anh/Chị có đến tình/thành phố nào?${medicalDeclaration.note}</p>
<p>Địa chỉ liên lạc:${medicalDeclaration.province},${medicalDeclaration.district}</p>
<p>Địa chỉ nơi ở: ${medicalDeclaration.addressOfResidence}</p>
<p>Điện thoại: ${medicalDeclaration.phoneNumber}</p>
<p>Email: ${medicalDeclaration.email}</p>
<p>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không</p>
<p>Sốt ${medicalDeclaration.note2}</p>
<p>Nôn/Buồn nôn ${medicalDeclaration.note3}</p>
<p>Ho ${medicalDeclaration.note4}</p>
<p>Tiêu chảy ${medicalDeclaration.note5}</p>
<p>Khó thở ${medicalDeclaration.note6}</p>
<p>Xuất huyết ngoài da ${medicalDeclaration.note7}</p>
<p>Đau họng ${medicalDeclaration.note8}</p>
<p>Nổi ban ngoài da ${medicalDeclaration.note9}</p>
<p>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có</p>
<p>Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động
    vật ${medicalDeclaration.note10}</p>
<p>Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV ${medicalDeclaration.note11}</p>
</body>
</html>
