-- 1. 删除外键
ALTER TABLE OrderMenuItemCooker DROP FOREIGN KEY OrderID;

-- 2. 设置 OrderID 自增
ALTER TABLE Orders MODIFY OrderID INT NOT NULL AUTO_INCREMENT;

-- 3. 重新添加外键
ALTER TABLE OrderMenuItemCooker
    ADD CONSTRAINT fk_OrderMenuItemCooker_OrderID
        FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE;
-- 清空所有表数据（按依赖顺序）
DELETE FROM `OrderMenuItemCooker`;
DELETE FROM `Orders`;
DELETE FROM `MenuItem`;
DELETE FROM `Employee`;
DELETE FROM `Manager`;

-- 1. 填充Manager表
INSERT INTO `RestaurantMS`.`Manager` (`ManagerID`, `Address`, `Tel`, `ManagerName`)
VALUES 
(1, '123 Main St, City Center', '555-0101', '张伟'),
(2, '456 Oak Ave, Riverside', '555-0102', '李娜'),
(3, '789 Pine Rd, Hillside', '555-0103', '王强');

-- 2. 填充Employee表（修正所有职位名称）
INSERT INTO `RestaurantMS`.`Employee` (`EmployeeID`, `EmployeeName`, `Salary`, `Position`, `Address`, `Tel`, `SupervisorID`)
VALUES
-- 厨师
(101, '王大厨', 4800, 'COOKER', '321 Elm St', '555-0201', 1),
(102, '陈师傅', 4600, 'COOKER', '654 Maple Ave', '555-0202', 2),
(103, '林厨师', 4700, 'COOKER', '987 Cedar Rd', '555-0203', 1),
-- 服务员
(201, '张服务员', 3200, 'WAITER', '111 First St', '555-0301', 2),
(202, '李接待', 3300, 'WAITER', '222 Second Ave', '555-0302', 3),
-- 收银员
(301, '赵出纳', 3400, 'CASHIER', '333 Third Rd', '555-0401', 1),
-- 其他员工
(401, '刘清洁', 2800, 'STAFF', '444 Fourth Ln', '555-0501', 3);

-- 3. 填充MenuItem表（添加中文菜品和分类）
INSERT INTO `RestaurantMS`.`MenuItem` (`MenuItemID`, `Name`, `Price`, `Available`)
VALUES
-- 主菜
(1, '意大利披萨', 68.00, 1),
(2, '奶油培根意面', 58.00, 1),
(3, '凯撒沙拉', 38.00, 1),
(4, '烤三文鱼', 98.00, 1),
-- 甜点
(5, '提拉米苏', 36.00, 1),
(6, '巧克力熔岩蛋糕', 42.00, 0),  -- 暂时缺货
-- 饮料
(7, '鲜榨橙汁', 25.00, 1),
(8, '冰美式咖啡', 28.00, 1);

-- 4. 填充Orders表（添加更真实的订单数据）
INSERT INTO `RestaurantMS`.`Orders` (`OrderDate`, `OrderID`, `Customer`)
VALUES
('2025-03-01 12:30:00', 1001, '张先生 (桌号3)'),
('2025-03-01 18:15:00', 1002, '李女士 (桌号5, VIP)'),
('2025-03-02 13:45:00', 1003, '公司聚餐 (包厢A)'),
('2025-03-02 19:30:00', 1004, '王小姐 (桌号2)'),
('2025-03-03 11:30:00', 1005, '外卖订单 #001');

-- 5. 填充OrderMenuItemCooker表（确保厨师职位正确）
-- 先修正103号员工的职位（从COOKER修正为COOKER）
UPDATE `Employee` SET `Position` = 'COOKER' WHERE `EmployeeID` = 103;

-- 现在插入订单-菜品-厨师关联数据
INSERT INTO `RestaurantMS`.`OrderMenuItemCooker` (`OrderID`, `CookerID`, `MenuItemID`)
VALUES
-- 订单1001
(1001, 101, 1),  -- 王大厨做意大利披萨
(1001, 102, 3),  -- 陈师傅做凯撒沙拉
-- 订单1002
(1002, 103, 4),  -- 林厨师做烤三文鱼
(1002, 101, 5),  -- 王大厨做提拉米苏
(1002, 102, 7),  -- 陈师傅准备鲜榨橙汁
-- 订单1003
(1003, 101, 1),  -- 王大厨做意大利披萨
(1003, 101, 2),  -- 王大厨做奶油培根意面
(1003, 103, 3),  -- 林厨师做凯撒沙拉
(1003, 102, 8),  -- 陈师傅准备冰美式咖啡
-- 订单1004
(1004, 102, 2),  -- 陈师傅做奶油培根意面
(1004, 103, 5),  -- 林厨师做提拉米苏
-- 订单1005
(1005, 101, 1),  -- 王大厨做意大利披萨
(1005, 101, 7);  -- 王大厨准备鲜榨橙汁