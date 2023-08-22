<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width" />
    <title>GioHang</title>
    <link rel="stylesheet" href="css/GioHang.css" media="screen">
</head>
<body>
	 <form action="ThanhToan" method="POST">
        <main>
            <div class="basket">
                <div class="basket-module">
                    <label for="promo-code">Nhập mã giảm giá</label>
                    <input id="promo-code" type="text" name="promo-code" maxlength="5" class="promo-code-field">
                    <button class="promo-code-cta">Xác nhận mã</button>
                    <button class="promo-code-cta"><a href="Homepage" style="color:white">Trở lại trang chủ</a></button>
                </div>
                <div class="basket-labels">
                    <ul>
                        <li class="item item-heading">Món ăn</li>
                        <li class="price">Đơn giá </li>
                        <li class="quantity">Số lượng</li>
                        <li class="subtotal">Tổng tiền </li>
                    </ul>
                </div>
                 <c:forEach items="${cart}" var="item">                                
                    	 <div class="basket-product">
                        <div class="item">
                            <div class="product-image">
                                <img src="images/${item.monan.img}" alt="Placholder Image 2" class="product-frame" width="100px" height="100px">
                            </div>
                            <div class="product-details">
                                <h1><strong><span class="item-quantity">${item.monan.tenmon}</span></strong></h1>
                                <p>${item.monan.mota}</p>
                            </div>
                        </div>
                        <div class="price">${item.monan.giatien}</div>
                        <div class="quantity">
                            <input type="number" value="${item.soluong}" min="1" class="quantity-field" name="SoLuong">
                        </div>
                        <div class="subtotal">${item.tongtien}</div>
                        <div class="remove">
                            <button><a href="${pageContext.request.contextPath }/ThemGioHang?&action=remove&id=${item.monan.mamon}">Hủy món</a></button>
                        </div>
                    </div>
                 </c:forEach>
 
                  <c:forEach items="${cart1}" var="item">                                
                    	 <div class="basket-product">
                        <div class="item">
                            <div class="product-image">
                                <img src="images/${item.ddt.img}" alt="Placholder Image 2" class="product-frame" width="100px" height="100px">
                            </div>
                            <div class="product-details">
                                <h1><strong><span class="item-quantity">${item.ddt.tendd}</span></strong></h1>
                            </div>
                        </div>
                        <div class="price">${item.ddt.gia}</div>
                        <div class="quantity">
                            <input type="number" value="${item.soluong}" min="1" class="quantity-field" name="SoLuong">
                        </div>
                        <div class="subtotal">${item.tongtien}</div>
                        <div class="remove">
                            <button><a href="${pageContext.request.contextPath }/ThemGioHang?&action=remove&iddodung=${item.ddt.madd}">Hủy món</a></button>
                        </div>
                    </div>
                 </c:forEach> 
                             
                  <c:forEach items="${cart2}" var="item">                                
                    	 <div class="basket-product">
                        <div class="item">
                            <div class="product-image">
                                <img src="images/${item.nuoc.img}" alt="Placholder Image 2" class="product-frame" width="100px" height="100px">
                            </div>
                            <div class="product-details">
                                <h1><strong><span class="item-quantity">${item.nuoc.tenmon}</span></strong></h1>
                            </div>
                        </div>
                        <div class="price">${item.nuoc.giatien}</div>
                        <div class="quantity">
                            <input type="number" value="${item.soluong}" min="1" class="quantity-field" name="SoLuong">
                        </div>
                        <div class="subtotal">${item.tongtien}</div>
                        <div class="remove">
                            <button><a href="${pageContext.request.contextPath }/ThemGioHang?&action=remove&idnuoc=${item.nuoc.mamon}">Hủy món</a></button>
                        </div>
                    </div>
                 </c:forEach>                                                
                               
            </div>

            <aside>
                <div class="summary">
                    <div class="summary-total-items"><span class="total-items"></span>Đơn đặt hàng</div>
                    <c:forEach items="${cart}" var="item">
                    	 <div class="summary-subtotal">
                            <div class="subtotal-title">${item.monan.tenmon} X ${item.soluong}</div>
                            <div class="subtotal-value final-value" id="basket-subtotal">${item.tongtien}</div>
                            <div class="summary-promo hide">
                                <div class="promo-title">Promotion</div>
                                <div class="promo-value final-value" id="basket-promo"></div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${cart1}" var="item">
                    	 <div class="summary-subtotal">
                            <div class="subtotal-title">${item.ddt.tendd} X ${item.soluong}</div>
                            <div class="subtotal-value final-value" id="basket-subtotal">${item.tongtien}</div>
                            <div class="summary-promo hide">
                                <div class="promo-title">Promotion</div>
                                <div class="promo-value final-value" id="basket-promo"></div>
                            </div>
                        </div>
                    </c:forEach>
                      <c:forEach items="${cart2}" var="item">
                    	 <div class="summary-subtotal">
                            <div class="subtotal-title">${item.nuoc.tenmon} X ${item.soluong}</div>
                            <div class="subtotal-value final-value" id="basket-subtotal">${item.tongtien}</div>
                            <div class="summary-promo hide">
                                <div class="promo-title">Promotion</div>
                                <div class="promo-value final-value" id="basket-promo"></div>
                            </div>
                        </div>
                    </c:forEach>

                    <!--<div class="summary-delivery">
                    <select name="delivery-collection" class="summary-delivery-selection">
                        <option value="0" selected="selected">Chọn phương thức giao hàng</option>
                        <option value="collection">Nhanh trong ngày</option>
                        <option value="first-class">Bình thường từ 3-6 ngày</option>
                        <option value="second-class">Siêu tốc ngay lập tức</option>
                        <option value="signed-for">Dịch chuyển ngay đến tận phòng</option>
                    </select>
                </div>--->
                    <div class="summary-delivery">
                        <h3 style="text-align:center">Chọn ngày giao</h3>
                        <input type="date" name="NgayGiao" required="" style="padding-left:80px" />
                    </div>
                    <div class="summary-total">
                        <div class="total-title">Tổng tiền</div>
                        <div class="total-value final-value" id="basket-total">${tongtien}</div>
                    </div>
                    <div class="summary-checkout">
                        <button class="checkout-cta"><input type="submit" style="background:none;color: white; padding-left:65px; font-weight:bold;" value="THANH TOÁN"></button>
                    </div>

                </div>
            </aside>
        </main>
    </form>
<script>
        var promoCode;
        var promoPrice;
        var fadeTime = 300;
        /*Sua javascript de tinh tien*/
        /* Assign actions */
        $('.quantity input').change(function () {
            updateQuantity(this);         
        });

        $('.remove button').click(function () {
            removeItem(this);
        });

        $(document).ready(function () {
            updateSumItems();
        });

        $('.promo-code-cta').click(function () {

            promoCode = $('#promo-code').val();

            if (promoCode == '10off' || promoCode == '10OFF') {
                //If promoPrice has no value, set it as 10 for the 10OFF promocode
                if (!promoPrice) {
                    promoPrice = 10;
                } else if (promoCode) {
                    promoPrice = promoPrice * 1;
                }
            } else if (promoCode != '') {
                alert("Invalid Promo Code");
                promoPrice = 0;
            }
            //If there is a promoPrice that has been set (it means there is a valid promoCode input) show promo
            if (promoPrice) {
                $('.summary-promo').removeClass('hide');
                $('.promo-value').text(promoPrice.toFixed(2));
                recalculateCart(true);
            }
        });

        /* Recalculate cart */
        function recalculateCart(onlyTotal) {
            var subtotal = 0;

            /* Sum up row totals */
            $('.basket-product').each(function () {
                subtotal += parseFloat($(this).children('.subtotal').text());
            });

            /* Calculate totals */
            var total = subtotal;

            //If there is a valid promoCode, and subtotal < 10 subtract from total
            var promoPrice = parseFloat($('.promo-value').text());
            if (promoPrice) {
                if (subtotal >= 10) {
                    total -= promoPrice;
                } else {
                    alert('Order must be more than £10 for Promo code to apply.');
                    $('.summary-promo').addClass('hide');
                }
            }

            /*If switch for update only total, update only total display*/
            if (onlyTotal) {
                /* Update total display */
                $('.total-value').fadeOut(fadeTime, function () {
                    $('#basket-total').html(total.toFixed(2));
                    $('.total-value').fadeIn(fadeTime);
                });
            } else {
                /* Update summary display. */
                $('.final-value').fadeOut(fadeTime, function () {
                    $('#basket-subtotal').html(subtotal.toFixed(2));
                    $('#basket-total').html(total.toFixed(2));
                    if (total == 0) {
                        $('.checkout-cta').fadeOut(fadeTime);
                    } else {
                        $('.checkout-cta').fadeIn(fadeTime);
                    }
                    $('.final-value').fadeIn(fadeTime);
                });
            }
        }

        /* Update quantity */
        function updateQuantity(quantityInput) {
            /* Calculate line price */
            var productRow = $(quantityInput).parent().parent();
            var price = parseFloat(productRow.children('.price').text());
            var quantity = $(quantityInput).val();
            var linePrice = price * quantity;

            /* Update line price display and recalc cart totals */
            productRow.children('.subtotal').each(function () {
                $(this).fadeOut(fadeTime, function () {
                    $(this).text(linePrice.toFixed(2));
                    recalculateCart();
                    $(this).fadeIn(fadeTime);
                });
            });

            productRow.find('.item-quantity').text(quantity);
            updateSumItems();
            
        }

        function updateSumItems() {
            var sumItems = 0;
            $('.quantity input').each(function () {
                sumItems += parseInt($(this).val());
            });
            $('.total-items').text(sumItems);
        }

        /* Remove item from cart */
        function removeItem(removeButton) {
            /* Remove row from DOM and recalc cart total */
            var productRow = $(removeButton).parent().parent();
            productRow.slideUp(fadeTime, function () {
                productRow.remove();
                recalculateCart();
                updateSumItems();
            });
        }
     </script>
</body>
</html>