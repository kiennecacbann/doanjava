<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="models.BunContext"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="models.Dao" %>
<%@page import="models.MonAn" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="lONG nHONG, 10 năm kinh nghiệm nhà làm, Breakfast Ideas, Healthy recipes, Which is the tastiest food?, Reviews, Số điện thoại">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Main page</title>
    <link rel="stylesheet" href="css/Homepage.css" media="screen">
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
    <link rel="stylesheet" href="css/Style.css" media="screen">
    <link rel="stylesheet" href="css/Site.css" media="screen">
    <link rel="stylesheet" href="css/Menu.css" media="screen">
    <script class="u-script" type="text/javascript" src="JavaScripts/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="JavaScripts/nicepage.js" defer=""></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <meta name="generator" content="Nicepage 4.7.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="fonts/fontawesome-free-5.15.4-web/css/all.css" />
    <meta name="theme-color" content="#478ac9">
</head>  
<body data-home-page="Trang-chủ.html" data-home-page-title="Trang chủ" class="u-body u-xl-mode">
    <nav class="navbar">
        <div class="content">
            <div class="logo">
                <a href="/"><img src="" style="background-repeat:no-repeat;" /></a>
            </div>
            <ul class="menu-list">
                <div class="icon cancel-btn">
                    <i class="fas fa-times"></i>
                </div>
                <li>
                   <a href="Homepage">Trang chủ</a>
                </li>

                <li>
                    <a href="">Menu</a>
                </li>

                <li>
                    <a href="#contact">Liên hệ</a>
                </li>

                    <!--Can chinh sua tao trang cho nguoi dung-->

                <li>
                    <a href="Giohang">Giỏ hàng</a>
                </li>
                
                <li>
                        <a href="Login">${username}</a>
                </li>
                
                   <li>
                        <a href="Logout">${logout}</a>
                </li>
            </ul>
            <div class="icon menu-btn">
                <i class="fas fa-bars"></i>
            </div>
        </div>
    </nav>

    <div class="banner"></div>
	 
        <div class="container">
            <div class="row">
                <div class="title">
                    <h2>MENU</h2>
                </div>
            </div>
            <div class="row">
                <div class="menu-title">
                    <button class="menu-button active" data-title="food">BÚN BÒ</button>
                    <button class="menu-button" data-title="drink">NƯỚC</button>
                    <button class="menu-button" data-title="dessert">ĐỒ DÙNG THÊM</button>
                </div>
            </div>
            
            <div class="menu-content active" id="food">
            <c:forEach items="${monans}" var="monan">
            	<div class="list-items">
                    <div class="list-item">
                        <img src="images/${monan.img}" alt="">
                        <p>${monan.tenmon}</p>
                    </div>
                    <div class="list-price">
                        <p>${monan.giatien} VNĐ</p>
                        <a href="${pageContext.request.contextPath}/ThemGioHang?&action=buy&id=${monan.mamon}">Đặt</a>
                    </div>                    
                </div>
            </c:forEach>   
                  
            </div>
            <div class="menu-content" id="drink">            
               <c:forEach items="${nuocs}" var="nuoc">
            	<div class="list-items">
                    <div class="list-item">
                        <img src="images/${nuoc.img}" alt="">
                        <p>${nuoc.tenmon}</p>
                    </div>
                    <div class="list-price">
                        <p>${nuoc.giatien} VNĐ</p>
                        <a href="${pageContext.request.contextPath}/ThemGioHang?&action=buynuoc&idnuoc=${nuoc.mamon}">Đặt</a>
                    </div>
                </div>
            </c:forEach>                    
            </div>
            
            <div class="menu-content" id="dessert">
            <c:forEach items="${dodungs}" var="dodung">
            	<div class="list-items">
                    <div class="list-item">
                        <img src="images/${dodung.img}" alt="">
                        <p>${dodung.tendd}</p>
                    </div>
                    <div class="list-price">
                        <p>${dodung.gia} VNĐ</p>
                         <a href="${pageContext.request.contextPath }/ThemGioHang?&action=buydodung&iddodung=${dodung.madd}">Đặt</a>
                    </div>
                   
                </div>
            </c:forEach> 
            </div>
        </div>
   
    <section id="contact" class="footer">
        <div class="container">
            <div class="row">
                <div class="footer-item">
                    <h2>ĐỊA CHỈ</h2>
                    <p>450/21 Đoàn Văn Bơ<br>P14 Q4 - TPHCM (KHÔNG CHI NHÁNH)</p>
                </div>
                <div class="footer-item">
                    <h2>GIỜ MỞ CỬA</h2>
                    <p>Thứ 2 - Chủ nhật <br> 06:30 AM - 11:30 AM </p>
                </div>
                <div class="footer-item">
                    <h2>LIÊN HỆ</h2>
                    <p>
                        <i class="fas fa-phone"></i> 0933847317 (Cẩm Loan)<br> <i class="far fa-envelope"></i>
                        lethaichau1976@gmail.com
                    </p>
                    <div class="footer-social">
                        <a href="https://www.facebook.com/phanthicam.van.37">
                            <i class="fab fa-facebook"></i>
                        </a>
                    </div>

                </div>
                <div id="map"></div>
            </div>
            <div class="footer-copyright">
                Copyright © @DateTime.Now.Year . All rights reserved.
            </div>
        </div>
    </section>
     <script>
        const body = document.querySelector("body");
        const navbar = document.querySelector(".navbar");
        const menuBtn = document.querySelector(".menu-btn");
        const cancelBtn = document.querySelector(".cancel-btn");
        menuBtn.onclick = () => {
            navbar.classList.add("show");
            menuBtn.classList.add("hide");
            body.classList.add("disabled");
        }
        cancelBtn.onclick = () => {
            body.classList.remove("disabled");
            navbar.classList.remove("show");
            menuBtn.classList.remove("hide");
        }
        window.onscroll = () => {
            this.scrollY > 20 ? navbar.classList.add("sticky") : navbar.classList.remove("sticky");
        }
    </script>
    <!--GOOGLE MAP API-->
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
    <script defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDaig0K061eht7eWnAfthVC5mxT3wN3NE0&callback=initMap">
    </script>
    <script>
        function initMap() {
            var options = {
                zoom: 15,
                center: { lat: 10.759801065506585, lng: 106.70857341085205 },
            };
            var map = new google.maps.Map(document.getElementById('map'), options);
            var marker = new google.maps.Marker({
                position: { lat: 10.759801065506585, lng: 106.70857341085205 },
                map: map,
            });
        }
    </script>
</body>
</html>