CREATE DATABASE Officecraft;
USE DATABASE Officecraft;

-- ROLE
CREATE TABLE Role (
    roleId INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(100)
) ENGINE=InnoDB;

-- USER
CREATE TABLE `User` (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(50),
    address VARCHAR(255),
    gender VARCHAR(50),
    status VARCHAR(50),
    isDelete INT,
    isActive INT DEFAULT 0,
    roleId INT,
    FOREIGN KEY (roleId) REFERENCES Role(roleId)
) ENGINE=InnoDB;

-- CUSTOMER (JOINED)
CREATE TABLE Customer (
    customerId INT PRIMARY KEY,
    FOREIGN KEY (customerId) REFERENCES `User`(userId) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ADMIN
CREATE TABLE Administrator (
    userId INT PRIMARY KEY,
    FOREIGN KEY (userId) REFERENCES `User`(userId) ON DELETE CASCADE
) ENGINE=InnoDB;

-- CATEGORY
CREATE TABLE Category (
    categoryId INT AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(255)
) ENGINE=InnoDB;

-- PRODUCT
CREATE TABLE Product (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    descript TEXT,
    productImage VARCHAR(500),
    price DECIMAL(18,2),
    quantity INT,
    isDelete INT DEFAULT 0,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId)
) ENGINE=InnoDB;

-- CART
CREATE TABLE Cart (
    cartId INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT UNIQUE,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId) ON DELETE CASCADE
) ENGINE=InnoDB;

-- CART ITEM
CREATE TABLE CartItem (
    cartItemId INT AUTO_INCREMENT PRIMARY KEY,
    cartId INT,
    productId INT,
    quantity INT,
    price DECIMAL(18,2),
    FOREIGN KEY (cartId) REFERENCES Cart(cartId) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES Product(productId)
) ENGINE=InnoDB;

-- ORDER
CREATE TABLE `Order` (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    orderDate DATE,
    status VARCHAR(100),
    totalCost DECIMAL(18,2),
    discount DECIMAL(18,2),
    actualCost DECIMAL(18,2),
    cityOfProvince VARCHAR(255),
    district VARCHAR(255),
    ward VARCHAR(255),
    streetNumber VARCHAR(255),
    phone VARCHAR(50),
    paymentMethod VARCHAR(100),
    customerId INT,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
) ENGINE=InnoDB;

-- ORDER ITEM
CREATE TABLE OrderItem (
    orderItemId INT AUTO_INCREMENT PRIMARY KEY,
    orderId INT,
    productId INT,
    quantity INT,
    price DECIMAL(18,2),
    FOREIGN KEY (orderId) REFERENCES `Order`(orderId) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES Product(productId)
) ENGINE=InnoDB;

-- REFUND REQUEST
CREATE TABLE RefundRequest (
    refundId INT AUTO_INCREMENT PRIMARY KEY,
    orderId INT,
    orderItemId INT,
    reason VARCHAR(500),
    requestType VARCHAR(100),
    status VARCHAR(100) DEFAULT 'PENDING',
    imagePath VARCHAR(500),
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (orderId) REFERENCES `Order`(orderId),
    FOREIGN KEY (orderItemId) REFERENCES OrderItem(orderItemId)
) ENGINE=InnoDB;

-- ADDRESS
CREATE TABLE Address (
    addressId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    receiverName VARCHAR(255),
    phone VARCHAR(50),
    city VARCHAR(255),
    district VARCHAR(255),
    ward VARCHAR(255),
    specificAddress VARCHAR(255),
    isDefault BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (userId) REFERENCES `User`(userId) ON DELETE CASCADE
) ENGINE=InnoDB;

-- REVIEW
CREATE TABLE Review (
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    rating DECIMAL(2,1),
    createAt DATETIME,
    customerId INT,
    productId INT,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (productId) REFERENCES Product(productId)
) ENGINE=InnoDB;

-- VOUCHER
CREATE TABLE Voucher (
    voucherId INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(100),
    discount DECIMAL(18,2),
    dateStart DATE,
    dateEnd DATE,
    isDelete INT
) ENGINE=InnoDB;

CREATE TABLE VoucherByPrice (
    voucherId INT PRIMARY KEY,
    lowerbound DECIMAL(18,2),
    discountPercent FLOAT,
    maxDiscount DECIMAL(18,2),
    FOREIGN KEY (voucherId) REFERENCES Voucher(voucherId) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE VoucherByProduct (
    voucherId INT PRIMARY KEY,
    discountPercent FLOAT,
    FOREIGN KEY (voucherId) REFERENCES Voucher(voucherId) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE voucher_product (
    voucherByProductId INT,
    productId INT,
    PRIMARY KEY (voucherByProductId, productId),
    FOREIGN KEY (voucherByProductId) REFERENCES VoucherByProduct(voucherId) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES Product(productId)
) ENGINE=InnoDB;

-- WISHLIST
CREATE TABLE Wishlist (
    wishlistId INT AUTO_INCREMENT PRIMARY KEY,
    isDelete INT,
    customerId INT UNIQUE,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE wishlists_products (
    wishlistId INT,
    productId INT,
    PRIMARY KEY (wishlistId, productId),
    FOREIGN KEY (wishlistId) REFERENCES Wishlist(wishlistId) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES Product(productId)
) ENGINE=InnoDB;

-- COMMUNICATION
CREATE TABLE Conversation (
    conversationId INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT,
    adminId INT,
    title VARCHAR(255),
    status VARCHAR(100),
    createdDate DATETIME,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (adminId) REFERENCES Administrator(userId)
) ENGINE=InnoDB;

CREATE TABLE Message (
    messageId INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    timestamp DATETIME,
    conversationId INT,
    userId INT,
    FOREIGN KEY (conversationId) REFERENCES Conversation(conversationId),
    FOREIGN KEY (userId) REFERENCES `User`(userId)
) ENGINE=InnoDB;

INSERT INTO Category (categoryName)
VALUES
     ('Bàn Giám Đốc'),
     ('Quầy Lễ Tân'),
     ('Ghế Văn Phòng'),
     ('Tủ Tài Liệu'),
     ('Bàn Họp'),
     ('Kệ Trang Trí'),
     ('Bàn Làm Việc'),
     ('Giường Ngủ'),
     ('Sản Phẩm Khác'),
     ('Combo Nội Thất'),
     ('Quầy Thu Ngân'),
     ('Bàn Trà');

INSERT INTO Role (roleName) 
VALUES
      ('ADMINISTRATOR'),
      ('CUSTOMER');

INSERT INTO `User`
(name, email, password, phone, address, gender, status, isDelete, isActive, roleId)
VALUES
(
    'Administrator',
    'admin@officecraft.com',
    '123456',
    '0909090909',
    'Head Office',
    'Male',
    'Active',
    0,
    1,
    1
);
