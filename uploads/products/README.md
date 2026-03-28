# Hướng dẫn thêm ảnh sản phẩm

## 📁 Thư mục này dùng để lưu ảnh sản phẩm

### Cách thêm ảnh:

#### **Cách 1: Thêm ảnh thủ công (Đơn giản)**

1. **Đặt ảnh vào thư mục này** (`uploads/products/`)
   - Ví dụ: `desk1.jpg`, `chair1.jpg`, `cabinet1.jpg`

2. **Chạy file SQL** để thêm đường dẫn vào database:
   ```bash
   mysql -u root -p cnpm < insert_images.sql
   ```

3. **Khởi động lại ứng dụng** (nếu đang chạy)

---

#### **Cách 2: Upload qua Admin Panel (Khuyến nghị)**

1. Truy cập: http://localhost:8080/admin/products
2. Click "Quản lý ảnh" cho sản phẩm muốn thêm ảnh
3. Chọn file và upload

---

## 📝 Quy tắc đặt tên file ảnh:

### Đề xuất:
- `desk1.jpg` - Ảnh chính sản phẩm bàn 1
- `desk1-2.jpg` - Ảnh phụ thứ 2 của bàn 1
- `chair1.jpg` - Ảnh ghế 1
- `cabinet1.jpg` - Ảnh tủ 1

### Định dạng hỗ trợ:
- `.jpg` / `.jpeg`
- `.png`
- `.gif`
- `.webp`

### Kích thước đề xuất:
- **Tối thiểu**: 800x800px
- **Tối ưu**: 1200x1200px
- **Tối đa**: 10MB

---

## 🗂️ Danh sách sản phẩm cần ảnh:

| ID | Tên sản phẩm | Tên file đề xuất |
|----|--------------|------------------|
| 1 | Electric Standing Desk Pro | desk1.jpg |
| 2 | L-Shaped Executive Desk | desk2.jpg |
| 3 | Compact Writing Desk | desk3.jpg |
| 4 | Industrial Style Desk | desk4.jpg |
| 5 | Ergonomic Mesh Chair Pro | chair1.jpg |
| 6 | Executive Leather Chair | chair2.jpg |
| 7 | Basic Task Chair | chair3.jpg |
| 8 | Gaming Office Chair | chair4.jpg |
| 9 | Mobile Pedestal Cabinet | cabinet1.jpg |
| 10 | Modern Bookshelf | bookshelf1.jpg |

---

## ✅ Kiểm tra ảnh đã hiển thị:

1. **Trang chủ**: http://localhost:8080/
2. **Danh sách sản phẩm**: http://localhost:8080/products
3. **Chi tiết sản phẩm**: http://localhost:8080/product/1

---

## 🔧 Troubleshooting:

### Ảnh không hiển thị?
1. Kiểm tra file có tồn tại trong `uploads/products/`
2. Kiểm tra đường dẫn trong database:
   ```sql
   SELECT * FROM product_image;
   ```
3. Khởi động lại ứng dụng

### Ảnh bị lỗi 404?
- Đảm bảo ứng dụng đang chạy
- Kiểm tra URL: http://localhost:8080/uploads/products/desk1.jpg
