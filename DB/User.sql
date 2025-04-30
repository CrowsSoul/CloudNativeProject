-- 创建用户表
CREATE TABLE User (
                      UserID INT PRIMARY KEY AUTO_INCREMENT,
                      Username VARCHAR(50) NOT NULL UNIQUE,
                      Password VARCHAR(50) NOT NULL,
                      Role VARCHAR(20) NOT NULL,
                      Email VARCHAR(100),
                      CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 插入测试数据
INSERT INTO User (Username, Password, Role, Email) VALUES
                                                       ('admin', 'admin123', 'ADMIN', 'admin@example.com'),
                                                       ('manager', 'manager123', 'MANAGER', 'manager@example.com'),
                                                       ('staff1', 'staff123', 'STAFF', 'staff1@example.com'),
                                                       ('staff2', 'staff456', 'STAFF', 'staff2@example.com'),
                                                       ('guest', 'guest123', 'GUEST', 'guest@example.com');